package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByStudentEnrollment(Long studentEnrollment);

	Student findByStudentFullname(String name);
}
