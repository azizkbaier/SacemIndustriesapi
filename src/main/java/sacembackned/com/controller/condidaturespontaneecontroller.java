package sacembackned.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sacembackned.com.services.condidaturespontaneeservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sacembackned.com.entity.condidaturespontanee;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/CS")
public class condidaturespontaneecontroller {

    @Autowired
    condidaturespontaneeservice CSservice;

    @GetMapping("/AllCondidatures")
    @ResponseBody
    public ResponseEntity<?> getAllCondidatures() {

        List<condidaturespontanee> list = CSservice.getAllcondidatures();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des assistances est vide.");
        } else {
            return ResponseEntity.ok(list);
        }

    }

    @PostMapping("/AddCondidature")
    @ResponseBody
    public ResponseEntity<?> AddAssistance(@RequestBody condidaturespontanee cs) {
        condidaturespontanee CS = CSservice.addCondidature(cs);
        if (CS != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(CS);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du devis.");
        }
    }

    @DeleteMapping("/DeleteCondidature/{id}")
    public void DeleteDevis(@PathVariable Long id) {
        CSservice.deleteCondidature(id);
    }

    @GetMapping("/Condidature/{id}")
    @ResponseBody
    public Optional<condidaturespontanee> getbyID(@PathVariable Long id) {
        Optional<condidaturespontanee> cs = CSservice.getCondidature(id);
        return cs;
    }

}
