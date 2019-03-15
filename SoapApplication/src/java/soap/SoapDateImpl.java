package soap;

import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebService(endpointInterface = "soap.SoapService")
public class SoapDateImpl implements SoapService {

    @Override
    public String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();
        return format.format(date);
    }

}
