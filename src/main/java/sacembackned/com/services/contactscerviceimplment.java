package sacembackned.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.contacts;
import sacembackned.com.repository.contactsrepository;

@Service
public class contactscerviceimplment implements contactsservice {

  @Autowired
  private contactsrepository contactsRepository;

  @Override
  public contacts addContact(contacts c) {
    return contactsRepository.save(c);
  }

  @Override
  public void deleteContact(Long id) {
    contactsRepository.deleteById(id);
  }

  @Override
  public List<contacts> getAllContacts() {
    return (List<contacts>) contactsRepository.findAll();
  }
}
