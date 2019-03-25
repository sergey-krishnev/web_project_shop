package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springboot.client.DateClient;
import springboot.dto.ProductDTO;
import springboot.dto.PurchaseDTO;
import springboot.service.ProductDescriptionService;
import springboot.service.PurchaseService;

import javax.faces.context.FacesContext;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Scope(value = "session")

@Component(value = "requestController")
//@Join(path = "/request", to = "/index.jsf")
public class JSFController {

    private Long id;

    private String customerName;

    private String customerAddress;

    private String sum;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductDescriptionService productDescriptionService;

    private List<ProductDTO> products;

    private ProductDTO product;

    @Autowired
    private DateClient dateClient;

    private String action="1";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public List<ProductDTO> getProducts() {
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

    public List<PurchaseDTO> getRequests() {
        return purchaseService.findAll();
    }

    public PurchaseDTO getRequest() {
        return purchaseService.findById(Integer.parseInt(getAction()));
    }

    public String getDate() throws MalformedURLException {
        return dateClient.getDate();
    }


    public String insertRequestAction() {
        PurchaseDTO request = new PurchaseDTO();
        request.setCustomerName(getCustomerName());
        request.setCustomerAddress(getCustomerAddress());
        request.setSum(Integer.parseInt(getSum()));

        setCheckedProducts(request);
        purchaseService.add(request);
        return "index?faces-redirect=true";
    }

    public String editRequestAction() {
        PurchaseDTO request = new PurchaseDTO();
        request.setId(getId());
        request.setCustomerName(getCustomerName());
        request.setCustomerAddress(getCustomerAddress());
        request.setSum(Integer.parseInt(getSum()));

        setCheckedProducts(request);
        purchaseService.update(request);
        return "index?faces-redirect=true";
    }

    public void setCheckedProducts(PurchaseDTO request) {
        List<ProductDTO> productDTOList = getProducts();
        List<ProductDTO> selectedProducts = new ArrayList<>();
        for (ProductDTO product : productDTOList) {
            if (product.isSelected()) {
                selectedProducts.add(product);
            }
        }
        request.setProduct(selectedProducts);
    }

    public String aggregateAllProducts(){
        cleanRequestFields();
        setProducts(productDescriptionService.findAll());
        return "add?faces-redirect=true";
    }

    public String aggregateCheckedProducts(Long id){
        PurchaseDTO purchaseDTO = purchaseService.findById(id);
        fillRequestFields(purchaseDTO);
        List<ProductDTO> selectedProducts = purchaseDTO.getProduct();
        List<ProductDTO> allProducts = productDescriptionService.findAll();
        for (int i=0;i<allProducts.size();i++) {
            for (ProductDTO productDTO : selectedProducts) {
                if (productDTO.getId().equals(allProducts.get(i).getId())) {
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

    public void fillRequestFields(PurchaseDTO purchaseDTO) {
        setId(purchaseDTO.getId());
        setCustomerName(purchaseDTO.getCustomerName());
        setCustomerAddress(purchaseDTO.getCustomerAddress());
        setSum(String.valueOf(purchaseDTO.getSum()));
    }
}
