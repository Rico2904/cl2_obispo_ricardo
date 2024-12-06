package pe.edu.cibertec.backoffice_mvc_s.repository;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.backoffice_mvc_s.entity.Film;

//PASO 2 CON ALGUNA DE LAS ENTIDADES
@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    //bloq
    @Modifying
    @Transactional
    @Query("DELETE FROM Film f WHERE f.id = :filmId")
    void deleteByFilmId(Integer filmId);

    //caching
    @CacheEvict(value = "films", allEntries = true)
    Film save(Film film);

}

//PASO 3 **SERVICE