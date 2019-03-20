package springboot.service;

import springboot.dto.ProductDescriptionDTO;

import java.util.List;

public interface ProductDescriptionService {

    List<ProductDescriptionDTO> findAll();

}
