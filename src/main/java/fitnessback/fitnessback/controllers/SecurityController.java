package fitnessback.fitnessback.controllers;

import fitnessback.fitnessback.entities.User;
import fitnessback.fitnessback.services.Handle;
import fitnessback.fitnessback.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class SecurityController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public User addUser(@RequestBody User user){
        return userService.newUser(user);
    }

    @GetMapping("/all")
    public List<User> allUser(){
        return userService.allUser();
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable long id, @RequestPart MultipartFile file) throws IOException {
        User user= userService.getById(id);
        return userService.updateUser(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.updateUser(user);
    }

}