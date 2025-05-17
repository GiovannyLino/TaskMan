package uscs.TaskM.repository;
import uscs.TaskM.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {}



