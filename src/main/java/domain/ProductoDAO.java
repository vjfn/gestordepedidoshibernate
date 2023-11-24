package domain;

import clase.Producto;
/**
 * La interfaz ProductoDAO contiene los métodos para acceder a los datos de los elementos (Producto).
 */
public interface ProductoDAO {

    public Producto loadProduct(Integer id);
}
