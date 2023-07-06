package books4u.com.br.dto.student;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.entities.Student;

public class StudentMinDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fullname;
	private Long enrollment;
	
	private Integer classroomNumber;
	
	public StudentMinDto() {
	}

	public StudentMinDto(Long id, String fullname, Long enrollment, Integer classroomNumber) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.enrollment = enrollment;
		this.classroomNumber = classroomNumber;
	}
	
	public StudentMinDto(Student entity) {
		id = entity.getIdStudent();
		fullname = entity.getStudentFullname();
		enrollment = entity.getStudentEnrollment();
		classroomNumber = entity.getClassroom().getClassroomYear();
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

	public Integer getClassroomNumber() {
		return classroomNumber;
	}

	public void setClassroomNumber(Integer classroom) {
		this.classroomNumber = classroom;
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
		StudentMinDto other = (StudentMinDto) obj;
		return Objects.equals(id, other.id);
	}
}
