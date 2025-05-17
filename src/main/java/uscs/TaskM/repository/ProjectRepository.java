package uscs.TaskM.repository;
import uscs.TaskM.model.Project;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProjectRepository extends MongoRepository<Project, String>{}
