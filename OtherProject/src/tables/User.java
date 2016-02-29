package tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"USER\"")
public class User {

	@Id
	@GeneratedValue//(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;
	@Column(name = "EMAIL", unique = true, nullable = false, length = 30)
	private String email;
	@Column(name = "LOGIN", unique = true, nullable = false, length = 20)
	private String login;
	@Column(name = "PASSWORD", nullable = false, length = 16)
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<Request> history;

	public User(String email, String login, String password) {
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public User() {

	}

	public List<Request> getHistory() {
		if (history == null) {
			return new ArrayList<Request>();
		} else {
			return history;
		}
	}

	public void setHistory(List<Request> history) {
		this.history = history;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
