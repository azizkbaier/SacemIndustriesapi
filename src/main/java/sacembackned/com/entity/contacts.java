package sacembackned.com.entity; // Replace with your actual package name (if different)

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacts")
public class contacts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "departement")
  private String departement;

  @Column(name = "telephone")
  private String telephone;

  // Added column for nomprenom
  @Column(name = "nomprenom")
  private String nomprenom;

  public contacts() {
    super();
  }

  public contacts(String email, String departement, String telephone, String nomprenom) {
    super();
    this.email = email;
    this.departement = departement;
    this.telephone = telephone;
    this.nomprenom = nomprenom; // Initialize the new field
  }

  // Getters and Setters (updated to include nomprenom)
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

  public String getDepartement() {
    return departement;
  }

  public void setDepartement(String departement) {
    this.departement = departement;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getNomprenom() {
    return nomprenom;
  }

  public void setNomprenom(String nomprenom) {
    this.nomprenom = nomprenom;
  }
}
