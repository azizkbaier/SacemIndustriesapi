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
import org.springframework.web.bind.annotation.RestController;
import sacembackned.com.services.devisservice;

import sacembackned.com.entity.devis;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform")
public class deviscontroller {

    @Autowired
    devisservice devisservice;

    @GetMapping("/AllDevis")
    public ResponseEntity<List<devis>> getalldevis() {
        List<devis> list = devisservice.getalldevis();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @PostMapping("/adddevis")
    public ResponseEntity<?> adddevis(@RequestBody devis d) {
        devis addeddevis = devisservice.adddevis(d);
        if (addeddevis != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addeddevis);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du devis.");
        }
    }

    @GetMapping("/Devis/{iddevis}")
    public Optional<devis> GetDevisById(@PathVariable int iddevis) {
        Optional<devis> Devis = devisservice.GetDevisById(iddevis);
        return Devis;
    }
    @DeleteMapping("/DeleteDevis/{iddevis}")
    public Boolean DeleteDevis(@PathVariable int iddevis) {
        devisservice.DeletebyId(iddevis);
        if (devisservice.GetDevisById(iddevis).isEmpty()) {
            return true;
        }
        else
        return false;
    }
}
