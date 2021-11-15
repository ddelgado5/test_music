package quipux.co.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.co.api.GetCancion;
import quipux.co.entity.Cancion;
import quipux.co.service.CancionService;


import java.util.List;

@RestController
@RequestMapping("/api/cancion")
public class CancionRest {

    private GetCancion getCancion;
    private CancionService cancionService;

    public CancionRest(GetCancion getCancion, CancionService cancionService) {

        this.getCancion = getCancion;
        this.cancionService = cancionService;
    }

    @GetMapping("/list")
    List<Cancion> get(){
        return getCancion.getAll();
    }
}
