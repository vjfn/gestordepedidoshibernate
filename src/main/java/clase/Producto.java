package clase;

/**
 * La clase Producto los productos que pueden ser solicitados por el usuario, el nombre del producto,
 * su precio y su cantidad
 */

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio")
    private Double price;

    @Column(name = "cantidad")
    private Integer qty;



    @Override
    public String toString() {
        return name + " / " + price + "€";
    }
}

//public class Producto {
//
//    private Integer id;
//    private String name;
//    private Double price;
//    private Integer qty;
//
//    public Producto(Integer id, String name, Double price, Integer qty) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.qty = qty;
//    }
//
//    public Producto() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Integer getQty() {
//        return qty;
//    }
//
//    public void setQty(Integer qty) {
//        this.qty = qty;
//    }
//
//    @Override
//    public String toString() {
//        return name + " / " + price + "€";
//    }
//}
