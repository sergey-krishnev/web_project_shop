package springboot.service;

import org.springframework.stereotype.Component;
import springboot.converter.DTOHelper;
import springboot.dao.ProductRepository;
import springboot.dto.ProductDTO;
import springboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> products = new ArrayList<>();
        DTOHelper.productDescriptionToProductDescriptionDTO(productList,products);
        return products;
    }

    @Override
    public ProductDTO getById(long id) {
        Product product = productRepository.getOne(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setDate(product.getDate().toString());
        return productDTO;
    }

    @Override
    public void add(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setDate(stringAsDate(productDTO.getDate()));
        product.setImage(productDTO.getImage());
        productRepository.save(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setDate(stringAsDate(productDTO.getDate()));
        product.setImage(productDTO.getImage());
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    private static java.sql.Date stringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }

}
