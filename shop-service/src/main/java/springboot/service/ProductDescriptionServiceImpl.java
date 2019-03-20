package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dao.ProductDescriptionRepository;
import springboot.model.ProductDescription;

import java.util.List;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    @Autowired
    ProductDescriptionRepository productDescriptionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductDescription> findAll() {
        return productDescriptionRepository.findAll();
    }
}
