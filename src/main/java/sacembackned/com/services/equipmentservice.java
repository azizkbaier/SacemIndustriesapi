package sacembackned.com.services;

import java.util.List;

import sacembackned.com.entity.equipment;

public interface equipmentservice {
    equipment addequipment(equipment e);

    void deleteequipment(Integer id);

    List<equipment> getallequipment();

    equipment getequipmentById(Integer id);
    
    List<equipment> getTransformateurs(); 

}
