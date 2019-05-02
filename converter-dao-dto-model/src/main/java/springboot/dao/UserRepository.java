package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);

}
