package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.PublishingCompany;

@Repository
public interface PublishingCompanyRepository extends JpaRepository<PublishingCompany, Long>{
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_publishing_companies "
			+ "WHERE publishing_company_name = :name "
			+ "LIMIT 1")
	PublishingCompany findOnePublishingCompanyByName(String name);
}
