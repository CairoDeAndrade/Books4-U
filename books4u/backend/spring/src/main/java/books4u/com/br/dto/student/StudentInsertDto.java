package books4u.com.br.dto.student;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.entities.Student;

public class StudentInsertDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fullname;
	private Long enrollment;
	private Boolean status;
	
	private Integer classroomNumber;
	
	public StudentInsertDto() {
	}

	public StudentInsertDto(Long id, String fullname, Long enrollment, Boolean status) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.enrollment = enrollment;
		this.status = status;
	}
	
	public StudentInsertDto(Student entity) {
		id = entity.getIdStudent();
		fullname = entity.getStudentFullname();
		enrollment = entity.getStudentEnrollment();
		status = entity.getStudentStatus();
	}
	
	public StudentInsertDto(Student entity, Integer number) {
		this(entity);
		this.classroomNumber = number;
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

	public Integer getClassroomNumber() {
		return classroomNumber;
	}

	public void setClassroomNumber(Integer number) {
		this.classroomNumber = number;
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
		StudentInsertDto other = (StudentInsertDto) obj;
		return Objects.equals(id, other.id);
	}
}
