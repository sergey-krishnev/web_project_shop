package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
