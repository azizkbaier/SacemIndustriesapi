package sacembackned.com.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class formation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String thematique;
    private String session;
    private String populationcible;
    private String formateur;
    private String date;
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

    public formation(int id,String thematique,String lieu, String session, String populationcible, String formateur, String date) {
        super();
        this.id = id; 
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
