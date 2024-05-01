package sacembackned.com.services;

import java.util.List;

import sacembackned.com.entity.contacts;

public interface contactsservice {

  public contacts addContact(contacts contact);

  public void deleteContact(Long id);

  public List<contacts> getAllContacts();
}
