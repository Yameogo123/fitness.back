package fitnessback.fitnessback.controllers;

import fitnessback.fitnessback.entities.Contact;
import fitnessback.fitnessback.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/all")
    public List<Contact> all(){
        return contactService.all();
    }

    @PostMapping("/new")
    public Contact nouveau(@RequestBody Contact contact){
        return contactService.add(contact);
    }
}
