package books4u.com.br.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByStudentEnrollment(Long studentEnrollment);
	
	@Query("SELECT obj FROM Student obj"
			+ " WHERE obj.studentFullname LIKE %:name%"
			+ " ORDER BY obj.studentFullname ASC")
	List<Student> findByFullname(String name);
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_students "
			+ "ORDER BY student_fullname ASC LIMIT :amount")
	List<Student> findAllDynamic(Integer amount);
}
