package sacembackned.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sacembackned.com.services.assistanceservice;

import sacembackned.com.entity.assistance;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/api")
public class assistancecontroller {
	@Autowired
	assistanceservice assistanceservice;

	@GetMapping("/allassistance")
	@ResponseBody
	public ResponseEntity<?> getallassistance() {
		
	    List<assistance> list = assistanceservice.getallassistance();
	    
	    if (list.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des assistances est vide.");
	    } else {
	        return ResponseEntity.ok(list);
	    }
	}

	@PostMapping("/addassistance")
	@ResponseBody
	public ResponseEntity<?> addassistance(@RequestBody assistance a) {
	    assistance addedassistance = assistanceservice.addassistance(a);
	    
	    if (addedassistance != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"assistance ajoutée avec succès.\"}");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Erreur lors de l'ajout de la assistance.\"}");
	    }
	}
}
