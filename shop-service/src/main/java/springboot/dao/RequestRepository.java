package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {

}
