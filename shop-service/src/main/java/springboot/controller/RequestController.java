package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springboot.client.DateClient;
import springboot.model.ProductDescription;
import springboot.model.Request;
import springboot.service.RequestService;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@Scope(value = "session")

@Component(value = "requestController")
//@Join(path = "/request", to = "/index.jsf")
public class RequestController {

    private String customerName;

    private String customerAddress;

    private String sum;

    private String description;

    @Autowired
    private RequestService requestService;

    @Autowired
    private DateClient dateClient;

    private String action="1";

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getDate() throws MalformedURLException {
        return dateClient.getDate();
    }

    public void insertAction() {
        Request request = new Request();
        request.setCustomerName(getCustomerName());
        request.setCustomerAddress(getCustomerAddress());
        request.setSum(Integer.parseInt(getSum()));
        requestService.addRequest(request);
    }
}
