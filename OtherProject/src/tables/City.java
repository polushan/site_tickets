package tables;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"CITY\"")
public class City {

	private String id;
	private String name;
	private List<Request> from;
	private List<Request> to;
	
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
	@Column(name = "ID", length = 3)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "NAME", unique = true, nullable = false, length = 15)
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
