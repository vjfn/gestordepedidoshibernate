package com.example.gestordepedidoshibernate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase MainApplication es la clase principal de la aplicación JavaFX.
 * Proporciona métodos para cargar diferentes archivos FXML y cambiar las escenas.
 */
public class MainApplication extends Application {

    private static Stage myStage;

    private static Integer widht = 860;

    private static Integer height = 640;
    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), widht, height);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void loadDahsboard() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), widht, height);
            myStage.setTitle("Dashboard");
            myStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadOrderDetail() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("orderDetail.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), widht, height);
            myStage.setTitle("Order Detail");
            myStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void returnLogin(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), widht, height);
            myStage.setTitle("Login");
            myStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        launch();
    }


}