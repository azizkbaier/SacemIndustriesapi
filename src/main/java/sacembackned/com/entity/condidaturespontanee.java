package sacembackned.com.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class condidaturespontanee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String civilite;
    private String nom;
    private String telephone;
    private String adresse;
    private String ville;
    private String codepostal;
    private String email;
    private String datenaissance;
    private String niveau;
    private String intitulediplome;
    private String intituleposte;
    private String cv;

    public condidaturespontanee(Long id, String civilite, String nom, String telephone, String adresse, String ville,
            String codepostal, String email, String datenaissance, String niveau,
            String intitulediplome, String intituleposte, String cv) {
        super();
        this.id = id;
        this.civilite = civilite;
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
        this.codepostal = codepostal;
        this.email = email;
        this.datenaissance = datenaissance;
        this.niveau = niveau;
        this.intitulediplome = intitulediplome;
        this.intituleposte = intituleposte;
        this.cv = cv;
    }

    public condidaturespontanee() {
        super();
    }
    

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getIntitulediplome() {
        return intitulediplome;
    }

    public void setIntitulediplome(String intitulediplome) {
        this.intitulediplome = intitulediplome;
    }

    public String getIntituleposte() {
        return intituleposte;
    }

    public void setIntituleposte(String intituleposte) {
        this.intituleposte = intituleposte;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}