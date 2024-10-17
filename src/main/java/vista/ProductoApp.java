package vista;

import java.io.IOException;

import excepciones.ProductoNoEncontradoException;
import modelo.Producto;
import servicios.ProductoServicio;

public class ProductoApp {
  public static void main(String[] args) throws IOException, InterruptedException, ProductoNoEncontradoException {

    ProductoServicio ps = new ProductoServicio();

    Producto[] productos = ps.getAllProductos();

    for(Producto p : productos){
      System.out.println(p);
    }

    System.out.println("-------------------------------------------\n");

    // Producto prod = ps.getProductoId(1);
    // System.out.println(prod);
  }
}
