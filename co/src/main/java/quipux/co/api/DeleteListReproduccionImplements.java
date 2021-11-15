package quipux.co.api;

import quipux.co.entity.User;
import quipux.co.service.UserService;

import java.util.List;

public class DeleteListReproduccionImplements implements GetUser {
    private UserService userService;

    public DeleteListReproduccionImplements(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

}
