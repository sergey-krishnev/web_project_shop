package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
