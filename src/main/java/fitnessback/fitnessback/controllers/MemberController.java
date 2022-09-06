package fitnessback.fitnessback.controllers;

import fitnessback.fitnessback.entities.Membre;
import fitnessback.fitnessback.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

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
    @ResponseBody
    public String info(@PathVariable Long id){
        Membre member= membreService.oneById(id);
        String result= "nom : "+ member.getNom()+ "\ntéléphone: "+member.getTel() ;
        if(member.getFinInscription().isAfter(LocalDate.now())){
            result= result + "\nabonnement valide";
        }else{
            result= result + "\nabonnement expiré";
        }
        return result;
    }

}
