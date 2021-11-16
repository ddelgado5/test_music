package quipux.co.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import quipux.co.entity.ListaDeReproducciones;
import quipux.co.entity.User;
import quipux.co.repository.UserRepository;

@Service
public class LoginService {
    private Log LOG = LogFactory.getLog(LoginService.class);

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password){
        System.out.println("login: " + email + " - "+ password);
        User user = userRepository.findByUserEmailPassword(email, password);
        if(user != null){
            System.out.println("se loguea: " + email + " - "+ password);
            return true;

        }
        return false;
    }

}
