package fr.formation.controller;

import fr.formation.annotation.Controller;
import fr.formation.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "Coucou";
    }
}
