package co.empresa.test.modelo;
import lombok.Data;
import java.io.Serializable;
@Data
public class Usuario implements Serializable{
    private Integer id;
    private String nombre;
    private String email;
    private String pais;
}
