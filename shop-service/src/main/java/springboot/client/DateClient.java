package springboot.client;

import org.springframework.stereotype.Service;
import springboot.service.DateServiceImpl;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class DateClient {

    public String getDate() throws MalformedURLException {

        URL url = new URL("http://localhost:8080/date?wsdl");
        QName qname = new QName("http://service.springboot/", "DateServiceImplService");

        javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);

        DateServiceImpl date = service.getPort(DateServiceImpl.class);


        return date.getCurrentDate();
    }

}
