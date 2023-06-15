package books4u.com.br.dto;

import java.io.Serializable;

public class UpdatedDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Boolean updated;
	
	public UpdatedDto() {
	}

	public UpdatedDto(Boolean updated) {
		super();
		this.updated = updated;
	}

	public Boolean getUpdated() {
		return updated;
	}

	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}

}
