
package tn.enicarthage.banque;

import jakarta.xml.ws.Endpoint;

public class BanquePublisher {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/BanqueWS";

        Endpoint.publish(url, new BanqueService());

        System.out.println("SOAP Web Service is running!");
        System.out.println("WSDL: http://localhost:8080/BanqueWS?wsdl");
    }
}
