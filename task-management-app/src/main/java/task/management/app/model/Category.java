package task.management.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;


@Data
@Document(collection = "category")
public class Category {
    @Id
    private String id;
    @NotEmpty(message = "Se debe agregar el tipo de categoria")
    private CategoryEnum nombre;
    @NotEmpty(message = "Se debe agregar descripción de la categoría")
    private String descripcion;

}
