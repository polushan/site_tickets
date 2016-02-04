package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "\"STATION\"", uniqueConstraints = { @UniqueConstraint(columnNames = "COUNTRY"),
		@UniqueConstraint(columnNames = "CITY"), @UniqueConstraint(columnNames = "NAME") })
public class Station {

	private String id;
	private String country;
	private String city;
	private String name;

	public Station(String id, String country, String city, String name) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.name = name;
	}

	public Station() {

	}

	@Id
	@Column(name = "ID", length = 15)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "COUNTRY", nullable = false, length = 30)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "CITY", nullable = false, length = 15)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "NAME", nullable = false, length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
