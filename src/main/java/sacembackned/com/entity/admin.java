package sacembackned.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idadmin;
    private String adminname;
    private String password;
    public admin() {
        super();
    }

    public admin(Long idadmin, String adminname, String password) {
        super();
        this.idadmin = idadmin;
        this.adminname = adminname;
        this.password = password;
    }

    public Long getIdadmin() {
        return this.idadmin;
    }

    public void setIdadmin(Long idadmin) {
        this.idadmin = idadmin;
    }

    public String getAdminname() {
        return this.adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public admin idadmin(Long idadmin) {
        setIdadmin(idadmin);
        return this;
    }

    public admin adminname(String adminname) {
        setAdminname(adminname);
        return this;
    }

    public admin password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof admin)) {
            return false;
        }
        admin admin = (admin) o;
        return Objects.equals(idadmin, admin.idadmin) && Objects.equals(adminname, admin.adminname) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idadmin, adminname, password);
    }

    @Override
    public String toString() {
        return "{" +
            " idadmin='" + getIdadmin() + "'" +
            ", adminname='" + getAdminname() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
   
}
