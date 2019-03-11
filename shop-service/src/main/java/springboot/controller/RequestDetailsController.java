package springboot.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springboot.model.RequestDetails;
import springboot.service.RequestService;
import java.util.List;

@Scope(value = "session")
@Component(value = "requestDetailsController")
@ELBeanName(value = "requestDetailsController")
@Join(path = "/request", to = "/index.jsf")
public class RequestDetailsController {

    @Autowired
    private RequestService requestService;

//    private RequestDetails requestDetails = new RequestDetails();

    public List<RequestDetails> getRequestsDetails() {
        return requestService.findAll();
    }

    public RequestDetails getRequestDetails() {
        return requestService.getOne(1);
    }
}
