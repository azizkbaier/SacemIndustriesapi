package sacembackned.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sacembackned.com.services.assistanceservice;

import sacembackned.com.entity.assistance;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/Assistance")
public class assistancecontroller {
	@Autowired
	assistanceservice assistanceservice;

	@GetMapping("/AllDemandes")
	@ResponseBody
	public ResponseEntity<?> getallassistance() {

		List<assistance> list = assistanceservice.getallassistance();

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des assistances est vide.");
		} else {
			return ResponseEntity.ok(list);
		}
	}


    @PostMapping("/AddDemande")
    public ResponseEntity<?> AddAssistance(@RequestBody assistance a) {
        assistance Assistance = assistanceservice.addassistance(a);
        if (Assistance != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(a);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du devis.");
        }
    }

	@GetMapping("/Demande/{id}")
	public Optional<assistance> GetById(@PathVariable Long id) {
		Optional<assistance> Assistance = assistanceservice.GetById(id);
		return Assistance;
	}

	@DeleteMapping("/DeleteDemande/{id}")
	public Boolean DeleteDevis(@PathVariable Long id) {
		assistanceservice.DeletebyId(id);
		if (assistanceservice.GetById(id).isEmpty()) {
			return true;
		} else
			return false;
	}
}
