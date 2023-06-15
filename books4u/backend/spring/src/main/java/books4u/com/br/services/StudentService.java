package books4u.com.br.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import books4u.com.br.dto.CreatedDto;
import books4u.com.br.dto.UpdatedDto;
import books4u.com.br.dto.student.StudentDto;
import books4u.com.br.dto.student.StudentInsertDto;
import books4u.com.br.dto.student.StudentWithClassDto;
import books4u.com.br.entities.Classroom;
import books4u.com.br.entities.Student;
import books4u.com.br.repositories.ClassRepository;
import books4u.com.br.repositories.StudentRepository;
import books4u.com.br.services.exceptions.DatabaseException;
import books4u.com.br.services.exceptions.ResourceNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private ClassRepository classRepository;

	public StudentWithClassDto findByEnrollment(Long enrollment) {
		Student entity = repository.findByStudentEnrollment(enrollment);
		return new StudentWithClassDto(entity, entity.getClassroom());
	}

	public StudentWithClassDto findByName(String name) {
		Student entity = repository.findByStudentFullname(name);
		return new StudentWithClassDto(entity, entity.getClassroom());
	}

	public CreatedDto insert(StudentInsertDto dto) {
		CreatedDto created = new CreatedDto(false);
		Classroom classroom = classRepository.findByClassroomYear(dto.getClassroomNumber());
		if (classroom != null) {
			Student entity = new Student();
			copyInsertDtoToEntity(dto, entity);
			entity.setClassroom(classroom);
			entity = repository.save(entity);
			created.setCreated(true);
		}
		else {
			throw new ResourceNotFoundException("Entity not found: " + dto.getClassroomNumber());
		}
		return created;
	}
	
	public UpdatedDto update(Long id, StudentDto dto) {
		try {
			Student entity = new Student();
			copyDtoToEntity(dto, entity);
			entity.setClassroom(classRepository.save(entity.getClassroom()));
			entity = repository.save(entity);
			return new UpdatedDto(true);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}
	
	public Boolean delete(Long id) {
		try {
			repository.deleteById(id);
			return true;
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	public static void copyInsertDtoToEntity(StudentInsertDto dto, Student entity) {
		entity.setIdStudent(dto.getId());
		entity.setStudentFullname(dto.getFullname());
		entity.setStudentEnrollment(dto.getEnrollment());
		entity.setStudentStatus(dto.getStatus());
	}
	
	public static void copyDtoToEntity(StudentDto dto, Student entity) {
		entity.setIdStudent(dto.getId());
		entity.setStudentFullname(dto.getFullname());
		entity.setStudentEnrollment(dto.getEnrollment());
		entity.setStudentStatus(dto.getStatus());
		entity.setClassroom(new Classroom(dto.getClassroom().getId(), dto.getClassroom().getYear(),
				dto.getClassroom().getShift(), dto.getClassroom().getStatus()));
	}
}
