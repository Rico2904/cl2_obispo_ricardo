package pe.edu.cibertec.backoffice_mvc_s.dto;


import java.util.Date;

//PASO 8 , como es un detalle declaro todas las variables
//Declaro todas las variables de entrada
public record FilmDetailDto(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            String languageName,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String rating,
                            String specialFeatures,
                            Date lastUpdate) {
}