package pe.edu.cibertec.backoffice_mvc_s.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.backoffice_mvc_s.entity.FilmActor;


@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {
    //---
    @Transactional
    @Modifying
    @Query("DELETE FROM FilmActor fa WHERE fa.film.filmId = :filmId")
    void deleteByFilmId(@Param("filmId") int filmId);
}
