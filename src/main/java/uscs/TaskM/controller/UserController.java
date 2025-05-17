package uscs.TaskM.controller;

import uscs.TaskM.model.User;
import uscs.TaskM.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")

public class UserController{
    @Autowired

    private UserService service;

    @PostMapping
    public User create(@RequestBody User user){
        return service.create(user);
    }

    @GetMapping
    public List<User> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable String id){
        return service.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody User user){
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
