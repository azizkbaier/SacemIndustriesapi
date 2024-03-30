package sacembackned.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class equipement {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idequipement;
	 private String nomequipement;
	 private String description;
	 private String pathimage;
	 private String pathdetailstechnique;
	public Long getIdequipement() {
		return idequipement;
	}
	public void setIdequipement(Long idequipement) {
		this.idequipement = idequipement;
	}
	public String getNomequipement() {
		return nomequipement;
	}
	public void setNomequipement(String nomequipement) {
		this.nomequipement = nomequipement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPathimage() {
		return pathimage;
	}
	public void setPathimage(String pathimage) {
		this.pathimage = pathimage;
	}
	public String getPathdetailstechnique() {
		return pathdetailstechnique;
	}
	public void setPathdetailstechnique(String pathdetailstechnique) {
		this.pathdetailstechnique = pathdetailstechnique;
	}
	public equipement(Long idequipement, String nomequipement, String description, String pathimage,
			String pathdetailstechnique) {
		super();
		this.idequipement = idequipement;
		this.nomequipement = nomequipement;
		this.description = description;
		this.pathimage = pathimage;
		this.pathdetailstechnique = pathdetailstechnique;
	}
	public equipement() {
		super();
	}
	 
	 
	 
}
