package sacembackned.com.services;

import java.util.List;

import sacembackned.com.entity.condidaturespontane;

public interface condidaturespontaneservice  {
    condidaturespontane addcondidaturespontane(condidaturespontane c);
    List <condidaturespontane> getallcondidaturespontane();
}
