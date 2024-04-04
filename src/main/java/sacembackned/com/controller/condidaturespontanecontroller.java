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

import sacembackned.com.entity.condidaturespontane;
import sacembackned.com.services.condidaturespontaneservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/api")
public class condidaturespontanecontroller {
    @Autowired
    condidaturespontaneservice condidaturespontaneservice;
    
    @GetMapping("/allcondidaturespontane")
	@ResponseBody
	public ResponseEntity<?> getallcondidaturespontane() {
		
	    List<condidaturespontane> list = condidaturespontaneservice.getallcondidaturespontane();
	    
	    if (list.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des condidaturespontanes est vide.");
	    } else {
	        return ResponseEntity.ok(list);
	    }
	}

	@PostMapping("/addcondidaturespontane")
	@ResponseBody
	public ResponseEntity<?> addcondidaturespontane(@RequestBody condidaturespontane a) {
	    condidaturespontane addedcondidaturespontane = condidaturespontaneservice.addcondidaturespontane(a);
	    
	    if (addedcondidaturespontane != null) {
	        return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"condidaturespontane ajoutée avec succès.\"}");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Erreur lors de l'ajout de la condidaturespontane.\"}");
	    }
	}
}
