package sacembackned.com.entity;


	import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
	public class assistance implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idaider;
	 @Column(name = "entreprise")
    private String entreprise;
    
    @Column(name = "pays")
    private String pays;
    
    @Column(name = "adresse")
    private String adresse;
    
    @Column(name = "selectionner")
    private String selectionner;
    
    @Column(name = "nomprenom")
    private String nomprenom;
    
    @Column(name = "poste")
    private String poste;
    
    @Column(name = "objet")
    private String objet;

	    public assistance() {
			super();

	    }

	    public assistance(Long idaider, String entreprise, String pays, String adresse, String selectionner,
				String nomprenom, String poste, String objet) {
			super();
			this.idaider = idaider;
			this.entreprise = entreprise;
			this.pays = pays;
			this.adresse = adresse;
			this.selectionner = selectionner;
			this.nomprenom = nomprenom;
			this.poste = poste;
			this.objet = objet;
		}

		public Long getIdaider() {
	        return idaider;
	    }

	    public void setIdaider(Long idaider) {
	        this.idaider = idaider;
	    }

	    public String getEntreprise() {
	        return entreprise;
	    }

	    public void setEntreprise(String entreprise) {
	        this.entreprise = entreprise;
	    }

	    public String getPays() {
	        return pays;
	    }

	    public void setPays(String pays) {
	        this.pays = pays;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public String getSelectionner() {
	        return selectionner;
	    }

	    public void setSelectionner(String selectionner) {
	        this.selectionner = selectionner;
	    }

	    public String getnomprenom() {
	        return nomprenom;
	    }

	    public void setnomprenom(String nomprenom) {
	        this.nomprenom = nomprenom;
	    }

	    public String getPoste() {
	        return poste;
	    }

	    public void setPoste(String poste) {
	        this.poste = poste;
	    }

	    public String getObjet() {
	        return objet;
	    }

	    public void setObjet(String objet) {
	        this.objet = objet;
	    }
	}

