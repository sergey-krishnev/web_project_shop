package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.model.ProductDescription;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, String> {
}
