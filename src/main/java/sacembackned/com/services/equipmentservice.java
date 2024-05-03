package sacembackned.com.services;

import java.util.List;

import sacembackned.com.entity.equipment;

public interface equipmentservice {
    equipment addequipment(equipment e);

    equipment updateequipment(Integer id, equipment e);

    void deleteequipment(Integer id);

    List<equipment> getallequipment();

    equipment getequipmentById(Integer id);

}
