package sacembackned.com.services;


import sacembackned.com.entity.admin;

public interface adminservice {
    void getadminById(Long id);
    String addadmin(admin a);
}
