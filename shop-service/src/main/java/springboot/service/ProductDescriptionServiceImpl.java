package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.converter.DTOHelper;
import springboot.dao.ProductDescriptionRepository;
import springboot.dto.ProductDescriptionDTO;
import springboot.model.ProductDescription;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    @Autowired
    ProductDescriptionRepository productDescriptionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductDescriptionDTO> findAll() {

        List<ProductDescription> productDescriptionList = productDescriptionRepository.findAll();
        List<ProductDescriptionDTO> productDescriptions = new ArrayList<>();
        DTOHelper.productDescriptionToProductDescriptionDTO(productDescriptionList,productDescriptions);
        return productDescriptions;
    }
}
