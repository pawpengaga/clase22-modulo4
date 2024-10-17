import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import excepciones.ProductoNoEncontradoException;
import modelo.Producto;
import servicios.ProductoServicio;

public class ProductoServicioTest {

  private final ProductoServicio ps = new ProductoServicio();
  
  @Test
  @DisplayName("Que todos los productos esten ok")
  public void testGetAllProductos_Success() throws Exception{
    System.out.println("Probando todos los productos del array...\n");
    
    Producto[] productos = ps.getAllProductos();
    assertNotNull(productos);
    // Que existan productos en el array
    assertTrue(productos.length > 0);
    // Que los productos sean iguales a 49
    assertTrue(productos.length == 49);

  }

  @Test
  @DisplayName("Que al sacar un producto por su id salga")
  public void testGetProductosByTd_Success() throws ProductoNoEncontradoException, IOException, InterruptedException {
    System.out.println("Probando producto por ID...\n");
    
    Producto producto = ps.getProductoId(3);
    assertNotNull(producto);
    assertEquals(3, producto.getId());

  }

  @Test
  @DisplayName("Que la excepcion salga correctamente")
  public void testGetProductoById_NotFound(){
    System.out.println("Probando mensajes de error por ID...\n");

    ProductoNoEncontradoException exc = assertThrows(ProductoNoEncontradoException.class, ()->{
      ps.getProductoId(999);
    });
    // El mensaje de producto no encontrado por ID.
    assertEquals("Producto no encontrado.", exc.getMessage());
  }

}
