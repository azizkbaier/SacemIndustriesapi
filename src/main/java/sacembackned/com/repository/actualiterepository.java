package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.actualite;

@Repository
public interface actualiterepository extends JpaRepository<actualite,Long>{

}
