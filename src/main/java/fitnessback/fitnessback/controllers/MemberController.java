package fitnessback.fitnessback.controllers;

import fitnessback.fitnessback.entities.Membre;
import fitnessback.fitnessback.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/membre")
public class MemberController {

    @Autowired
    private MembreService membreService;

    @GetMapping("/all")
    public List<Membre> all(){
        return membreService.allMember();
    }

    @PutMapping("/update")
    public Membre Update(@RequestBody Membre membre){
        return membreService.updateMembre(membre);
    }

    @PostMapping("/new")
    public Membre nouveau(@RequestBody Membre membre){
        return membreService.newMember(membre);
    }
    
    @GetMapping("/{id}")
    public String info(@PathVariable Long id){
        Membre member= membreService.oneById(id);
        String result= "nom :"+member.getNom()+ "\n téléphone"+member.getTel() ;
        if(member.getFinInscription().isAfter(LocalDate.now())){
            result= result + "\n valide";
        }else{
            result= result + "\n expiré";
        }
        return result;
    }

}
