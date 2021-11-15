package quipux.co.api;

import quipux.co.entity.ListaDeReproducciones;
import quipux.co.service.ListReproduccionService;

public class PostListReproduccionImplements extends PostListReproduccion {


    private ListReproduccionService listReproduccionService;

    public PostListReproduccionImplements(ListReproduccionService listReproduccionService) {
        this.listReproduccionService = listReproduccionService;

    }

    public ListaDeReproducciones save(ListaDeReproducciones listaDeReproducciones){
        return listReproduccionService.save(listaDeReproducciones);
    };

}
