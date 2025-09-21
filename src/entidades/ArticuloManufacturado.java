package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;

    //Relaciones con otras clases
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();

    //Metodo no necesario, debido a que el patron builder se encarga de la agregacion a la lista.
    public void agregarArticuloManufacturadoDetalle (ArticuloManufacturadoDetalle articuloManufacturadoDetalle){
        articuloManufacturadoDetalles.add(articuloManufacturadoDetalle);
    }

}
