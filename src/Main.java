import entidades.*;
import repositorios.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //Iniciamos los repositorios
        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> articuloInsumoRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> articuloManufacturadoRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();

        //Creamos las categorias disponibles
        Categoria pizza = Categoria.builder().denominacion("Pizzas")
                .build();
        Categoria sandwich = Categoria.builder().denominacion("Sandwiches")
                .build();
        Categoria lomo = Categoria.builder().denominacion("Lomos")
                .build();
        Categoria imsumo = Categoria.builder().denominacion("Insumos")
                .build();

            // Guardar categorias en su repositorio
        categoriaRepository.save(pizza);
        categoriaRepository.save(lomo);
        categoriaRepository.save(sandwich);
        categoriaRepository.save(imsumo);

        //Creamos las unidades de medidas que usaremos
        UnidadMedida litro = UnidadMedida.builder().denomincion("Litro")
                .build();
        UnidadMedida kilogramo = UnidadMedida.builder().denomincion("Kilogramo")
                .build();
        UnidadMedida gramo = UnidadMedida.builder().denomincion("Gramo")
                .build();

            // Guardar unidades de medidas en su repositorio
        unidadMedidaRepository.save(litro);
        unidadMedidaRepository.save(kilogramo);
        unidadMedidaRepository.save(gramo);

        //Creamos los articulos insumos que dispondremos
        ArticuloInsumo aceite = ArticuloInsumo.builder().denominacion("Aceite").precioCompra(500.0).stockMaximo(100).stockActual(70)
                .esParaElaborar(false)
                .unidadMedida(litro)
                .build();
        ArticuloInsumo sal = ArticuloInsumo.builder().denominacion("Sal").precioCompra(400.0).stockMaximo(110).stockActual(80)
                .esParaElaborar(false)
                .unidadMedida(gramo)
                .build();
        ArticuloInsumo carne = ArticuloInsumo.builder().denominacion("Carne").precioCompra(5500.0).stockMaximo(90).stockActual(60)
                .esParaElaborar(true)
                .unidadMedida(kilogramo)
                .build();
        ArticuloInsumo harina = ArticuloInsumo.builder().denominacion("Harina").precioCompra(700.0).stockMaximo(70).stockActual(50)
                .esParaElaborar(true)
                .unidadMedida(gramo)
                .build();

            //Guardar Articulos insumos en su repositorio
        articuloInsumoRepository.save(aceite);
        articuloInsumoRepository.save(sal);
        articuloInsumoRepository.save(carne);
        articuloInsumoRepository.save(harina);

        //Creamos imagenes para las categorias disponibles
        Imagen imagen1 = Imagen.builder().denominacion("HawainaPizza1")
                .build();
        Imagen imagen2 = Imagen.builder().denominacion("HawainaPizza2")
                .build();
        Imagen imagen3 = Imagen.builder().denominacion("HawainaPizza3")
                .build();
        Imagen imagen4 = Imagen.builder().denominacion("LomoCompleto1")
                .build();
        Imagen imagen5 = Imagen.builder().denominacion("LomoCompleto2")
                .build();
        Imagen imagen6 = Imagen.builder().denominacion("LomoCompleto3")
                .build();

        //Creamos los detalles de los articulos manufacturados
        ArticuloManufacturadoDetalle detallePizzaHawaina1 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(sal)
                .build();
        ArticuloManufacturadoDetalle detallePizzaHawaina2 = ArticuloManufacturadoDetalle.builder().cantidad(2).articuloInsumo(harina)
                .build();
        ArticuloManufacturadoDetalle detallePizzaHawaina3 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(aceite)
                .build();
        ArticuloManufacturadoDetalle detalleLomoCompleto1 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(sal)
                .build();
        ArticuloManufacturadoDetalle detalleLomoCompleto2 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(aceite)
                .build();
        ArticuloManufacturadoDetalle detalleLomoCompleto3 = ArticuloManufacturadoDetalle.builder().cantidad(1).articuloInsumo(carne)
                .build();


        //Creamos los articulos manufacturados
            //Primero la pizza hawaina
        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder().denominacion("Pizza Hawaina")
                .descripcion("Base de salsa de tomate, queso fundido, jamón cocido y trozos jugosos de ananá")
                .preparacion("Hornear por 20 minutos")
                .tiempoEstimadoMinutos(20)
                .precioVenta(4000.0)
                .build();
            //Aprovechamos y utilizamos estos metodos creados, no optimizados (se pueden agregar directamente en el patron builder)
        pizzaHawaina.agregarArticuloManufacturadoDetalle(detallePizzaHawaina1);
        pizzaHawaina.agregarArticuloManufacturadoDetalle(detallePizzaHawaina2);
        pizzaHawaina.agregarArticuloManufacturadoDetalle(detallePizzaHawaina3);
            //Aprovechamos y utilizamos estos metodos creados, no optimizados (se pueden agregar directamente en el patron builder)
        pizzaHawaina.agregarImagen(imagen1);
        pizzaHawaina.agregarImagen(imagen2);
        pizzaHawaina.agregarImagen(imagen3);

            //Luego el lomo completo
        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder().denominacion("Lomo Completo")
                .descripcion("Pan con mayonesa y jamón, queso, lechuga, tomate y huevos fritos")
                .preparacion("Cocinar por 50 minutos.")
                .tiempoEstimadoMinutos(50)
                .precioVenta(5000.0)
                .build();

            //Aprovechamos y utilizamos estos metodos creados, no optimizados (se pueden agregar directamente en el patron builder)
        lomoCompleto.agregarArticuloManufacturadoDetalle(detalleLomoCompleto1);
        lomoCompleto.agregarArticuloManufacturadoDetalle(detalleLomoCompleto2);
        lomoCompleto.agregarArticuloManufacturadoDetalle(detalleLomoCompleto3);

        lomoCompleto.agregarImagen(imagen4);
        lomoCompleto.agregarImagen(imagen5);
        lomoCompleto.agregarImagen(imagen6);

        // Guardar Articulos manufacturados en su repositorio
        articuloManufacturadoRepository.save(pizzaHawaina);
        articuloManufacturadoRepository.save(lomoCompleto);

        //-->PROBAMOS EL REPOSITORIO<--
        System.out.println("PRUEBA DEL NUEVO REPOSITORIO DEL SISTEMA:");

        //Mostramos las categorias previamente guardadas
        System.out.println("\nTodas las categorias disponibles en el sistema son:");
        List<Categoria> todasLasCategorias = categoriaRepository.findAll();
        todasLasCategorias.forEach(System.out::println);

        //Mostramos los articulos insumos previamente guardados
        System.out.println("\nTodos los Insumos disponibles en el sistema son:");
        List<ArticuloInsumo> todosLasArtInsumos = articuloInsumoRepository.findAll();
        todosLasArtInsumos.forEach(System.out::println);

        //Mostramos los articulos manufacturados previamente guardados
        System.out.println("\nTodos los Manufacturados disponibles en el sistema son:");
        List<ArticuloManufacturado> todosLosArtManufacturados = articuloManufacturadoRepository.findAll();
        todosLosArtManufacturados.forEach(System.out::println);

        // Encontrar un articulo manufacturado por su ID
        System.out.println("\nBuscamos a un articulo manufacturado por su ID:");
        Optional<ArticuloManufacturado> artManufacturadoEncontradoPorID = articuloManufacturadoRepository.findById(1L);
        artManufacturadoEncontradoPorID.ifPresent(e -> System.out.println("\nArticulo manufacturado encontrado por ID 1: " + e));

        //Actualizar los datos de un articulo manufacturado buscando por su ID. Por ejemplo modificar su descripcion
        System.out.println("\nActualizamos la preparacion del Articulo manufacturado Pizza Hawaina:");
        ArticuloManufacturado pizzaHawainaActualizada = ArticuloManufacturado.builder().denominacion("Pizza Hawaina")
                .descripcion("Base de salsa de tomate, queso fundido, jamón cocido y trozos jugosos de ananá natural")
                .preparacion("Hornear por 20 minutos")
                .tiempoEstimadoMinutos(20)
                //Manera de utilizar el HashSet de forma optima sin necesidad de recurrir a otros metodos.
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detallePizzaHawaina1, detallePizzaHawaina2, detallePizzaHawaina3)))
                .imagenes(new HashSet<>(Set.of(imagen1, imagen2, imagen3)))
                .build();

            //Guardamos los cambios
        articuloManufacturadoRepository.genericUpdate(1L, pizzaHawainaActualizada);

        //Aqui mostramos los cambios hechos
        Optional<ArticuloManufacturado> artManufacturadoVerificado = articuloManufacturadoRepository.findById(1L);
        artManufacturadoVerificado.ifPresent(e -> System.out.println("Articulo manufacturado después de la actualización: " + e));

        //Eliminar una empresa por su ID, por ejemplo el articulo Manufacturado Pizza
        articuloManufacturadoRepository.genericDelete(1L);

        //Mostramos a todas las empresas de nuevo, para verificar que se haya eliminado correctamente.
        System.out.println("\nTodos los articulos manufacturados, luego de la actualizacion:");
        List<ArticuloManufacturado> todosLosArtManufacturados2 = articuloManufacturadoRepository.findAll();
        todosLosArtManufacturados2.forEach(System.out::println);

    }
}