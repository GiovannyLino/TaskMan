package uscs.TaskM.service;

import uscs.TaskM.repository.ProjectRepository;
import uscs.TaskM.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(String id) {
        return projectRepository.findById(id);
    }

    public Project update(String id, Project project) {
        project.setId(id);
        return projectRepository.save(project);
    }

    public void delete(String id) {
        projectRepository.deleteById(id);
    }
}