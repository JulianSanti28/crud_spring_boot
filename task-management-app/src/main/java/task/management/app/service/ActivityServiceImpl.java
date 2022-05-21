package task.management.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.management.app.dao.IActivityRepository;
import task.management.app.model.Activity;
import task.management.app.model.Task;

import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements IActivityService{
    //Inyección de dependencias
    @Autowired
    private IActivityRepository activityRepository;
    @Override
    public Activity save(Activity activity) {
        activity.setFechaCreacion(new Date());
        activity.setState(true);
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(String id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public Activity update(Activity activity) {
        Activity db = findById(activity.getId());
        if(db == null){
            return null;
        }
        db.setDescripcion(activity.getDescripcion());
        db.setNombre(activity.getNombre());
        db.setPrioridad(activity.getPrioridad());
        activityRepository.save(db);
        return db;
    }

    @Override
    public Activity deleteById(String id) {
        Activity db = findById(id);
        if(db == null){
            return null;
        }
        db.setState(false);
        return activityRepository.save(db);
    }
}
