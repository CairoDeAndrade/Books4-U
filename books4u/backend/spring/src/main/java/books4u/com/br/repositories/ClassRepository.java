package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Classroom;

@Repository
public interface ClassRepository extends JpaRepository<Classroom, Long>{
	
	Classroom findByClassroomYear(Integer classroomYear);
}
