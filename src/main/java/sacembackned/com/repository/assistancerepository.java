package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.assistance;

@Repository
public interface assistancerepository  extends JpaRepository <assistance,Long> {

}
