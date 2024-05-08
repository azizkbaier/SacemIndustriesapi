package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import sacembackned.com.entity.admin;

public interface authservice {
  admin registerAdmin(admin a);

  Optional<admin> getAdmin(String email);

  List<admin> getUsers();

  void DeletebyId(Long idadmin);

  Optional<admin> GetUserById(Long idadmin);

  String GenerateToken(Long idadmin);

}
