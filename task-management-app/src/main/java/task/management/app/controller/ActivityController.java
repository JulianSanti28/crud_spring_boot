package task.management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.management.app.model.Activity;
import task.management.app.service.IActivityService;

import javax.validation.Valid;

@RestController
@RequestMapping("/activity")
public class ActivityController {


    @Autowired
    IActivityService activityService;

    /*C*/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    public ResponseEntity<Activity> save(@RequestBody @Valid Activity activity){
            Activity db = activityService.save(activity);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(db);
    }
    /*R*/
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "{id}")
    public ResponseEntity<Activity> getAll(@PathVariable("id") String id){
        Activity db = activityService.findById(id);
        if(db == null){
            return ResponseEntity.ok(Activity.builder().build());
        }
        return ResponseEntity.ok(db);
    }
    /*U*/
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("update")
    public ResponseEntity<Activity> update(@RequestBody @Valid Activity activity){
        Activity db = activityService.update(activity);
        if(db == null){
            return ResponseEntity.ok(Activity.builder().build());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(db);
    }

    /*D*/
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Activity> delete(@PathVariable("id") String id){
        Activity db = activityService.deleteById(id);
        if(db == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Activity.builder().build());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(db);
    }
}
