package sacembackned.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sacembackned.com.entity.file;

@Repository
public interface fileRepository extends JpaRepository<file, Integer> {
}
