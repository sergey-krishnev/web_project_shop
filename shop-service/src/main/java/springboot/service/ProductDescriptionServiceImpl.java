package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.converter.DTOHelper;
import springboot.dao.ProductRepository;
import springboot.dto.ProductDTO;
import springboot.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO> findAll() {

        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDescriptions = new ArrayList<>();
        DTOHelper.productDescriptionToProductDescriptionDTO(productList,productDescriptions);
        return productDescriptions;
    }
}
