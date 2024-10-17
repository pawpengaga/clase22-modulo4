package servicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import excepciones.ProductoNoEncontradoException;
import interfaces.ProductoApi;
import modelo.Producto;

public class ProductoServicio implements ProductoApi {
  private static final String API_URL = "https://fakestoreapi.com/products";
  private final HttpClient client;
  private final ObjectMapper objectMapper;

  public ProductoServicio(){
    this.client = HttpClient.newHttpClient();
    this.objectMapper = new ObjectMapper();
  }

  @Override
  public Producto[] getAllProductos() throws ProductoNoEncontradoException {

    try {
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).GET().build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
  
      if (response.statusCode() == 200){
        return objectMapper.readValue(response.body(), Producto[].class);
      } else {
        throw new RuntimeException("Error recuperando productos: " + response.statusCode());
      }
    } catch (Exception e) {
      throw new ProductoNoEncontradoException("Error de API "+e.getMessage());
    }

  }

  @Override
  public Producto getProductoId(int id) throws ProductoNoEncontradoException {
    try {
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL + "/" + id)).GET().build();
      HttpResponse<String> response;

      response = client.send(request, HttpResponse.BodyHandlers.ofString());
  
      if (response.statusCode() == 200){
        return objectMapper.readValue(response.body(), Producto.class);
      } else {
        throw new RuntimeException("Error recuperando productos: " + response.statusCode());
      }
    } catch (Exception e) {
      throw new ProductoNoEncontradoException("Producto no encontrado.");
    }
  }
}
