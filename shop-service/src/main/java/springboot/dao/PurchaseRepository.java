package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
