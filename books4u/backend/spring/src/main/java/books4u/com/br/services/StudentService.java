package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books4u.com.br.dto.CreatedDto;
import books4u.com.br.dto.student.StudentInsertDto;
import books4u.com.br.entities.Classroom;
import books4u.com.br.entities.Student;
import books4u.com.br.repositories.ClassRepository;
import books4u.com.br.repositories.StudentRepository;
import books4u.com.br.services.exceptions.ResourceNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private ClassRepository classRepository;

	public CreatedDto insert(StudentInsertDto dto) {
		CreatedDto created = new CreatedDto(false);
		Classroom classroom = classRepository.findByClassroomYear(dto.getClassroomNumber());
		if (classroom != null) {
			Student entity = new Student();
			copyDtoToEntity(dto, entity);
			entity.setClassroom(classroom);
			entity = repository.save(entity);
			created.setCreated(true);
		}
		else {
			throw new ResourceNotFoundException("Entity not found: " + dto.getClassroomNumber());
		}
		return created;
	}
	
	public static void copyDtoToEntity(StudentInsertDto dto, Student entity) {
		entity.setIdStudent(dto.getId());
		entity.setStudentFullname(dto.getFullname());
		entity.setStudentEnrollment(dto.getEnrollment());
		entity.setStudentStatus(dto.getStatus());
	}
}
