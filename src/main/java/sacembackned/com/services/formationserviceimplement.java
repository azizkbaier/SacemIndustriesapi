package sacembackned.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.formation;
import sacembackned.com.repository.formationrepository;

@Service

public class formationserviceimplement implements formationservice {
	@Autowired
	formationrepository repformation;

	@Override
	public formation addformation(formation f) {
		repformation.save(f);
		return f;
	}

	@Override
	public List<formation> getallformation() {
		return (List<formation>) repformation.findAll();
		
	}

	@Override
	public void DeleteFormation(int id){
		repformation.deleteById(id);
	}
	

}

