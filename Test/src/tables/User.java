package tables;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "\"USER\"")
public class User {

	private Long id;
	private String email;
	private String login;
	private String password;
	private Set<Request> history = new LinkedHashSet<Request>();

	public User(String email, String login, String password) {
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public User() {

	}

	@OneToMany(fetch = FetchType.LAZY/* , mappedBy = "user" */)
	@JoinColumn(name = "USER_ID")
	public Set<Request> getHistory() {
		return history;
	}

	public void setHistory(Set<Request> history) {
		this.history = history;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "EMAIL", unique = true, nullable = false, length = 30)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "LOGIN", unique = true, nullable = false, length = 20)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
