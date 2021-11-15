package quipux.co.api;

import quipux.co.entity.ListaDeReproducciones;
import quipux.co.pojo.ListaDeReproduccion;
import quipux.co.service.ListReproduccionService;

import java.util.List;

public class GetListReproduccionImplements implements GetListReproduccion {
    private ListReproduccionService listReproduccionService;

    public GetListReproduccionImplements(ListReproduccionService listReproduccionService) {

        this.listReproduccionService = listReproduccionService;
    }

    @Override
    public List<ListaDeReproducciones> getAll() {
        return listReproduccionService.getAllRepro();
    }

    @Override
    public ListaDeReproducciones getNombreRepro(String nombre) {
        return  listReproduccionService.getNombreRepro(nombre);
    }

}
