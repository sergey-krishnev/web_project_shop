package springboot.service;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import java.text.SimpleDateFormat;

@Component
public interface CurrentDateEndpoint {

     String NAMESPACE_URI = "http://localhost:9999/ws/date?wsdl";
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @WebMethod(operationName = "GetCurrentDate")
    @WebResult(name = "Package",targetNamespace=CurrentDateEndpoint.NAMESPACE_URI)
    String getCurrentDate();

}
