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
import sacembackned.com.entity.equipement;
import sacembackned.com.services.equipementservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/api")
public class equipementcontroller {
    @Autowired
    equipementservice equipementservice;

    @GetMapping("/allequipement")
    @ResponseBody
    public ResponseEntity<?> getallequipement() {
        List<equipement> list = equipementservice.getallequipement();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des equipements est vide.");
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @PostMapping("/addequipement")
    @ResponseBody
    public ResponseEntity<?> addequipement(@RequestBody equipement e) {
        equipement addedequipement = equipementservice.addequipement(e);

        if (addedequipement != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("equipement ajoutée avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de la equipement.");
        }
    }

    @PutMapping("/updateequipement/{id}")
    @ResponseBody
    public ResponseEntity<?> updateequipement(@PathVariable("id") Long id, @RequestBody equipement e) {
        equipement updatedEquipement = equipementservice.updateequipement(id, e);
        if (updatedEquipement != null) {
            return ResponseEntity.ok("equipement mis à jour avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipement non trouvé pour l'ID donné.");
        }
    }

    @DeleteMapping("/deleteequipement/{id}")
@ResponseBody
public ResponseEntity<String> deleteequipement(@PathVariable("id") Long id) {
    equipement deletedEquipement = equipementservice.getequipementById(id);
    if (deletedEquipement != null) {
        equipementservice.deleteequipement(id);
        return ResponseEntity.ok("equipement supprimé avec succès.");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun équipement trouvé pour l'ID donné.");
    }
}

    
    


    @GetMapping("/getequipement/{id}")
    @ResponseBody
    public ResponseEntity<?> getequipementById(@PathVariable("id") Long id) {
        equipement equipementById = equipementservice.getequipementById(id);
        if (equipementById != null) {
            return ResponseEntity.ok(equipementById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipement non trouvé pour l'ID donné.");
        }
    }
}
