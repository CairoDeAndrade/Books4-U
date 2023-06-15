package books4u.com.br.dto;

public class DeletedDto {
	
	private Boolean deleted;
	
	public DeletedDto() {
	}

	public DeletedDto(Boolean deleted) {
		super();
		this.deleted = deleted;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
