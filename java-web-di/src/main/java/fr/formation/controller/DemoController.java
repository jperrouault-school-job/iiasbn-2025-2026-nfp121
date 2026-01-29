package fr.formation.controller;

import fr.formation.annotation.Controller;
import fr.formation.annotation.GetMapping;
import fr.formation.annotation.RequestParam;

@Controller
public class DemoController {
    @GetMapping("/demo")
    public String demo(@RequestParam("username") String username, @RequestParam("id") Integer id) {
        return "Coucou " + username + " id = " + (id * 2);
    }
}
