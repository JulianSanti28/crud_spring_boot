package task.management.app.service;

import org.springframework.stereotype.Service;
import task.management.app.dao.ITaskRepository;
import task.management.app.model.Activity;
import task.management.app.model.Task;

import java.util.List;

@Service
public interface ITaskService{
    public Task save(Task task);
    public List<Task> findAll();
    public Task findById(String id);
    public Task update(Task task);
    public void deleteById(String id);
}
