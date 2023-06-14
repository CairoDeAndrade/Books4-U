package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.classroom.ClassroomInsertDto;
import books4u.com.br.entities.Classroom;
import books4u.com.br.repositories.ClassRepository;

@Service
public class ClassroomService {
	
	@Autowired
	private ClassRepository repository;
	
	@Transactional
	public ClassroomInsertDto insert(ClassroomInsertDto dto) {
		Classroom entity = new Classroom();
		entity.setClassroomYear(dto.getClassroomYear());
		entity.setClassroomShift(dto.getClassroomShift());
		entity.setClassroomStatus(dto.getClassroomStatus());
		
		entity = repository.save(entity);
		return new ClassroomInsertDto(entity);
	}
}
