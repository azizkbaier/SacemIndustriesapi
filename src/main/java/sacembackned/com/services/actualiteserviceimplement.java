package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.actualite;
import sacembackned.com.repository.actualiterepository;

@Service
public class actualiteserviceimplement implements actualiteservice {

	@Autowired
	private actualiterepository Actualiterepository;

	@Override
	public actualite addactualite(actualite a) {
		Actualiterepository.save(a);
		return a;
	}

	@Override
	public List<actualite> getallactualite() {
		return (List<actualite>) Actualiterepository.findAll();
	}

	@Override
	public Optional<actualite> GetById(Long id) {
		return Actualiterepository.findById(id);
	}

	@Override
	public void DeletebyId(Long id) {
		Actualiterepository.deleteById(id);
	}

}
