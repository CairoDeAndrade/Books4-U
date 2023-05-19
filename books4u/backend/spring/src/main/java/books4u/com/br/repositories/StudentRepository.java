package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import books4u.com.br.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
