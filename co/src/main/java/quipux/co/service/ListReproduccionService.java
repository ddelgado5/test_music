package quipux.co.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quipux.co.entity.ListaDeReproducciones;
import quipux.co.pojo.ListaDeReproduccion;
import quipux.co.repository.ListaDeReproduccionesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ListReproduccionService {
    private Log LOG = LogFactory.getLog(ListReproduccionService.class);

    private ListaDeReproduccionesRepository listaDeReproduccionesRepository;

    public ListReproduccionService(ListaDeReproduccionesRepository listaDeReproduccionesRepository) {
        this.listaDeReproduccionesRepository = listaDeReproduccionesRepository;
    }

    @Transactional
    public void saveTransactional(List<ListaDeReproducciones> listasDeReproducciones){
        listasDeReproducciones.stream().peek(lista -> LOG.info("agregado: " + lista))
                .forEach(lista -> listaDeReproduccionesRepository.save(lista));
    }
    public List<ListaDeReproducciones> getAllRepro(){
        System.out.println("getAllRepro: ");
        return listaDeReproduccionesRepository.findAll();
    }

    public ListaDeReproducciones getNombreRepro(String nombre){
        System.out.println("getNombreRepro: ");
        return listaDeReproduccionesRepository.findByListaDeReproduccionesNombre(nombre);
    }

    public ListaDeReproducciones save(ListaDeReproducciones listaDeReproducciones) {
        return listaDeReproduccionesRepository.save(listaDeReproducciones);
    }

    public void delete(Long id) {

        listaDeReproduccionesRepository.delete(new ListaDeReproducciones(id));
    }
}
