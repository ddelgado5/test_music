package quipux.co.api;

import quipux.co.entity.ListaDeReproducciones;
import quipux.co.service.ListReproduccionService;

public class PostListReproduccion {

    private ListReproduccionService listReproduccionService;

    public PostListReproduccion(ListReproduccionService listReproduccionService) {
        this.listReproduccionService = listReproduccionService;

    }

    public PostListReproduccion() {
    }

    public ListaDeReproducciones save(ListaDeReproducciones listaDeReproducciones){
        return listReproduccionService.save(listaDeReproducciones);
    };



}
