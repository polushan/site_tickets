package tables;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private List<Request> from;
	private List<Request> to;
	
	public Station(String id, String country, String city, String name) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.name = name;
	}

	public Station() {

	}

	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "FROM")
	public List<Request> getFrom() {
		return from;
	}

	public void setFrom(List<Request> from) {
		this.from = from;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO")
	public List<Request> getTo() {
		return to;
	}

	public void setTo(List<Request> to) {
		this.to = to;
	}

	@Id
	@Column(name = "ID", length = 15, unique = true, nullable = false)
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
