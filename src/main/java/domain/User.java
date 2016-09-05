package domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "shiro_user")
@Entity
public class User implements Serializable {
	private Integer id;
	private String userName;
	private String password;
	private String cellPhone;
	private String email;

	public User() {
	}

	public User(String userName, String password, String cellPhone, String email) {
		this.userName = userName;
		this.password = password;
		this.cellPhone = cellPhone;
		this.email = email;
	}


	@Override
	public String toString() {
		return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", password='" + password + '\'' + ", cellPhone='" + cellPhone + '\'' + ", email='" + email + '\'' + '}';
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
