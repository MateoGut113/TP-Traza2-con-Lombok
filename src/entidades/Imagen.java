package entidades;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Imagen {
    private String denominacion;
    private Long id;

    //Relaciones con otras clases
    //private Articulo articulo; <-- No va por direccion de la relacion.
}
