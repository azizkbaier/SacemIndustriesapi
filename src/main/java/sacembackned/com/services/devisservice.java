package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import sacembackned.com.entity.devis;

public interface devisservice {
	devis adddevis(devis d);

	List<devis> getalldevis();

	void DeletebyId(int iddevis);

	Optional<devis> GetDevisById(int iddevis);

}