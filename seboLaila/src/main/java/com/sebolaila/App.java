package com.sebolaila;

import com.sebolaila.dao.LivrosDAO;
import com.sebolaila.entity.Livros;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        Livros livros = new Livros();
        livros.setTitulo("Harry Potter");
        livros.setAutor("J.K Rowlling");
        livros.setEditora("Rocco");
        livros.setAno(2010);
        livros.setGenero("Fantasia");
        livros.setEstado("Semi-novo");

        LivrosDAO livrosDAO = new LivrosDAO();
        livrosDAO.save(livros);

        launch();
    }
}