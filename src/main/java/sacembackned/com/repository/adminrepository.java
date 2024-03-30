package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.admin;

@Repository
public interface adminrepository extends JpaRepository <admin,Long> {
    
}
