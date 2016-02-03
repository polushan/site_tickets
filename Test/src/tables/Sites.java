package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITES")
public class Sites {
	@Id
	@Column(name = "domain", length = 50)
	private String domain;
	@Column(name = "name", length = 20)
	private String name;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sites(String domain, String name) {
		this.domain = domain;
		this.name = name;
	}
	
	public Sites() {

	}

}
