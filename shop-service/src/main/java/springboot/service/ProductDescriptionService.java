package springboot.service;

import springboot.model.ProductDescription;

import java.util.List;

public interface ProductDescriptionService {

    List<ProductDescription> findAll();

}
