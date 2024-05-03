package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import sacembackned.com.entity.file;

public interface fileservice {

    List<file> list();

    file save(file file);

    Optional<file> getOne(int id);

    void delete(int id);
}
