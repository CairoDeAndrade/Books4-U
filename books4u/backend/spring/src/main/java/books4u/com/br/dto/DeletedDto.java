package books4u.com.br.dto.book;

public class BookDeletedDto {
	
	private Boolean deleted;
	
	public BookDeletedDto() {
	}

	public BookDeletedDto(Boolean deleted) {
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
