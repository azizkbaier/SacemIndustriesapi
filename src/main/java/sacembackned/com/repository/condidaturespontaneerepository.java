package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.condidaturespontanee;

@Repository
public interface condidaturespontaneerepository extends JpaRepository<condidaturespontanee, Long> {

}