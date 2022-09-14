module com.rafaelwassoaski.cronometro_client {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;

    opens com.rafaelwassoaski.cronometro_client to javafx.fxml;
    exports com.rafaelwassoaski.cronometro_client;
}
