package tables;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"CITY\"")
public class City {

	@Id
	@Column(name = "ID", length = 3)
	private String id;
	@Column(name = "NAME", unique = true, nullable = false, length = 15)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fromStation")
	//@JoinColumn(name = "FROM")
	private List<Request> from;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "toStation")
	//@JoinColumn(name = "TO")
	private List<Request> to;

	public List<Request> getFrom() {
		return from;
	}

	public void setFrom(List<Request> from) {
		this.from = from;
	}

	public List<Request> getTo() {
		return to;
	}

	public void setTo(List<Request> to) {
		this.to = to;
	}

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
