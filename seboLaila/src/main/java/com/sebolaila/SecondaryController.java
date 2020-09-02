package com.sebolaila;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SecondaryController {

    @FXML
    private Pane tfAutor;

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfGenero;

    @FXML
    private TextField tfEditora;

    @FXML
    private TextField tfEstado;

    @FXML
    private TextField tfValor;

    @FXML
    private TextField tfAno;

    @FXML
    private Button btnSalvar;

    // o que faz mudar de tela
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("main");
    }
}