package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.devis;

@Repository
public interface devisrepository  extends JpaRepository <devis,Integer> {

}
