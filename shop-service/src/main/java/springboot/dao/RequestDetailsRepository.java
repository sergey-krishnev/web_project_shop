package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.model.RequestDetails;

public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Integer> {

}
