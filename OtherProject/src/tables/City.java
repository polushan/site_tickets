package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"CITY\"")
public class City {

	@Id
	@Column(name = "ID", length = 3)
	private String id;
	@Column(name = "NAME", unique = true, nullable = false, length = 15)
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City() {

	}

	public City(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
