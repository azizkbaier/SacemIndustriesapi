package sacembackned.com.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.equipement;
import sacembackned.com.repository.equipementrepository;

@Service
public class equipementserviceimplement implements equipementservice {
    @Autowired
    equipementrepository repequipement;

    @Override
    public equipement addequipement(equipement e) {
        repequipement.save(e);
        return e;
    }

    @Override
    public equipement updateequipement(Long id, equipement e) {
        Optional<equipement> existingEquipementOptional = repequipement.findById(id);
        if (existingEquipementOptional.isPresent()) {
            equipement existingEquipement = existingEquipementOptional.get();
            existingEquipement.setNomequipement(e.getNomequipement());
            existingEquipement.setDescription(e.getDescription());
            existingEquipement.setPathimage(e.getPathimage());
            existingEquipement.setPathdetailstechnique(e.getPathdetailstechnique());
            return repequipement.save(existingEquipement);
        } else {
            return null; // Or throw an exception indicating that the equipment with the given ID doesn't exist
        }
    }

    @Override
public void deleteequipement(Long id) {
    equipement equipementToDelete = getequipementById(id);
    if (equipementToDelete != null) {
        repequipement.deleteById(id);
    } else {
        // L'équipement avec l'ID spécifié n'existe pas
        throw new NoSuchElementException("Aucun équipement trouvé pour l'ID donné: " + id);
        // Ou vous pouvez simplement logguer un message d'erreur sans lancer une exception
        // Logger.getLogger(equipementserviceimplement.class.getName()).log(Level.SEVERE, "Aucun équipement trouvé pour l'ID donné: " + id);
    }
}


    @Override
    public List<equipement> getallequipement() {
        return (List<equipement>) repequipement.findAll();
    }

    @Override
    public equipement getequipementById(Long id) {
        Optional<equipement> equipementOptional = repequipement.findById(id);
        return equipementOptional.orElse(null);
    }
   
}
