import soap.SoapDateImpl;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {

        System.out.println("Server started");
        Endpoint.publish("http://localhost:8080/ws/date", new SoapDateImpl());
    }

}
