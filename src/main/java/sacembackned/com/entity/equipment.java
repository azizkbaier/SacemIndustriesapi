package sacembackned.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)

    private String description;

    private String image;

    private String specsfile;

    @Column(nullable = false)
    private String type; // New attribute

    @Column
    private String puissance; // New attribute

    public equipment() {
    }

    public equipment(int id, String nom, String description, String image, String specsfile, String type,
            String puissance) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.specsfile = specsfile;
        this.type = type;
        this.puissance = puissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpecsfile() {
        return specsfile;
    }

    public void setSpecsfile(String specsfile) {
        this.specsfile = specsfile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

}
