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

    private String imageURL;

    private String specsfileURL;

    @Column(nullable = false)
    private String type; // New attribute

    @Column
    private Long puissance; // New attribute

    public equipment() {
    }

    public equipment(int id, String nom, String description, String image, String specsfile, String type,
            Long puissance) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.imageURL = image;
        this.specsfileURL = specsfile;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSpecsfileURL() {
        return specsfileURL;
    }

    public void setSpecsfileURL(String specsfileURL) {
        this.specsfileURL = specsfileURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPuissance() {
        return puissance;
    }

    public void setPuissance(Long puissance) {
        this.puissance = puissance;
    }

}
