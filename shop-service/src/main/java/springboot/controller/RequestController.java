package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springboot.client.DateClient;
import springboot.dto.RequestDTO;
import springboot.model.ProductDescription;
import springboot.model.Request;
import springboot.service.ProductDescriptionService;
import springboot.service.RequestService;

import javax.faces.context.FacesContext;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Scope(value = "session")

@Component(value = "requestController")
//@Join(path = "/request", to = "/index.jsf")
public class RequestController {

    private String customerName;

    private String customerAddress;

    private String sum;

    @Autowired
    private RequestService requestService;

    @Autowired
    private ProductDescriptionService productDescriptionService;

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

    public String getAction() {
        return action;
    }

    public void setAction() {
        Map<String,String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.action = params.get("action");
    }

    public List<RequestDTO> getRequests() {
        return requestService.findAll();
    }

    public RequestDTO getRequest() {
        return requestService.findById(Integer.parseInt(getAction()));
    }

    public List<ProductDescription> getProducts() {
        return productDescriptionService.findAll();
    }

    public String getDate() throws MalformedURLException {
        return dateClient.getDate();
    }

    public void insertRequestAction() {
        RequestDTO request = new RequestDTO();
        request.setCustomerName(getCustomerName());
        request.setCustomerAddress(getCustomerAddress());
        request.setSum(Integer.parseInt(getSum()));
        requestService.addRequest(request);
    }
}
