package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.contacts;

@Repository
public interface contactsrepository extends JpaRepository<contacts, Long> {
    
}
    
