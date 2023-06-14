package books4u.com.br.dto.classroom;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.entities.Classroom;

public class ClassroomDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer year;
	private Character shift;
	private Boolean status;
	
	public ClassroomDto() {
	}

	public ClassroomDto(Long id, Integer classroomYear, Character classroomShift, Boolean classroomStatus) {
		super();
		this.id = id;
		this.year = classroomYear;
		this.shift = classroomShift;
		this.status = classroomStatus;
	}
	
	public ClassroomDto(Classroom entity) {
		id = entity.getIdClassroom();
		year = entity.getClassroomYear();
		shift = entity.getClassroomShift();
		status = entity.getClassroomStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer classroomYear) {
		this.year = classroomYear;
	}

	public Character getShift() {
		return shift;
	}

	public void setShift(Character classroomShift) {
		this.shift = classroomShift;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean classroomStatus) {
		this.status = classroomStatus;
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
		ClassroomDto other = (ClassroomDto) obj;
		return Objects.equals(id, other.id);
	}
}
