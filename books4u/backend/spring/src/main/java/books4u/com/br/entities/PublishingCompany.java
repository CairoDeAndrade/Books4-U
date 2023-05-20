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
@Table(name = "tb_publishing_companies")
public class PublishingCompany implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPublishingCompany;
	
	@Column(unique = true)
	private String publishingCompanyName;
	
	public PublishingCompany() {
	}

	public PublishingCompany(Long idPublishingCompany, String publishingCompanyName) {
		super();
		this.idPublishingCompany = idPublishingCompany;
		this.publishingCompanyName = publishingCompanyName;
	}

	public Long getIdPublishingCompany() {
		return idPublishingCompany;
	}

	public void setIdPublishingCompany(Long idPublishingCompany) {
		this.idPublishingCompany = idPublishingCompany;
	}

	public String getPublishingCompanyName() {
		return publishingCompanyName;
	}

	public void setPublishingCompanyName(String publishingCompanyName) {
		this.publishingCompanyName = publishingCompanyName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPublishingCompany);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublishingCompany other = (PublishingCompany) obj;
		return Objects.equals(idPublishingCompany, other.idPublishingCompany);
	}
}
