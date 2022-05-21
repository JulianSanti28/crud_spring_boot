package task.management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.management.app.model.Category;
import task.management.app.service.ICategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    //Inyectar los servicios
    @Autowired
    private ICategoryService categoryService;
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> save(@RequestBody @Valid Category category){
        Category db = categoryService.save(category);
        return ResponseEntity.ok(db);
    }
}
