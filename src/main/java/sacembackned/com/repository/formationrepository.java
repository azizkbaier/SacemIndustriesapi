package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.formation;

@Repository
public interface formationrepository  extends JpaRepository <formation,Integer> {

}
