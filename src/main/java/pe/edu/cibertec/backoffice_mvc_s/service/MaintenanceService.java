package pe.edu.cibertec.backoffice_mvc_s.service;


//la entidad no puede pasar aca

import pe.edu.cibertec.backoffice_mvc_s.dto.FilmCreateDto;
import pe.edu.cibertec.backoffice_mvc_s.dto.FilmDetailDto;
import pe.edu.cibertec.backoffice_mvc_s.dto.FilmDto;

import java.util.List;

//PASO 3 - CREAR EL SERVICE QUE ME PERMITE IR A LA CAPA DE DATOS
public interface MaintenanceService {
    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean deleteFilm(int filmId);

    Boolean createFilm(FilmCreateDto filmCreateDto);
}


// COMO NECESITA IMPLEMENTAR PASO 5 - impl/clase MaintenanceService