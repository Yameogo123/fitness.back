package fitnessback.fitnessback.services;

import fitnessback.fitnessback.entities.Membre;
import fitnessback.fitnessback.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembreService {

    @Autowired
    private MembreRepository membreRepository;

    public Membre newMember(Membre membre){
        LocalDate date= LocalDate.now().plusDays(1);
        if(membre.getType()=="mensuel"){
            date= LocalDate.now().plusMonths(1);
        }
        membre.setFinInscription(date);
        return membreRepository.saveAndFlush(membre);
    }

    public Membre updateMembre(Membre membre){
        return membreRepository.save(membre);
    }

    public List<Membre> allMember(){
        return membreRepository.findAll();
    }
    
    public Membre oneById(Long id){
        return membreRepository.findById(id).get();
    }
}
