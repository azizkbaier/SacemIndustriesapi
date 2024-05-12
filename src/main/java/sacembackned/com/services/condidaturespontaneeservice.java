package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import sacembackned.com.entity.condidaturespontanee;

public interface condidaturespontaneeservice {

    condidaturespontanee addCondidature(condidaturespontanee cs);

    void deleteCondidature(Long id);

    List<condidaturespontanee> getAllcondidatures();

    Optional<condidaturespontanee> getCondidature(Long id);

}
