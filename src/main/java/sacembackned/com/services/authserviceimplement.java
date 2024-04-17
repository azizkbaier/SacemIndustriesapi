package sacembackned.com.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.admin;
import sacembackned.com.repository.adminrepository;

@Service
public class authserviceimplement implements authservice {

    @Autowired
    private adminrepository adminrepository;

    @Override
    public admin registerAdmin(admin a) {
        adminrepository.save(a);
        return a;
    }

    @Override
    public Optional<admin> getAdmin(String email) {
       return adminrepository.findByEmail(email);
    }

}
