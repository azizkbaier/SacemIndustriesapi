package sacembackned.com.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class formation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idformation;
    private String thematique;
    private String session;
    private String populationcible;
    private String formateur;
    private LocalDate date;
    private String lieu;

    public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public formation() {
        super();
    }

    public formation(String thematique,String lieu, String session, String populationcible, String formateur, LocalDate date) {
        super();
        this.thematique = thematique;
        this.session = session;
        this.populationcible = populationcible;
        this.formateur = formateur;
        this.date = date;
        this.lieu= lieu;
    }

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPopulationcible() {
        return populationcible;
    }

    public void setPopulationcible(String populationcible) {
        this.populationcible = populationcible;
    }

    public String getFormateur() {
        return formateur;
    }

    public void setFormateur(String formateur) {
        this.formateur = formateur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
