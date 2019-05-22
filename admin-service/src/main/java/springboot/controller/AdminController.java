package springboot.controller;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import springboot.dto.ProductDTO;
import springboot.service.ProductService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@ManagedBean
@ViewScoped
@Component(value = "adminController")
public class AdminController implements Serializable {

    private final ProductService productService;

    private ProductDTO productDTO;

    @Autowired
    public AdminController(ProductService productService) {
        this.productService = productService;
    }


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
//        addImage();
        productService.add(getProductDTO());
        return "admin-index?faces-redirect=true";
    }

//    public void addImage() {
//        ProductDTO productDTO = getProductDTO();
//        productDTO.setImage(state.getUploadedFile().getData());
//    }

//    public void save() {
//        ProductDTO productDTO = getProductDTO();
//        try {
//            productDTO.setImage(ByteArrayHelper.toByteArray(state.getFile().getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        setProductDTO(productDTO);
//    }

    public void listener(FileUploadEvent event) {
        UploadedFile item = event.getUploadedFile();
        ProductDTO productDTO = getProductDTO();
        productDTO.setImage(item.getData());
        setProductDTO(productDTO);
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
