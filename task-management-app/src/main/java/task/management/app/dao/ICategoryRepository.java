package task.management.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import task.management.app.model.Category;
@Repository
public interface ICategoryRepository extends MongoRepository<Category,String> {
}
