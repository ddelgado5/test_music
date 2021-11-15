package quipux.co;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import quipux.co.Bean.MyBeanWithProperties;
import quipux.co.component.ComponentDependency;
import quipux.co.entity.Cancion;
import quipux.co.entity.ListaDeReproducciones;
import quipux.co.entity.User;
import quipux.co.repository.CancionRepository;
import quipux.co.repository.ListaDeReproduccionesRepository;
import quipux.co.repository.UserRepository;
import quipux.co.service.CancionService;
import quipux.co.service.ListReproduccionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CoApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(CoApplication.class);
	private ComponentDependency componentDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private quipux.co.pojo.User user;
	private UserRepository userRepository;
	private ListaDeReproduccionesRepository listaDeReproduccionesRepository;
	private CancionRepository cancionRepository;
	private CancionService cancionService;
	private ListReproduccionService listReproduccionService;

	public CoApplication(ComponentDependency componentDependency,
						 MyBeanWithProperties myBeanWithProperties,
						 quipux.co.pojo.User user, UserRepository userRepository,
						 ListaDeReproduccionesRepository listaDeReproduccionesRepository,
						 CancionRepository cancionRepository, CancionService cancionService,
						 ListReproduccionService listReproduccionService){

		this.componentDependency = componentDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.user = user;
		this.userRepository = userRepository;
		this.listaDeReproduccionesRepository = listaDeReproduccionesRepository;
		this.cancionRepository = cancionRepository;
		this.cancionService = cancionService;
		this.listReproduccionService = listReproduccionService;

	}

	public static void main(String[] args) {
		SpringApplication.run(CoApplication.class, args);

	}

	@Override
	public void run(String... args){

//		componentDependency.saludar();
//		System.out.println(myBeanWithProperties.function());
//		System.out.println(user.getEmail());
		LOGGER.error("*********ERROR: ocurrio un error inesperado ************** ");
		saveUsers();
		saveCanciones();
		saveListaDeReproducciones();
		getUserByEmail();
		saveCancion();
//		saveRepro();
		//getCancionByTitulo();
		deleteRegister();
	}

	private void saveUsers(){
		User admin = new User ("admin@gmail.com", "123");
		User sopor = new User ("soporte@gmail.com", "123");
		List<User> list = Arrays.asList(admin);
		userRepository.save(admin);
		userRepository.save(sopor);
	}

	private void deleteRegister(){
		listReproduccionService.delete("a");
		listReproduccionService.getAllRepro().stream()
				.forEach(item -> LOGGER.info("despues de borrar: "+ item));

	}

	private void saveCancion(){
		Cancion c1 = new Cancion ("admin", "123","album 1","1993");
		Cancion c2 = new Cancion ("soporte", "B", "album 2", "2021");
		List<Cancion> list = Arrays.asList(c1,c2);
		try{
			cancionService.saveTransactional(list);
		}catch (Exception e){
			LOGGER.info("ERROR saveTransactional : -----------------");
		}
		cancionService.getAllCancion().stream()
		.forEach(cancion -> LOGGER.info("Este es saveCancion Transactional: "+ cancion));

	}

	private void saveRepro(){
		ListaDeReproducciones list1 = new ListaDeReproducciones ("lista 1 nombre", "musica");
		ListaDeReproducciones list2 = new ListaDeReproducciones ("lista 2 nombre", "de la buena");
		List<ListaDeReproducciones> list = Arrays.asList(list1,list2);
		try{
			listReproduccionService.saveTransactional(list);
		}catch (Exception e){
			LOGGER.info("ERROR saveTransactional lista de reproducciones : -----------------");
		}
		listReproduccionService.getAllRepro().stream()
				.forEach(item -> LOGGER.info("Este es saveCancion Transactional: "+ item));

	}


	private void getUserByEmail(){
		LOGGER.info("Usuario es:  "+ userRepository.findByUserEmail("admin@gmail.com")
				.orElseThrow(() -> new RuntimeException("No se encontraron resultados ")));
		userRepository.findByUserEmail("admin@gmail.com").stream().forEach(
				user -> LOGGER.info("Usuario es = :" + user));

//		LOGGER.info("------- el usuario con ID buscado es:  "+
//				userRepository.findByUserId(1).orElseThrow(()->
//						new RuntimeException("no esta! ")
//				));
	}
	private void getCancionByTitulo(){
		LOGGER.info("Cancion es:  "+ cancionRepository.findByCancionTitulo("a")
				.orElseThrow(()->new RuntimeException("No se encontraron resultados ")));
	}


	List<Cancion> listCan;
	private void saveCanciones(){
		Cancion can1 = new Cancion ("a", "b", "c", "2021");
		Cancion can2 = new Cancion ("d", "e", "f", "2022");
		listCan = Arrays.asList(can1,can2);
		cancionRepository.save(can1);
	}
	private void saveListaDeReproducciones(){
		ListaDeReproducciones can1 = new ListaDeReproducciones ("a", "b");
		ListaDeReproducciones can2 = new ListaDeReproducciones("d", "e");
		ListaDeReproducciones can3 = new ListaDeReproducciones("Dia", "este");

		listaDeReproduccionesRepository.save(can1);
		listaDeReproduccionesRepository.save(can2);
		listaDeReproduccionesRepository.save(can3);
	}


}
