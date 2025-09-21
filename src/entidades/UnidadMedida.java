package entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UnidadMedida {
    private Long id;
    private String denomincion;

    //Relaciones con otras clases.
    //@Builder.Default <-- No va por direccion de la relacion.
    //private Set<Articulo> articulos = new HashSet<>();

}
