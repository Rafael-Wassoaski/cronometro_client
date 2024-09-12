package com.rafaelwassoaski.cronometro_client;

import java.io.IOException;
import java.net.InetAddress;
import java.util.regex.Pattern;
import com.rafaelwassoaski.cronometro_client.socket.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private TextField ipAddress;
    @FXML
    private Text invalidIp;
    
    private static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
    private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);



    @FXML
    public void setIpAddress() throws IOException {
        String ipServerAddress = ipAddress.getText();
        System.out.println("IP " + ipServerAddress);
        if (ipServerAddress == null) {
            this.invalidIp.setVisible(true);
            return;
        }
 
        if (!IPv4_PATTERN.matcher(ipServerAddress).matches()) {
            this.invalidIp.setVisible(true);

            return;
        }


        Client.setServerAddress(ipServerAddress);
        App.setRoot("secondary");

    }
}
