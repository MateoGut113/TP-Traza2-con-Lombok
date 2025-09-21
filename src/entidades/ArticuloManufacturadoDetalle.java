package entidades;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ArticuloManufacturadoDetalle {
    private Long id;
    private int cantidad;

    //Relaciones con otras clases
    //private ArticuloManufacturado articuloManufacturado; <-- No va por direccion de la relacion.
    private ArticuloInsumo articuloInsumo;

}
