package springboot.client;

import org.springframework.stereotype.Component;

@Component
public class DateClient {

    public String getDate() throws Exception {

//        GetCurrentDateImplService service = new GetCurrentDateImplService();
//        GetCurrentDate date  = service.getSoapDateImplPort();
//        return soapDate.getDate();

//
//        URL url = new URL("http://localhost:9999/ws/date?wsdl");
//
//        QName qname = new QName("http://localhost/", "SoapDateImplService");
//
//        Service service = Service.create(url, qname);
//
//        SoapDate date = service.getPort(SoapDate.class);

        return "String";

    }
}

