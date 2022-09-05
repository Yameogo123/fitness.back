package fitnessback.fitnessback.services;

import fitnessback.fitnessback.entities.Contact;
import fitnessback.fitnessback.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact add(Contact contact){
        return contactRepository.saveAndFlush(contact);
    }

    public List<Contact> all(){
        return contactRepository.findAll();
    }
}
