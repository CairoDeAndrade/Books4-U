package books4u.com.br.dto.publishing;

import books4u.com.br.entities.PublishingCompany;

import java.util.Objects;

public class PublishingCompanyMinDto {

	private String name;

	public PublishingCompanyMinDto() {
	}

	public PublishingCompanyMinDto(Long id, String name) {
		this.name = name;
	}

	public PublishingCompanyMinDto(PublishingCompany entity) {
		name = entity.getPublishingCompanyName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
