package quipux.co.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quipux.co.entity.Cancion;
import quipux.co.entity.User;

import java.util.Optional;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {

    @Query("Select c from Cancion c WHERE c.titulo=?1")
    Optional<Cancion> findByCancionTitulo(String titulo);
}
