package pe.edu.cibertec.backoffice_mvc_s.dto;

//PASO 4
//similar a un constructor , SOLO PONGO DATOS QUE DESEO RETORNAR
public record FilmDto(Integer filmId,
                      String title,
                      String language,
                      Integer rentalDuration,
                      Double rentalRate) {
}

