package sacembackned.com.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.admin;

@Repository
public interface adminrepository extends JpaRepository<admin, Long> {

     @Query("SELECT a FROM admin a WHERE a.email = ?1")
     Optional<admin> findByEmail(String Email);

     
     

}
