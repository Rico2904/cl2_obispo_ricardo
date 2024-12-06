package pe.edu.cibertec.backoffice_mvc_s.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FilmCategoryId implements Serializable {
    private Integer filmId;
    private Integer categoryId;
}
