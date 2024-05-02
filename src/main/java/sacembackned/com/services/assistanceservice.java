package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import sacembackned.com.entity.assistance;

public interface assistanceservice {
	assistance addassistance(assistance a);

	List<assistance> getallassistance();
	
	void DeletebyId(Long id);

	Optional<assistance> GetById(Long id);

}
