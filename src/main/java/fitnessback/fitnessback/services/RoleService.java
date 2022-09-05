package fitnessback.fitnessback.services;

import fitnessback.fitnessback.entities.Roles;
import fitnessback.fitnessback.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Roles> allRole(){
        return roleRepository.findAll();
    }

    public Roles addRole(Roles role){
        return roleRepository.saveAndFlush(role);
    }

    public Roles getRole(String name){
        return roleRepository.findByRoleName(name);
    }

    public List<Roles> addListRoles(List<Roles> roles){
        return roleRepository.saveAllAndFlush(roles);
    }
}













