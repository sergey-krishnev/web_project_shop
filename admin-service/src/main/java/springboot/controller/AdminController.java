package springboot.controller;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import springboot.dto.ProductDTO;
import springboot.service.ProductService;

import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@RequestScoped
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//        maxFileSize = 1024 * 1024 * 10, // 10MB
//        maxRequestSize = 1024 * 1024 * 50)
@Component(value = "adminController")
public class AdminController implements Serializable {

    @Autowired
    private ProductService productService;

    private ProductDTO productDTO;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    public String addForm() {
        setProductDTO(new ProductDTO());
        return "admin-add?faces-redirect=true";
    }

    public String updateForm(long id) {
        setProductDTO(productService.getById(id));
        return "admin-update?faces-redirect=true";
    }

    public String add() {
        productService.add(getProductDTO());
        return "admin-index?faces-redirect=true";
    }

    public String update() {
        productService.update(getProductDTO());
        return "admin-index?faces-redirect=true";
    }

    public String delete(long id) {
        try {
            productService.delete(id);
            return "admin-index?faces-redirect=true";
        } catch (DataIntegrityViolationException e) {
            return "admin-error?faces-redirect=true";
        }
    }

    public void getUserPage() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("http://localhost:9090/index.jsf");
    }

    public void logout() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("/logout");
    }

    public void paint(OutputStream out, Object data) throws IOException {
        ProductDTO image = (ProductDTO)data;
        ImageIO.write(createImageFromBytes(image.getImage()), "jpg", out);
    }

    private BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
