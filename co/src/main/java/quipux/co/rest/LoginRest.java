package quipux.co.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quipux.co.api.GetUser;
import quipux.co.entity.ListaDeReproducciones;
import quipux.co.entity.User;
import quipux.co.service.LoginService;
import quipux.co.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginRest {

    private LoginService loginService;

    public LoginRest(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    ResponseEntity login(@RequestBody User user){
        return new ResponseEntity<>(loginService.login(user.getEmail(), user.getPassword()), HttpStatus.ACCEPTED);
    }
}
