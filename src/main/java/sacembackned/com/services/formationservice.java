package sacembackned.com.services;

import java.util.List;

import sacembackned.com.entity.formation;

public interface formationservice {
formation addformation(formation f);
 List<formation> getallformation();
}
