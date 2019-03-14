package springboot.service;


import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component(value = "dateService")
@WebService
public class DateServiceImpl implements DateService {

    public String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf.format(timestamp);
    }
}
