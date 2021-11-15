package quipux.co.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quipux.co.api.DeleteListReproduccion;
import quipux.co.api.GetCancion;
import quipux.co.api.GetListReproduccion;
import quipux.co.api.PostListReproduccion;
import quipux.co.entity.Cancion;
import quipux.co.entity.ListaDeReproducciones;
import quipux.co.pojo.ListaDeReproduccion;
import quipux.co.service.CancionService;
import quipux.co.service.ListReproduccionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reproduccion")
public class ListReproduccionRest {

    private GetListReproduccion getListReproduccion;
    private ListReproduccionService listReproduccionService;
    private CancionService cancionService;
    private PostListReproduccion postListReproduccion;
    private DeleteListReproduccion deleteListReproduccion;

    public ListReproduccionRest(GetListReproduccion getListReproduccion,
                                CancionService cancionService,
                                ListReproduccionService listReproduccionService,
                                PostListReproduccion postListReproduccion,
                                DeleteListReproduccion deleteListReproduccion) {

        this.getListReproduccion = getListReproduccion;
        this.cancionService = cancionService;
        this.listReproduccionService = listReproduccionService;
        this.postListReproduccion = postListReproduccion;
        this.deleteListReproduccion = deleteListReproduccion;
    }

    @GetMapping("/lists")
    List<ListaDeReproducciones> get(){
        return getListReproduccion.getAll();
    }

    @GetMapping("/lists/{nombre}")
    ListaDeReproducciones getNombreRepro(@RequestParam (required = false) String nombre ){
        return getListReproduccion.getNombreRepro(nombre);
    }

    @PostMapping("/lists")
    ResponseEntity<ListaDeReproducciones> newList(@RequestBody ListaDeReproducciones listaDeReproducciones){
        return new ResponseEntity<>(postListReproduccion.save(listaDeReproducciones), HttpStatus.CREATED);
    }

    @DeleteMapping("/lists/{nombre}")
    ResponseEntity<ListaDeReproducciones> deleteListById(@PathVariable String nombre){
        deleteListReproduccion.remove(nombre);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
