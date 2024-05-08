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

import sacembackned.com.entity.equipment;
import sacembackned.com.services.equipmentservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/api")

public class equipmentcontroller {
    @Autowired
    equipmentservice equipmentservice;
    @Autowired
    cloudinarycontroller CloudinaryController;

    @GetMapping("/Allequipments")
    @ResponseBody
    public ResponseEntity<?> getallequipment() {
        List<equipment> list = equipmentservice.getallequipment();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des equipments est vide.");
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @PostMapping("/Addequipment")
    @ResponseBody
    public equipment addequipment(@RequestBody equipment e) {

        equipment E = equipmentservice.addequipment(e);
        if (E != null) {
            return E;
        } else {
            return null;
        }
    }

    @DeleteMapping("/deleteequipment/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteequipment(@PathVariable Integer id) {
        equipment deletedequipment = equipmentservice.getequipmentById(id);
        if (deletedequipment != null) {
            equipmentservice.deleteequipment(id);
            return ResponseEntity.ok("equipment supprimé avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun équipement trouvé pour l'ID donné.");
        }
    }

    @GetMapping("/getequipement/{id}")
    @ResponseBody
    public ResponseEntity<?> getequipementById(@PathVariable Integer id) {
        equipment E = equipmentservice.getequipmentById(id);
        if (E != null) {
            return ResponseEntity.ok(E);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("equipement non trouvé pour l'ID donné.");
        }
    }

}
