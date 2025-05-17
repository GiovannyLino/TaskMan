package uscs.TaskM.controller;

import uscs.TaskM.model.Project;
import uscs.TaskM.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    public Project create(@RequestBody Project project) {
        return service.create(project);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable String id, @RequestBody Project project) {
        return service.update(id, project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}