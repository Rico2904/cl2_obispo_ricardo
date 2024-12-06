package pe.edu.cibertec.backoffice_mvc_s.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.backoffice_mvc_s.dto.FilmCreateDto;
import pe.edu.cibertec.backoffice_mvc_s.dto.FilmDetailDto;
import pe.edu.cibertec.backoffice_mvc_s.dto.FilmDto;

import pe.edu.cibertec.backoffice_mvc_s.service.MaintenanceService;

import java.util.List;

//paso 6
@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    //
    @PostMapping("/remove/{id}")
    public String removeFilm(@PathVariable Integer id, Model model) {
        boolean isDeleted = maintenanceService.deleteFilm(id);

        if (isDeleted) {
            // Si la eliminación es exitosa, redirigir a la lista de películas
            return "redirect:/maintenance/start";
        } else {
            // Si hubo un error, mostrar mensaje de error
            model.addAttribute("errorMessage", "Error al eliminar la película.");
            return "maintenance";
        }
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("filmCreateDto", new FilmCreateDto(
                "", // title
                "", // description
                0,  // releaseYear
                1,  // languageId (por ejemplo, se puede poner un valor predeterminado)
                0,  // rentalDuration
                0.0, // rentalRate
                0,  // length
                0.0, // replacementCost
                "",  // rating
                ""   // specialFeatures
        ));
        return "maintenance_create";  // Vista donde se mostrará el formulario
    }


    @PostMapping("/create-confirm")
    public String createConfirm(@ModelAttribute FilmCreateDto filmCreateDto, Model model) {
        boolean isCreated = maintenanceService.createFilm(filmCreateDto);

        if (isCreated) {
            // Si la creación es exitosa, redirigir a la lista de películas
            return "redirect:/maintenance/start";
        } else {
            // Si hubo un error, mostrar mensaje de error
            model.addAttribute("errorMessage", "Error al crear la película.");
            return "maintenance_create";  // Mostrar nuevamente el formulario con un mensaje de error
        }
    }
}