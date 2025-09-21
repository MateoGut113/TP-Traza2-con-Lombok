package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@SuperBuilder //Herencia

public abstract class Articulo {
    protected String denominacion;
    protected Double precioVenta;
    protected Long id;

    //Relaciones con otras clases
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    private UnidadMedida unidadMedida;
    //private Categoria categoria; <-- No va por direccion de la relacion.

    //Metodo no necesario, debido a que el patron builder se encarga de la agregacion a la lista.
    public void agregarImagen (Imagen imagen){
        imagenes.add(imagen);
    }

}
