package books4u.com.br.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStudent;
	private String studentName;
	
	@Column(unique = true)
	private Long studentEnrollment;
	private Long idClassroom;
	private boolean status;
	
	public Student() {
	}

	public Student(Long id, String studentName, Long studentEnrollment, Long idClassroom, boolean status) {
		this.idStudent = id;
		this.studentName = studentName;
		this.studentEnrollment = studentEnrollment;
		this.idClassroom = idClassroom;
		this.status = status;
	}

	public Long getId() {
		return idStudent;
	}

	public void setId(Long id) {
		this.idStudent = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentEnrollment() {
		return studentEnrollment;
	}

	public void setStudentEnrollment(Long studentEnrollment) {
		this.studentEnrollment = studentEnrollment;
	}

	public Long getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(Long idClassroom) {
		this.idClassroom = idClassroom;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStudent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(idStudent, other.idStudent);
	}
}
