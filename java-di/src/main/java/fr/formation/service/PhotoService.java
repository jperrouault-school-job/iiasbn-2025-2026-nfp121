package fr.formation.service;

import fr.formation.annotation.Inject;
import fr.formation.repo.PhotoRepository;

public class PhotoService {
    @Inject
    private PhotoRepository repository;

    public void findAll() {
        System.out.println(this.repository);
    }
}
