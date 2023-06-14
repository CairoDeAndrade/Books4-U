package books4u.com.br.dto;

import java.io.Serializable;

public class CreatedDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Boolean created;
	
	public CreatedDto() {
	}

	public CreatedDto(Boolean created) {
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
