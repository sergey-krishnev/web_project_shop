package springboot.service;

import springboot.dto.ProductDTO;
import springboot.dto.PurchaseDTO;
import springboot.model.Product;

import java.util.List;

public interface ProductDescriptionService {

    List<ProductDTO> findAll();

    void setCheckedProducts(PurchaseDTO purchase, List<ProductDTO> productDTOList);

    void aggregateCheckedProducts(List<ProductDTO> selectedProducts, List<ProductDTO> allProducts);

}
