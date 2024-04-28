package sacembackned.com.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class admin implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idadmin;
  private String name;
  private String email;
  private String password;
  private String role;

  public Long getIdadmin() {
    return idadmin;
  }

  public void setIdadmin(Long idadmin) {
    this.idadmin = idadmin;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public admin(Long idadmin, String name, String email, String password, String role) {
    super();
    this.idadmin = idadmin;
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public admin() {
    super();
  }
}
