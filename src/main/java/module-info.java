module com.rafaelwassoaski.cronometro_client {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rafaelwassoaski.cronometro_client to javafx.fxml;
    exports com.rafaelwassoaski.cronometro_client;
}
