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
    public Photo findById(@RequestParam("id") Integer id) {
        return this.service.findById(id);
    }
}
