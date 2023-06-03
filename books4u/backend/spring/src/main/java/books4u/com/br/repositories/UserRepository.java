package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT obj FROM User obj "
			+ "WHERE obj.userEmail = :email AND obj.userPassword = :password")
	User checkUserAuthentication(String email, String password);
}
