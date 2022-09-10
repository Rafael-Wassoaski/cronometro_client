package com.rafaelwassoaski.cronometro_client;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        System.out.println("Teste");
        App.setRoot("secondary");
    }
}
