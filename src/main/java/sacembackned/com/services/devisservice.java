package sacembackned.com.services;

import java.util.List;

import sacembackned.com.entity.devis;

public interface devisservice {
	devis adddevis(devis d);
	 List<devis> getalldevis();
}