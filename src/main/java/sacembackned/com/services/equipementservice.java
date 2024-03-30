package sacembackned.com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sacembackned.com.entity.equipement;

public interface equipementservice {
    equipement addequipement(equipement e);
    equipement updateequipement(Long id, equipement e);
    void deleteequipement(Long id);
    List<equipement> getallequipement();
    equipement getequipementById(Long id);
}
