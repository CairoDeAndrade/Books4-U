package books4u.com.br.dto.student;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import books4u.com.br.dto.classroom.ClassroomDto;
import books4u.com.br.entities.Classroom;
import books4u.com.br.entities.Loan;
import books4u.com.br.entities.Student;

public class StudentDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fullname;
	private Long enrollment;
	private Boolean status;
	
	private ClassroomDto classroom;
	
	public StudentDto() {
	}

	public StudentDto(Long id, String fullname, Long enrollment, Boolean status) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.enrollment = enrollment;
		this.status = status;
	}
	
	public StudentDto(Student entity) {
		id = entity.getIdStudent();
		fullname = entity.getStudentFullname();
		enrollment = entity.getStudentEnrollment();
		status = entity.getStudentStatus();
	}
	
	public StudentDto(Student entity, Classroom classroom) {
		this(entity);
		this.classroom = new ClassroomDto(classroom);
	}
	
	public StudentDto(Student entity, Classroom classroom, List<Loan> loans) {
		this(entity);
		this.classroom = new ClassroomDto(classroom);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Long getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Long enrollment) {
		this.enrollment = enrollment;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ClassroomDto getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassroomDto classroom) {
		this.classroom = classroom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		return Objects.equals(id, other.id);
	}
}
