package sacembackned.com.services;


import java.util.Optional;

import sacembackned.com.entity.admin;

public interface authservice {
    admin registerAdmin(admin a);

    Optional<admin> getAdmin(String email);

}
