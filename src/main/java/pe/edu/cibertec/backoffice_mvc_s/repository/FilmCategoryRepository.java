package pe.edu.cibertec.backoffice_mvc_s.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.backoffice_mvc_s.entity.FilmCategory;


@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM FilmCategory fc WHERE fc.film.filmId = :filmId")
    void deleteByFilmId(@Param("filmId") int filmId);
}
