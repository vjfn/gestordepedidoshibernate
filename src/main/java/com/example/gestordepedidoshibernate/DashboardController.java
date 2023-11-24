package com.example.gestordepedidoshibernate;

import clase.HibernateUtil;
import clase.Item;
import clase.Pedido;
import clase.Sesion;
import domain.DBConnection;
import domain.PedidoDAOImp;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * La clase DashboardController controla la lógica de la ventana de pedidos.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DashboardController implements Initializable {


    @javafx.fxml.FXML
    private MenuItem btnLogOut;
    @javafx.fxml.FXML
    private Label labelNombreUsuario;
    private ObservableList<Pedido> observablePedidos;
    @javafx.fxml.FXML
    private TableView ordersTable;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderId;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderCodigo;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderDate;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderUsuarioId;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> orderTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelNombreUsuario.setText("Bienvenido: " + Sesion.getUsuario().getName() + "!!");

        orderId.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });
        orderCodigo.setCellValueFactory((fila) -> {
            String codigo = String.valueOf(fila.getValue().getCodigo());
            return new SimpleStringProperty(codigo);
        });
        orderDate.setCellValueFactory((fila) -> {
            String date = String.valueOf(fila.getValue().getDate());
            return new SimpleStringProperty(date);
        });
        orderUsuarioId.setCellValueFactory((fila) -> {
            String name = String.valueOf(fila.getValue().getUsuario().getName());
            return new SimpleStringProperty(name);
        });
        orderTotal.setCellValueFactory((fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });

        observablePedidos = FXCollections.observableArrayList();
        // Utiliza Hibernate para cargar los pedidos
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Aquí debes tener un método en tu clase DAO para cargar los pedidos utilizando Hibernate
            PedidoDAOImp dao = new PedidoDAOImp((Connection) session);
            Sesion.setPedidos(dao.loadAll(Sesion.getUsuario().getId()));
            observablePedidos.addAll(Sesion.getPedidos());

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        ordersTable.setItems(observablePedidos);

        ordersTable.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            seleccionarPedido((Pedido) ordersTable.getSelectionModel().getSelectedItem());
        });
    }

    private void seleccionarPedido(Pedido pedido) {
        Sesion.setFocusedOrder(pedido);
        Sesion.setItems((ArrayList<Item>) pedido.getItems());
        MainApplication.loadOrderDetail();
    }

    @FXML
    public void logOut(ActionEvent actionEvent) {
        MainApplication.returnLogin();
    }


//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//
//
//        labelNombreUsuario.setText("Bienvenido: " + Sesion.getUsuario().getName() + "!!");
//
//        orderId.setCellValueFactory((fila) -> {
//            String id = String.valueOf(fila.getValue().getId());
//            return new SimpleStringProperty(id);
//        });
//        orderCodigo.setCellValueFactory((fila) -> {
//            String codigo = String.valueOf(fila.getValue().getCodigo());
//            return new SimpleStringProperty(codigo);
//        });
//        orderDate.setCellValueFactory((fila) -> {
//            String date = String.valueOf(fila.getValue().getDate());
//            return new SimpleStringProperty(date);
//        });
//        orderUsuarioId.setCellValueFactory((fila) -> {
//            String usuario_id = String.valueOf(fila.getValue().getUsuarioId());
//            return new SimpleStringProperty(usuario_id);
//        });
//        orderTotal.setCellValueFactory((fila) -> {
//            String total = String.valueOf(fila.getValue().getTotal());
//            return new SimpleStringProperty(total);
//        });
//
//        observablePedidos = FXCollections.observableArrayList();
//        PedidoDAOImp dao = new PedidoDAOImp(DBConnection.getConnection());
//        Sesion.setPedidos(dao.loadAll(Sesion.getUsuario().getId()));
//        observablePedidos.addAll(Sesion.getPedidos());
//        ordersTable.setItems(observablePedidos);
//
//        ordersTable.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
//            seleccionarPedido((Pedido) ordersTable.getSelectionModel().getSelectedItem());
//        });
//
//    }
//
//    private void seleccionarPedido(Pedido pedido) {
//        Sesion.setFocusedOrder(pedido);
//        Sesion.setItems(pedido.getItems());;
//        MainApplication.loadOrderDetail();
//    }
//
//    @javafx.fxml.FXML
//    public void logOut(ActionEvent actionEvent) { MainApplication.returnLogin(); }

}
