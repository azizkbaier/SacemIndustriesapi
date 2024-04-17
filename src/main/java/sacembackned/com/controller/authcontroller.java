package sacembackned.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sacembackned.com.entity.admin;
import sacembackned.com.services.authservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

        if (Authservice.getAdmin(email).isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email does not exist");
        } else if (!Authservice.getAdmin(email).get().getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Password");

        }
        return ResponseEntity.status(HttpStatus.OK).body("Authorized");

    }

}
