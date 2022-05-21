package task.management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.management.app.model.Task;
import task.management.app.service.ITaskService;

import javax.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {
    //Inyectar los servicios
    @Autowired
    private ITaskService taskService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Task> save(@RequestBody @Valid Task task){
        Task db = taskService.save(task);
        return ResponseEntity.ok(db);
    }
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Task> getById(@PathVariable("id") String id){
        Task taskBd = taskService.findById(id);
        if(taskBd == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskBd);
    }


}
