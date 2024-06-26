package sacembackned.com.controller;

import java.util.List;

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

import sacembackned.com.entity.formation;
import sacembackned.com.services.formationservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform")
public class formationcontroller {
    @Autowired
    formationservice formationservice;

    @GetMapping("/AllFormations")
    @ResponseBody
    public ResponseEntity<?> getallformation() {

        List<formation> list = formationservice.getallformation();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des formations est vide.");
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @PostMapping("/Addformation")
    @ResponseBody
    public ResponseEntity<?> addFormation(@RequestBody formation f) {
        formation addedFormation = formationservice.addformation(f);

        if (addedFormation != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedFormation);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Erreur lors de l'ajout de la formation.\"}");
        }
    }

    @DeleteMapping("/DeleteFormation/{id}")
    public void DeleteDevis(@PathVariable int id) {
        formationservice.DeleteFormation(id);
    }

}
