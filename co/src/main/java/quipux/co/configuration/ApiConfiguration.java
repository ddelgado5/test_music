package quipux.co.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quipux.co.api.DeleteListReproduccion;
import quipux.co.api.GetCancion;
import quipux.co.api.GetCancionImplements;
import quipux.co.api.GetListReproduccion;
import quipux.co.api.GetListReproduccionImplements;
import quipux.co.api.GetUser;
import quipux.co.api.GetUserImplements;
import quipux.co.api.PostListReproduccion;
import quipux.co.api.PostListReproduccionImplements;
import quipux.co.service.CancionService;
import quipux.co.service.ListReproduccionService;
import quipux.co.service.UserService;

@Configuration
public class ApiConfiguration {
    @Bean
    GetUser getUser(UserService userService){

        return new GetUserImplements(userService);
    }

    @Bean
    GetCancion getCancion(CancionService cancionService){

        return new GetCancionImplements(cancionService);
    }

    @Bean
    GetListReproduccion getReproduccion(ListReproduccionService listReproduccionService){
        return new GetListReproduccionImplements(listReproduccionService);
    }

//    @Bean
//    GetListReproduccionImplements getListReproduccion(ListReproduccionService nombre){
//        return new GetListReproduccionImplements(nombre);
//    }

    @Bean
    PostListReproduccion postListReproduccion(ListReproduccionService listReproduccionService){
        return new PostListReproduccionImplements(listReproduccionService);
    }

    @Bean
    DeleteListReproduccion deleteListReproduccion(ListReproduccionService listReproduccionService){
        return new DeleteListReproduccion(listReproduccionService);
    }

}
