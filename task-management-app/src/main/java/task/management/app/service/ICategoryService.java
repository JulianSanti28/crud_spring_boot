package task.management.app.service;

import task.management.app.model.Category;

import java.util.List;

public interface ICategoryService {
    public Category save(Category category);
    public List<Category> findAll();
    public Category findById(String id);
    public Category update(Category category);
    public void deleteById(String id);
}
