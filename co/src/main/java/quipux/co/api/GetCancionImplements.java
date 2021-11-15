package quipux.co.api;

import quipux.co.entity.Cancion;
import quipux.co.service.CancionService;

import java.util.List;

public class GetCancionImplements implements GetCancion {
    private CancionService cancionService;

    public GetCancionImplements(CancionService cancionService) {

        this.cancionService = cancionService;
    }

    @Override
    public List<Cancion> getAll() {
        return cancionService.getAllCancion();
    }

}
