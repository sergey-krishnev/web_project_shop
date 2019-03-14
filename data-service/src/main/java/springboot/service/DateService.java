package springboot.service;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebResult;

public interface DateService {

    @WebMethod
    String getCurrentDate();
}
