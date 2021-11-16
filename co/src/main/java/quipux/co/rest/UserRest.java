package quipux.co.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.co.api.GetUser;
import quipux.co.entity.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRest {

    private GetUser getUser;

    public UserRest(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }
}
