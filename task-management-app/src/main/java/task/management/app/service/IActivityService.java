package task.management.app.service;

import org.springframework.stereotype.Service;
import task.management.app.model.Activity;

import java.util.List;


public interface IActivityService {
    public Activity save(Activity activity);
    public List<Activity> findAll();
    public Activity findById(String id);
    public Activity update(Activity activity);
    public Activity deleteById(String id);
}
