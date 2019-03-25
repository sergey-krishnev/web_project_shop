package springboot.service;

import springboot.dto.ProductDTO;

import java.util.List;

public interface ProductDescriptionService {

    List<ProductDTO> findAll();

}
