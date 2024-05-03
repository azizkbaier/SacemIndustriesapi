package sacembackned.com.entity;

import jakarta.persistence.*;

import java.io.Serializable;

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
    private String objet;

    @ManyToOne(fetch = FetchType.LAZY) // Optional: Set fetch strategy to LAZY for performance optimization
    @JoinColumn(name = "prestation_id") // Foreign key column in devis table
    private equipment prestation; // Reference to equipment entity


	
    public devis(int iddevis, String nomprenom, String telephone, String adresse, String pays, String societe,
                 String objet, equipment prestation) {
        this.iddevis = iddevis;
        this.nomprenom = nomprenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.pays = pays;
        this.societe = societe;
        this.objet = objet;
        this.prestation = prestation;
    }

    public devis() {
    }

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

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public equipment getPrestation() {
		return prestation;
	}

	public void setPrestation(equipment prestation) {
		this.prestation = prestation;
	}
	
}
