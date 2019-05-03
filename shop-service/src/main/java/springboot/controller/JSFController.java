package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.client.DateClient;
import springboot.dto.ProductDTO;
import springboot.dto.PurchaseDTO;
import springboot.service.ProductDescriptionService;
import springboot.service.PurchaseService;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;



@ViewScoped
@Component(value = "requestController")
public class JSFController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductDescriptionService productDescriptionService;

    private List<ProductDTO> products;

    private ProductDTO product;

    private PurchaseDTO purchase;

    @Autowired
    private DateClient dateClient;

    private String action="1";

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

    public PurchaseDTO getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDTO purchase) {
        this.purchase = purchase;
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
        if (!(purchaseService.findAll().isEmpty())) {
            return purchaseService.findById(Integer.parseInt(getAction()));
        }
        return new PurchaseDTO();
    }

    public String getDate() throws MalformedURLException {
        return dateClient.getDate();
    }


    public String insertRequestAction() {
        productDescriptionService.setCheckedProducts(getPurchase(),getProducts());
        purchaseService.add(getPurchase());
        return "index?faces-redirect=true";
    }

    public String editRequestAction() {
        productDescriptionService.setCheckedProducts(getPurchase(),getProducts());
        purchaseService.update(getPurchase());
        return "index?faces-redirect=true";
    }

    public String aggregateAllProducts(){
        setPurchase(new PurchaseDTO());
        setProducts(productDescriptionService.findAll());
        return "add?faces-redirect=true";
    }

    public String aggregateCheckedProducts(Long id){
        if (!(purchaseService.findAll().isEmpty())) {
            setPurchase(purchaseService.findById(id));
            List<ProductDTO> selectedProducts = getPurchase().getProduct();
            List<ProductDTO> allProducts = productDescriptionService.findAll();
            productDescriptionService.aggregateCheckedProducts(selectedProducts,allProducts);
            setProducts(allProducts);
        }
        return "edit?faces-redirect=true";
    }

    public void adminPage() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("http://localhost:9091/admin-index.jsf");
    }

    public void logout() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("/logout");
    }
}
