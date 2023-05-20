package books4u.com.br.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_classrooms")
public class Classroom implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClassroom;
	private Integer classroomYear;
	private Character classroomShift;
	private Boolean classroomStatus;
	
	public Classroom() {
	}

	public Classroom(Long idClassroom, Integer classroomYear, Character classroomShift, Boolean classroomStatus) {
		super();
		this.idClassroom = idClassroom;
		this.classroomYear = classroomYear;
		this.classroomShift = classroomShift;
		this.classroomStatus = classroomStatus;
	}

	public Long getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(Long idClassroom) {
		this.idClassroom = idClassroom;
	}

	public Integer getClassroomYear() {
		return classroomYear;
	}

	public void setClassroomYear(Integer classroomYear) {
		this.classroomYear = classroomYear;
	}

	public Character getClassroomShift() {
		return classroomShift;
	}

	public void setClassroomShift(Character classroomShift) {
		this.classroomShift = classroomShift;
	}

	public Boolean getClassroomStatus() {
		return classroomStatus;
	}

	public void setClassroomStatus(Boolean classroomStatus) {
		this.classroomStatus = classroomStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idClassroom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classroom other = (Classroom) obj;
		return Objects.equals(idClassroom, other.idClassroom);
	}
}
