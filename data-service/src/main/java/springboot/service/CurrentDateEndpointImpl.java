package springboot.service;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Endpoint
public class CurrentDateEndpointImpl implements CurrentDateEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/xml/date";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CurrentDateRequest")
    @ResponsePayload
    public String getCurrentDate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf.format(timestamp);
    }
}
