package sacembackned.com.services;

import java.util.ArrayList;
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
            // Ou vous pouvez simplement logguer un message d'erreur sans lancer une
            // exception
            // Logger.getLogger(equipmentserviceimplement.class.getName()).log(Level.SEVERE,
            // "Aucun équipement trouvé pour l'ID donné: " + id);
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

    @Override
    public List<equipment> getTransformateurs() {
        return repequipment.findByCategory("Transformateur");
    }

    @Override
    public List<equipment> getbytypeandpuissance(String type, String puissance) {
        List<equipment> l = getTransformateurs();
        List<equipment> l2 = repequipment.findByTypeAndPuissance(type, puissance);
        List<equipment> commonItems = new ArrayList<>();

        for (equipment item1 : l) {
            for (equipment item2 : l2) {
                if (item1.equals(item2)) {
                    commonItems.add(item1); // Add the common item (item1)
                    break; // Avoid adding duplicates if item1 matches multiple in l2
                }
            }
        }
        return commonItems;
    }

}
