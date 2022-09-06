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
    
    @PutMapping("/renouveler/{id}")
    public Membre renouveler(@PathVariable Long id){
        Membre member= membreService.oneById(id);
        member.setFinInscription(LocalDate.now().plusMonths(1));
        return membreService.updateMembre(member);
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public String info(@PathVariable Long id){
        Membre member= membreService.oneById(id);
        String result= "<h1>nom : "+ member.getNom()+ "<br>téléphone: "+member.getTel() ;
        if(member.getFinInscription().isAfter(LocalDate.now())){
            result= result + "<br>\nabonnement valide</h1>";
        }else{
            result= result + "<br>\nabonnement expiré</h1>";
        }
        return result;
    }

}
