package sacembackned.com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class condidaturespontane {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idcondidature;
    private String civilite;
    private String nometprenom;

    
    private LocalDate datedenaissance;
    private String email;
    private String adresse;
    private int codepostal;
    private String ville;
    private int telephone;
    private String niveaudediplome;
    private String intituledediplome;
    private  String cv;

    public condidaturespontane() {
    }

    public condidaturespontane(Long idcondidature, String civilite, String nometprenom, LocalDate datedenaissance, String email, String adresse, int codepostal, String ville, int telephone, String niveaudediplome, String intituledediplome, String cv) {
        this.idcondidature = idcondidature;
        this.civilite = civilite;
        this.nometprenom = nometprenom;
        this.datedenaissance = datedenaissance;
        this.email = email;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.telephone = telephone;
        this.niveaudediplome = niveaudediplome;
        this.intituledediplome = intituledediplome;
        this.cv = cv;
    }

    public Long getIdcondidature() {
        return this.idcondidature;
    }

    public void setIdcondidature(Long idcondidature) {
        this.idcondidature = idcondidature;
    }

    public String getCivilite() {
        return this.civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNometprenom() {
        return this.nometprenom;
    }

    public void setNometprenom(String nometprenom) {
        this.nometprenom = nometprenom;
    }

    public LocalDate getDatedenaissance() {
        return this.datedenaissance;
    }

    public void setDatedenaissance(LocalDate datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodepostal() {
        return this.codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getTelephone() {
        return this.telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNiveaudediplome() {
        return this.niveaudediplome;
    }

    public void setNiveaudediplome(String niveaudediplome) {
        this.niveaudediplome = niveaudediplome;
    }

    public String getIntituledediplome() {
        return this.intituledediplome;
    }

    public void setIntituledediplome(String intituledediplome) {
        this.intituledediplome = intituledediplome;
    }

    public String getCv() {
        return this.cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
  


}
