package sacembackned.com.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.equipment;
import sacembackned.com.repository.equipmentrepository;

@Service
public class equipmentserviceimplement implements equipmentservice {
    @Autowired
    equipmentrepository repequipment;

    @Override
    public equipment addequipment(equipment e) {
        repequipment.save(e);
        return e;
    }


 

    @Override
public void deleteequipment(Integer id) {
    equipment equipmentToDelete = getequipmentById(id);
    if (equipmentToDelete != null) {
        repequipment.deleteById(id);
    } else {
        // L'équipement avec l'ID spécifié n'existe pas
        throw new NoSuchElementException("Aucun équipement trouvé pour l'ID donné: " + id);
        // Ou vous pouvez simplement logguer un message d'erreur sans lancer une exception
        // Logger.getLogger(equipmentserviceimplement.class.getName()).log(Level.SEVERE, "Aucun équipement trouvé pour l'ID donné: " + id);
    }
}


    @Override
    public List<equipment> getallequipment() {
        return (List<equipment>) repequipment.findAll();
    }

    @Override
    public equipment getequipmentById(Integer id) {
        Optional<equipment> equipmentOptional = repequipment.findById(id);
        return equipmentOptional.orElse(null);
    }
   
}
