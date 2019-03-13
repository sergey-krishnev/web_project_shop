package springboot.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class DateClient extends WebServiceGatewaySupport {

    public String getCurrentDate() {
        Object responce = null;
        String date = (String) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/date", responce,
                new SoapActionCallback(
                        "http://localhost:8080/xml/date/getCurrentDate"));
        return date;
    }
}
