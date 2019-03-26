package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.converter.DTOHelper;
import springboot.dao.ProductRepository;
import springboot.dto.ProductDTO;
import springboot.dto.PurchaseDTO;
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

    @Override
    public void setCheckedProducts(PurchaseDTO purchase, List<ProductDTO> productDTOList) {
        List<ProductDTO> selectedProducts = new ArrayList<>();
        for (ProductDTO product : productDTOList) {
            if (product.isSelected()) {
                selectedProducts.add(product);
            }
        }
        purchase.setProduct(selectedProducts);
    }

    @Override
    public void aggregateCheckedProducts(List<ProductDTO> selectedProducts, List<ProductDTO> allProducts) {
        for (int i=0;i<allProducts.size();i++) {
            for (ProductDTO productDTO : selectedProducts) {
                if (productDTO.getId().equals(allProducts.get(i).getId())) {
                    allProducts.get(i).setSelected(true);
                }
            }
        }
    }
}
