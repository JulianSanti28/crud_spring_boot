package task.management.app.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Document(collection = "task")
@Builder
public class Task {
    @Id
    private String id;
    @NotEmpty(message = "Se debe agregar titulo de la tarea")
    private String nombre;
    @NotEmpty(message = "Se debe agregar descripción de la tarea")
    private String descripcion;
    /*@NotEmpty(message = "La tarea debe tener una prioridad")*/
    private PrioridadEnum prioridad;
    @Field("fecha_creacion")
    private Date fechaCreacion;
    @Field("fecha_finalizacion")
    private Date fechaFinalizacion;
    private boolean state;
    private StateEnum stateTask;
    @Field("id_activity")
    private String idActivity;
}
