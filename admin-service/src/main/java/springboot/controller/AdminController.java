package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.dto.ProductDTO;
import springboot.service.ProductService;

import javax.faces.bean.RequestScoped;
import java.util.List;

@RequestScoped
@Component(value = "adminController")
public class AdminController {

    @Autowired
    ProductService productService;

    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }


    public String addForm() {
        return "";
    }

    public void add(ProductDTO productDTO) {
        productService.add(productDTO);
    }

}
