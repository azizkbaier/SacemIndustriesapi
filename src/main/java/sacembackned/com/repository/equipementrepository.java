package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.equipement;

@Repository
public interface equipementrepository  extends JpaRepository <equipement,Long> {

}
