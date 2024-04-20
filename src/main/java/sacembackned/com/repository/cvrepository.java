package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.cv;
@Repository
public interface cvrepository extends JpaRepository <cv,Long> {

    
}
