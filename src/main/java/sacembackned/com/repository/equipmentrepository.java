package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.equipment;

@Repository
public interface equipmentrepository  extends JpaRepository <equipment,Integer> {
    
    
}
