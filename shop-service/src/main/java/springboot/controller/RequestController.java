package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springboot.client.DateClient;
import springboot.model.ProductDescription;
import springboot.model.Request;
import springboot.service.RequestService;

import javax.faces.context.FacesContext;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@Scope(value = "session")
@Component(value = "requestController")
//@Join(path = "/request", to = "/index.jsf")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private DateClient dateClient;

//    String action = "1";
//
//    //action listener event
//    public void attrListener(ActionEvent event){
//
//        action = (String) event.getComponent().getAttributes().get("action");
//
//    }

    private String action="1";

    public String getAction() {
        return action;
    }

    public void setAction() {
        Map<String,String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.action = params.get("action");
    }

    public List<Request> getRequests() {
        return requestService.findAll();
    }

    public Request getRequest() {
        return requestService.findById(Integer.parseInt(getAction()));
    }

//    public RequestDetails getRequestDetails() {
//        return requestService.findById(Integer.parseInt(action));
//    }
    public String getDate() throws MalformedURLException {
        return dateClient.getDate();
    }
}
