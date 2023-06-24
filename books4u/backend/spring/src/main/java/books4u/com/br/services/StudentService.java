package books4u.com.br.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true)
	public List<StudentDto> finadAllDynamic(Integer amount){
		List<Student> list = repository.findAllDynamic(amount);
		return list.stream().map(x -> new StudentDto(x, x.getClassroom())).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public StudentWithClassDto findByEnrollment(Long enrollment) {
		Student entity = repository.findByStudentEnrollment(enrollment);
		return new StudentWithClassDto(entity, entity.getClassroom());
	}
	@Transactional(readOnly = true)
	public List<StudentWithClassDto> findByName(String name) {
		List<Student> list = repository.findByFullname(name);
		return list.stream().map(x -> new StudentWithClassDto(x, x.getClassroom())).collect(Collectors.toList());
	}

	public Boolean insert(StudentInsertDto dto) {
		try {
			Classroom classroom = classRepository.findByClassroomYear(dto.getClassroomNumber());
			Student entity = new Student();
			copyInsertDtoToEntity(dto, entity);
			entity.setClassroom(classroom);
			entity = repository.save(entity);
			return true;
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found: " + dto.getClassroomNumber());
		}
	}
	
	public UpdatedDto update(Long id, StudentDto dto) {
		try {
			Student entity = new Student();
			copyDtoToEntity(dto, entity);
			entity.setClassroom(classRepository.findByClassroomYear(dto.getClassroom().getYear()));
			if (entity.getClassroom() == null) {
				throw new DatabaseException("Sala selecionada não existe");
			}
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
