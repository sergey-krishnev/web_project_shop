package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springboot.client.DateClient;
import springboot.dto.ProductDescriptionDTO;
import springboot.dto.RequestDTO;
import springboot.service.ProductDescriptionService;
import springboot.service.RequestService;

import javax.faces.context.FacesContext;
import java.net.MalformedURLException;
import java.util.ArrayList;
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

    private List<ProductDescriptionDTO> products;

    private ProductDescriptionDTO product;

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

    public void setProducts(List<ProductDescriptionDTO> products) {
        this.products = products;
    }

    public ProductDescriptionDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDescriptionDTO product) {
        this.product = product;
    }

    public List<ProductDescriptionDTO> getProducts() {
        return products;
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

    public String getDate() throws MalformedURLException {
        return dateClient.getDate();
    }


    public String insertRequestAction() {
        RequestDTO request = new RequestDTO();
        request.setCustomerName(getCustomerName());
        request.setCustomerAddress(getCustomerAddress());
        request.setSum(Integer.parseInt(getSum()));

        setCheckedProducts(request);
        requestService.addRequest(request);
        return "index?faces-redirect=true";
    }

    public void setCheckedProducts(RequestDTO request) {
        List<ProductDescriptionDTO> productDescriptionDTOList = getProducts();
        List<ProductDescriptionDTO> selectedProducts = new ArrayList<>();
        for (ProductDescriptionDTO product : productDescriptionDTOList) {
            if (product.isSelected()) {
                selectedProducts.add(product);
            }
        }
        request.setProductDescriptions(selectedProducts);
    }

    public String aggregateAllProducts(){
        cleanRequestFields();
        setProducts(productDescriptionService.findAll());
        return "add?faces-redirect=true";
    }

    public String aggregateCheckedProducts(Long id){
        RequestDTO requestDTO = requestService.findById(id);
        fillRequestFields(requestDTO);
        List<ProductDescriptionDTO> selectedProducts = requestDTO.getProductDescriptions();
        List<ProductDescriptionDTO> allProducts = productDescriptionService.findAll();
        for (int i=0;i<allProducts.size();i++) {
            for (ProductDescriptionDTO productDescriptionDTO : selectedProducts) {
                if (productDescriptionDTO.getId().equals(allProducts.get(i).getId())) {
                    allProducts.get(i).setSelected(true);
                }
            }
        }
        setProducts(allProducts);
        return "edit?faces-redirect=true";
    }

    public void cleanRequestFields() {
        setCustomerName("");
        setCustomerAddress("");
        setSum("");
    }

    public void fillRequestFields(RequestDTO requestDTO) {
        setCustomerName(requestDTO.getCustomerName());
        setCustomerAddress(requestDTO.getCustomerAddress());
        setSum(String.valueOf(requestDTO.getSum()));
    }
}
