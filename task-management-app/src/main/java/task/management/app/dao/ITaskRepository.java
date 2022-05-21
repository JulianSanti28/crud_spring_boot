package task.management.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import task.management.app.model.Task;
@Repository
public interface ITaskRepository extends MongoRepository<Task,String> {
}
