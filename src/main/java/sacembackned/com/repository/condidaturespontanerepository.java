package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.condidaturespontane;
@Repository
public interface condidaturespontanerepository extends JpaRepository <condidaturespontane,Long> {
    
}
