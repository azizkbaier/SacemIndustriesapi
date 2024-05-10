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

import sacembackned.com.entity.actualite;
import sacembackned.com.services.actualiteservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/Actualites")
public class actualitecontroller {
	@Autowired
	actualiteservice Actualiteservice;

	@GetMapping("/AllActualites")
	@ResponseBody
	public ResponseEntity<?> getallactualite() {

		List<actualite> list = Actualiteservice.getallactualite();

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des actualites est vide.");
		} else {
			return ResponseEntity.ok(list);
		}
	}


    @PostMapping("/AddActualite")
    @ResponseBody
    public ResponseEntity<?> Addactualite(@RequestBody actualite a) {
        actualite actualite = Actualiteservice.addactualite(a);
        if (actualite != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(a);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du devis.");
        }
    }

	@GetMapping("/Actualite/{id}")
    @ResponseBody
	public Optional<actualite> GetById(@PathVariable Long id) {
		Optional<actualite> Actualite = Actualiteservice.GetById(id);
		return Actualite;
	}

	@DeleteMapping("/DeleteActualite/{id}")
	public Boolean DeleteDevis(@PathVariable Long id) {
		Actualiteservice.DeletebyId(id);
		if (Actualiteservice.GetById(id).isEmpty()) {
			return true;
		} else
			return false;
	}
}
