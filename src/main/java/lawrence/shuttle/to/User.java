package lawrence.shuttle.to;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;

import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "User")
public class User {
	
	 @Id
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	 @GeneratedValue(generator = "uuid")
	 @Column(name = "userid")
	 private String userid;
	 @Column(name = "name") 
	 private String name;
	 @Column(name = "password")
	 private String password;
	 @Column(name = "role") 
	 private String role;
	 @Column(name = "email")
	 private String email;
	 @Column(name = "phonenumber")
	 private String phonenumber;
	 @Column(name = "dateregistered")
	 private Date dateregistered;
	 
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getDateregistered() {
		return dateregistered;
	}
	public void setDateregistered(Date dateregistered) {
		this.dateregistered = dateregistered;
	}
	 
	 

}
