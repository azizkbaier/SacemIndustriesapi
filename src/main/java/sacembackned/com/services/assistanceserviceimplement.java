package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.assistance;
import sacembackned.com.repository.assistancerepository;

@Service
public class assistanceserviceimplement implements assistanceservice {
	@Autowired
	private assistancerepository repassistance;

	@Override
	public assistance addassistance(assistance a) {
		repassistance.save(a);
		return a;
	}

	@Override
	public List<assistance> getallassistance() {
		return (List<assistance>) repassistance.findAll();
	}

	@Override
	public Optional<assistance> GetById(Long id) {
		return repassistance.findById(id);
	}

	@Override
	public void DeletebyId(Long id) {
		repassistance.deleteById(id);
	}

}
