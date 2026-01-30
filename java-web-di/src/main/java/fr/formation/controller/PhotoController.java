package fr.formation.controller;

import fr.formation.annotation.Controller;
import fr.formation.annotation.GetMapping;
import fr.formation.annotation.Inject;
import fr.formation.annotation.RequestParam;
import fr.formation.model.Photo;
import fr.formation.service.PhotoService;

@Controller
public class PhotoController {
    @Inject
    private PhotoService service;

    @GetMapping("/photo")
    public String findById(@RequestParam("id") Integer id) {
        Photo photo = this.service.findById(id);

        if (photo != null) {
            return this.service.findById(id).getTitle();
        }

        return "";
    }
}
