package springboot.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springboot.model.ProductDescription;
import springboot.model.Request;
import springboot.service.RequestService;

import java.util.List;

@Scope(value = "session")
@Component(value = "requestController")
@ELBeanName(value = "requestController")
//@Join(path = "/request", to = "/index.jsf")
public class RequestController {

    @Autowired
    private RequestService requestService;

//    String action = "1";
//
//    //action listener event
//    public void attrListener(ActionEvent event){
//
//        action = (String) event.getComponent().getAttributes().get("action");
//
//    }

    public List<Request> getRequests() {
        return requestService.findAll();
    }

    public Request getRequest() {
        return requestService.findById(1);
    }

//    public RequestDetails getRequestDetails() {
//        return requestService.findById(Integer.parseInt(action));
//    }
}
