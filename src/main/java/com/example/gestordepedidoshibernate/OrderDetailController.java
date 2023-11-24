package com.example.gestordepedidoshibernate;

import clase.Item;
import clase.Sesion;
import domain.DBConnection;
import domain.PedidoDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase OrderDetailControler controla la lógica de la ventana del pedido seleccionado.
 */
public class OrderDetailController implements Initializable
{
    @javafx.fxml.FXML
    private TableView orderDetailTable;
    @javafx.fxml.FXML
    private TableColumn<Item, String> orderLineID;
    @javafx.fxml.FXML
    private TableColumn<Item, String> orderPedidoId;
    @javafx.fxml.FXML
    private TableColumn<Item, String> orderLineQty;
    @javafx.fxml.FXML
    private TableColumn<Item, String> orderProductID;
    @javafx.fxml.FXML
    private Button btnReturn;
    @javafx.fxml.FXML
    private ObservableList<Item> observableListItem;
    @javafx.fxml.FXML
    private MenuItem btnLogOut;

    @javafx.fxml.FXML
    public void returnAction(ActionEvent actionEvent) {
        MainApplication.loadDahsboard();
    }

    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) { MainApplication.returnLogin(); }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        orderLineID.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });
        orderPedidoId.setCellValueFactory((fila) -> {
            String pedidoId = String.valueOf(fila.getValue().getPedido_id());
            return new SimpleStringProperty(pedidoId);
        });
        orderLineQty.setCellValueFactory((fila) -> {
            String qty = String.valueOf(fila.getValue().getQty());
            return new SimpleStringProperty(qty);
        });
        orderProductID.setCellValueFactory((fila) -> {
            String productoId = String.valueOf(fila.getValue().getProducto_id());
            return new SimpleStringProperty(productoId);
        });


        observableListItem = FXCollections.observableArrayList();
        PedidoDAOImp dao = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(dao.loadAll(Sesion.getUsuario().getId()));
        observableListItem.addAll(Sesion.getItems());
        orderDetailTable.setItems(observableListItem);


    }
}