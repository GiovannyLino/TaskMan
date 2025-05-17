package uscs.TaskM.repository;
import uscs.TaskM.model.THistory;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface THistoryRepository extends MongoRepository<THistory, String>{
    List<THistory> findByTaskId(String taskId);
}