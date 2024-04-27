package sacembackned.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class transformateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtransformateur;
    private String nomtransformateur;
    private String description;
    private String pathimage;
    private String pathdetailstechnique;
    private int puissance;
    private String type;

    public Long getIdtransformateur() {
        return idtransformateur;
    }

    public void setIdtransformateur(Long idtransformateur) {
        this.idtransformateur = idtransformateur;
    }

    public String getNomtransformateur() {
        return nomtransformateur;
    }

    public void setNomtransformateur(String nomtransformateur) {
        this.nomtransformateur = nomtransformateur;
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

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public transformateur(Long idtransformateur, String nomtransformateur, String description, String pathimage,
                      String pathdetailstechnique, int puissance, String type) {
        this.idtransformateur = idtransformateur;
        this.nomtransformateur = nomtransformateur;
        this.description = description;
        this.pathimage = pathimage;
        this.pathdetailstechnique = pathdetailstechnique;
        this.puissance = puissance;
        this.type = type;
    }

    public transformateur() {
    }
}
