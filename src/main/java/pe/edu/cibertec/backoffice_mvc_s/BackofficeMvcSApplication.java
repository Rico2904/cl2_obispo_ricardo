package pe.edu.cibertec.backoffice_mvc_s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.cibertec.backoffice_mvc_s.entity.Film;
import pe.edu.cibertec.backoffice_mvc_s.repository.FilmRepository;

import java.util.Optional;

@SpringBootApplication
public class BackofficeMvcSApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackofficeMvcSApplication.class, args);
	}

	@Autowired
	FilmRepository filmRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println("******************************");
		System.out.println("findAll() - 1ra llamada MySQL");
		System.out.println("******************************");
		Iterable<Film> iterable = filmRepository.findAll();
		iterable.forEach((film) -> {
			System.out.print(String.format("%s:%s;", film.getFilmId(), film.getTitle()));
			//System.out.print(message);
		});

		System.out.println();
		System.out.println("******************************");
		System.out.println("findAll() - 2ra llamada MySQL");
		System.out.println("******************************");
		Iterable<Film> iterable2 = filmRepository.findAll();
		iterable2.forEach((film) -> {
			System.out.print(String.format("%s:%s;", film.getFilmId(), film.getTitle()));
			//String message = String.format("%s:%s;", film.getFilmId(), film.getTitle());
			//System.out.print(message);
		});

		/**
		 * findAll - Caching - 3ra
		 */
		System.out.println(" ");
		System.out.println("******************************");
		System.out.println("save() - Film");
		System.out.println("******************************");
		Optional<Film> optional = filmRepository.findById(7);
		optional.ifPresentOrElse(
				(film) -> {
					film.setTitle("PRUEBA 2");
					filmRepository.save(film);
				},
				() -> {
					System.out.println("Film not found");
				}
		);

		System.out.println();
		System.out.println("******************************");
		System.out.println("findAll() - 4ra llamada MySQL");
		System.out.println("******************************");
		Iterable<Film> iterable3 = filmRepository.findAll();
		iterable3.forEach((film) -> {
			System.out.print(String.format("%s:%s;", film.getFilmId(), film.getTitle()));
		});
	}
}
