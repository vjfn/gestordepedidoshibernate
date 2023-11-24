package clase;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;


/**
 * La clase Item es un elemento de un pedido que contiene información sobre el pedido, el producto y la cantidad.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lineapedido")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "producto_id")
    private Integer productoId;

    // Getters y setters

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", pedidoId='" + pedidoId + '\'' +
                ", qty=" + qty +
                ", productoId=" +this.productoId +
                '}';
    }
}

//public class Item {
//
//    private Integer id;
//    private String pedidoId;
//    private Integer qty;
//    private Integer productoId;
//
//
//    public Item(Integer id, String pedidoId, Integer qty, Integer productoId) {
//        this.id = id;
//        this.pedidoId = pedidoId;
//        this.qty = qty;
//        this.productoId = productoId;
//    }
//
//    public Item(){
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
//    public String getPedido_id() {
//        return pedidoId;
//    }
//
//    public void setPedidoId(String pedidoId) {
//        this.pedidoId = pedidoId;
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
//    public Integer getProducto_id() {
//        return this.productoId;
//    }
//
//    public void setProducto_id(Integer productoId) {
//        this.productoId = productoId;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", pedidoId='" + pedidoId + '\'' +
//                ", qty=" + qty +
//                ", productoId=" +this.productoId +
//                '}';
//    }
//}
