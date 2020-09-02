package com.sebolaila;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button btnVisualizarLivros;

    @FXML
    private Button btnCadastrarLivro;

    @FXML
    private Button btnCadastrarPessoa;


    // o que faz mudar de tela
    @FXML
    private void setBtnCadastrarLivro() throws IOException{
        App.setRoot("secondary");
    }
}
