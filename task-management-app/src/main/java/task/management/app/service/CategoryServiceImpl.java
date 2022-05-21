package task.management.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.management.app.dao.ICategoryRepository;
import task.management.app.model.Category;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {

    //Inyección de dependencias
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(String id) {

    }
}
