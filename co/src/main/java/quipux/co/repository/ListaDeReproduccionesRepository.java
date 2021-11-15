package quipux.co.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quipux.co.entity.ListaDeReproducciones;
import quipux.co.pojo.ListaDeReproduccion;

import java.util.Optional;

@Repository
public interface ListaDeReproduccionesRepository extends JpaRepository<ListaDeReproducciones, Long> {
    @Query("Select c from ListaDeReproducciones c WHERE c.nombre=?1")
    ListaDeReproducciones findByListaDeReproduccionesNombre(String nombre);
}
