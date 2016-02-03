package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATIONS")
public class Stations {

	@Id
	@Column(name = "ID", length = 15)
	private String id;
	@Column(name = "COUNTRY", nullable = false, length = 30)
	private String country;
	@Column(name = "CITY", nullable = false, length = 15)
	private String city;
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stations(String id, String country, String city, String name) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.name = name;
	}

	public Stations() {

	}
}
