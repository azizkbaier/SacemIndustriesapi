package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import sacembackned.com.entity.actualite;


public interface actualiteservice {

	actualite addactualite(actualite a);

	List<actualite> getallactualite();
	
	void DeletebyId(Long id);

	Optional<actualite> GetById(Long id);

}