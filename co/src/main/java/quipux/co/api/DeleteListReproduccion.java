package quipux.co.api;

import quipux.co.entity.User;
import quipux.co.service.ListReproduccionService;

import java.util.List;

public class DeleteListReproduccion {

    private ListReproduccionService listReproduccionService;

    public DeleteListReproduccion(ListReproduccionService listReproduccionService) {
        this.listReproduccionService = listReproduccionService;
    }

    public void remove(String nombre){
    listReproduccionService.delete(nombre);
    };
}
