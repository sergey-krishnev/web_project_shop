package springboot.controller;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.dto.ProductDTO;

import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@RequestScoped
@Component("uploadController")
public class UploadController implements Serializable {

    @Autowired
    AdminController adminController;

    public void listener(FileUploadEvent event) {
        UploadedFile item = event.getUploadedFile();
        ProductDTO productDTO = adminController.getProductDTO();
        productDTO.setImage(item.getData());
        System.out.println("test");
        adminController.setProductDTO(productDTO);
    }

}
