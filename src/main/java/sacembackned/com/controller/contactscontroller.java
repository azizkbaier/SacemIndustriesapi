package sacembackned.com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sacembackned.com.entity.contacts;
import sacembackned.com.services.contactsservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform")
public class contactscontroller {

  @Autowired
  private contactsservice contactsService;

  @PostMapping("/AddContact")
  public contacts addContact(@RequestBody contacts contact) {
    return contactsService.addContact(contact);
  }

  @DeleteMapping("/DeleteContact/{id}")
  public void deleteContact(@PathVariable Long id) {
    contactsService.deleteContact(id);
  }

 
    @GetMapping("/AllContacts")
    public ResponseEntity<List<contacts>> getAllContacts() {
        List<contacts> list = contactsService.getAllContacts();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(list);
        }
    }

}
