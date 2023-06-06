package books4u.com.br.dto.publishing;

import java.util.Objects;

import books4u.com.br.entities.PublishingCompany;

public class PublishingCompanyDto {
	
	private Long id;
	private String name;
	
	public PublishingCompanyDto() {
	}

	public PublishingCompanyDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public PublishingCompanyDto(PublishingCompany entity) {
		id = entity.getIdPublishingCompany();
		name = entity.getPublishingCompanyName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		PublishingCompanyDto other = (PublishingCompanyDto) obj;
		return Objects.equals(id, other.id);
	}
}
