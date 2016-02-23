package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"SITE\"")
public class Site {

	@Id
	@Column(name = "DOMAIN", length = 50)
	private String domain;
	@Column(name = "NAME", length = 20)
	private String name;

	public Site(String domain, String name) {
		this.domain = domain;
		this.name = name;
	}

	public Site() {

	}

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

}
