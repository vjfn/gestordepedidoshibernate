package domain;

import clase.Item;

import java.util.ArrayList;

/**
 * La interfaz ItemDAO contiene los métodos para acceder a los datos de los elementos (Item).
 */
public interface ItemDAO {
    public ArrayList<Item> loadAll(Integer codigoPedido);
}
