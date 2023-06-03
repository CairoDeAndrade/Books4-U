package books4u.com.br.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_authors")
public class Author implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAuthor;
	private String authorName;
	private Boolean authorStatus;
	
	public Author() {
	}
	
	public Author(Long idAuthors, String authorName, Boolean authorStatus) {
		super();
		this.idAuthor = idAuthors;
		this.authorName = authorName;
		this.authorStatus = authorStatus;
	}

	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Boolean getAuthorStatus() {
		return authorStatus;
	}

	public void setAuthorStatus(Boolean authorStatus) {
		this.authorStatus = authorStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAuthor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(idAuthor, other.idAuthor);
	}
}
