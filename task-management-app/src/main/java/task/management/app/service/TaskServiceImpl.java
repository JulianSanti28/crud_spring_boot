package task.management.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.management.app.dao.IActivityRepository;
import task.management.app.dao.ITaskRepository;
import task.management.app.model.Activity;
import task.management.app.model.StateEnum;
import task.management.app.model.Task;

import java.util.Date;
import java.util.List;
@Service
public class TaskServiceImpl implements ITaskService {
    //Inyección de dependencias
    @Autowired
    private ITaskRepository taskRepository;
    @Autowired
    private IActivityRepository activityRepository;
    @Override
    public Task save(Task task) {
        task.setFechaCreacion(new Date());
        task.setStateTask(StateEnum.PENDIENTE);
        Activity activity = activityRepository.findById(task.getIdActivity()).orElse(null);
        Task db = taskRepository.save(task);
        activity.getTaks().add(db);
        activityRepository.save(activity);
        return db;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(String id) {

    }
}
