package books4u.com.br.dto.book;

public class BookCreatedDto {
	
	private Boolean created;
	
	public BookCreatedDto() {
	}

	public BookCreatedDto(Boolean created) {
		super();
		this.created = created;
	}

	public Boolean getCreated() {
		return created;
	}

	public void setCreated(Boolean created) {
		this.created = created;
	}
}
