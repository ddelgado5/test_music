package quipux.co.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quipux.co.entity.Cancion;
import quipux.co.repository.CancionRepository;
import quipux.co.repository.UserRepository;

import java.util.List;

@Service
public class CancionService {
    private Log LOG = LogFactory.getLog(CancionService.class);

    private CancionRepository cancionRepository;

    public CancionService(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    @Transactional
    public void saveTransactional(List<Cancion> cancions){
        cancions.stream().peek(cancion -> LOG.info("agregado: " + cancion))
                .forEach(cancion -> cancionRepository.save(cancion));
    }
    public List<Cancion> getAllCancion(){
        System.out.println("getAllCancion: ");
        return cancionRepository.findAll();
    }

}
