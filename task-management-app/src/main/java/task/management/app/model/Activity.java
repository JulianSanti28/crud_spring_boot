package task.management.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "activities")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Activity {
    @Id
    private String id;
    @Indexed(unique = true)
    @NotEmpty(message = "No se permite actividad sin nombre")
    private String nombre;
    private String descripcion;
    @Field("fecha_creacion")
    private Date fechaCreacion;
    @Field("fecha_finalizacion")
    private Date fechaFinalizacion;
    private PrioridadEnum prioridad;
    @Field("state_register")
    private boolean state = true;
    @DBRef
    List<Task> taks = new ArrayList<>();
    @DBRef
    Category category;
}
