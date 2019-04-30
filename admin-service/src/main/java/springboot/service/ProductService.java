package springboot.service;

import springboot.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();

    ProductDTO getById(long id);

    void add(ProductDTO productDTO);

    void update(ProductDTO productDTO);

    void delete(long id);

}
