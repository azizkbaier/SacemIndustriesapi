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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sacembackned.com.entity.transformateur;
import sacembackned.com.services.transformateurservice;
@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/api")
public class transformateurcontroller {
@Autowired
    transformateurservice transformateurservice;

    @GetMapping("/alltransformateur")
    @ResponseBody
    public ResponseEntity<?> getalltransformateur() {
        List<transformateur> list = transformateurservice.getalltTransformateurs();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des transformateurs est vide.");
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @PostMapping("/addtransformateur")
    @ResponseBody
    public ResponseEntity<?> addtransformateur(@RequestBody transformateur e) {
        transformateur addedtransformateur = transformateurservice.addtransformateur(e);

        if (addedtransformateur != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("transformateur ajoutée avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de la transformateur.");
        }
    }

    @PutMapping("/updatetransformateur/{id}")
    @ResponseBody
    public ResponseEntity<?> updatetransformateur(@PathVariable("id") Long id, @RequestBody transformateur e) {
        transformateur updatedtransformateur = transformateurservice.updatetransformateur(id, e);
        if (updatedtransformateur != null) {
            return ResponseEntity.ok("transformateur mis à jour avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transformateur non trouvé pour l'ID donné.");
        }
    }

    @DeleteMapping("/deletetransformateur/{id}")
@ResponseBody
public ResponseEntity<String> deletetransformateur(@PathVariable("id") Long id) {
    transformateur deletedtransformateur = transformateurservice.gettransformateurById(id);
    if (deletedtransformateur != null) {
        transformateurservice.deletetransformateur(id);
        return ResponseEntity.ok("transformateur supprimé avec succès.");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun équipement trouvé pour l'ID donné.");
    }
}

    
    


    @GetMapping("/gettransformateur/{id}")
    @ResponseBody
    public ResponseEntity<?> gettransformateurById(@PathVariable("id") Long id) {
        transformateur transformateurById = transformateurservice.gettransformateurById(id);
        if (transformateurById != null) {
            return ResponseEntity.ok(transformateurById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transformateur non trouvé pour l'ID donné.");
        }
    }
    
    
}
