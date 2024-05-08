package sacembackned.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sacembackned.com.entity.admin;
import sacembackned.com.services.authservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/auth")

public class authcontroller {

    @Autowired
    authservice Authservice;

    @PostMapping("/signup")
    public ResponseEntity<?> Signup(@RequestBody admin a) {

        String email = a.getEmail();

        if (Authservice.getAdmin(email).isPresent()) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        admin registered = Authservice.registerAdmin(a);

        if (registered != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("registered");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering admin.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody admin login) {
        String email = login.getEmail();
        String password = login.getPassword();
        // Check if email exists
        if (Authservice.getAdmin(email).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email does not exist");
        }

        // Check password
        admin retrievedAdmin = Authservice.getAdmin(email).get();

        if (!retrievedAdmin.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Password");
        }

        String token = Authservice.GenerateToken(retrievedAdmin.getIdadmin());
        System.out.println(token);

        // Prepare response object
        Map<String, Object> response = new HashMap<>();
        response.put("userId", retrievedAdmin.getIdadmin());
        response.put("token", token);
        response.put("success", true);
        response.put("role", retrievedAdmin.getRole());
        response.put("nom", retrievedAdmin.getName());
        response.put("email", retrievedAdmin.getEmail());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/allUsers")
    @ResponseBody
    public ResponseEntity<?> getUsers() {

        List<admin> list = Authservice.getUsers();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pas des utilisateurs.");
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @DeleteMapping("/DeleteUser/{idadmin}")
    public Boolean DeleteUser(@PathVariable Long idadmin) {
        Authservice.DeletebyId(idadmin);
        if (Authservice.GetUserById(idadmin).isEmpty()) {
            return true;
        } else
            return false;
    }

}
