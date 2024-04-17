package sacembackned.com.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class devis implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddevis;
	private String nomprenom;
	private String telephone;
	private String adresse;
	private String pays;
	private String societe;
	private String prestation;
	private String objet;

	public int getIddevis() {
		return iddevis;
	}

	public void setIddevis(int iddevis) {
		this.iddevis = iddevis;
	}

	public String getNomprenom() {
		return nomprenom;
	}

	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getPrestation() {
		return prestation;
	}

	public void setPrestation(String prestation) {
		this.prestation = prestation;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public devis(int iddevis, String nomprenom, String telephone, String adresse, String pays, String societe,
			String prestation, String objet) {
		super();
		this.iddevis = iddevis;
		this.nomprenom = nomprenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.pays = pays;
		this.societe = societe;
		this.prestation = prestation;
		this.objet = objet;
	}

	public devis() {
		super();
	}

}
