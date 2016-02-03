package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "EMAIL", unique = true, nullable = false, length = 30)
	private String email;
	@Column(name = "LOGIN", unique = true, nullable = false, length = 20)
	private String login;
	@Column(name = "PASSWORD", nullable = false, length = 20)
	private String password;

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

	public Users(Long id, String email, String login, String password) {
		this.id = id;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public Users() {

	}

}
