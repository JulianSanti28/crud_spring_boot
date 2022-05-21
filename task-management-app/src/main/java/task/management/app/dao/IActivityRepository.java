package task.management.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import task.management.app.model.Activity;

@Repository
public interface IActivityRepository extends MongoRepository<Activity,String> {
}
