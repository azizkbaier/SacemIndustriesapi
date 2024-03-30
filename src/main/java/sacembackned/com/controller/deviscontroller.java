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
import org.springframework.web.bind.annotation.RestController;
import sacembackned.com.services.devisservice;

import sacembackned.com.entity.devis;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/api")
public class deviscontroller {

    @Autowired
    devisservice devisservice;

    @GetMapping("/alldevis")
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
}
