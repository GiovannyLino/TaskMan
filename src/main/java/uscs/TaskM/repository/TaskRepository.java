package uscs.TaskM.repository;
import uscs.TaskM.model.Task;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String>{
    List<Task> findByProjectId(String projectId);
}

