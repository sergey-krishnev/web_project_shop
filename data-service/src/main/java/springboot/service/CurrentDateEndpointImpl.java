package springboot.service;


import javax.jws.WebService;
import javax.ws.rs.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Path("/ws/date")
@WebService(name="service", targetNamespace=CurrentDateEndpoint.NAMESPACE_URI)
public class CurrentDateEndpointImpl implements CurrentDateEndpoint {

    @Override
    public String getCurrentDate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf.format(timestamp);
    }
}
