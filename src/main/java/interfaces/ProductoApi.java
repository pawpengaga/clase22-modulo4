package interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import excepciones.ProductoNoEncontradoException;
import modelo.Producto;

public interface ProductoApi {
  Producto[] getAllProductos() throws ProductoNoEncontradoException; // Conseguimos todos los productos
  Producto getProductoId(int id) throws ProductoNoEncontradoException, JsonMappingException, JsonProcessingException; // Vamos a conseguir los productos por su id
}
