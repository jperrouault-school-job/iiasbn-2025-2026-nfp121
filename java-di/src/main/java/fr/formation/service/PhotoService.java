package fr.formation.service;

import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.repo.PhotoRepository;

@Component
public class PhotoService {
    @Inject
    private PhotoRepository repository;

    public void findAll() {
        System.out.println(this.repository);
    }
}
