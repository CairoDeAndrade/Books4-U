package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books4u.com.br.entities.Student;
import books4u.com.br.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

}
