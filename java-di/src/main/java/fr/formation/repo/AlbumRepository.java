package fr.formation.repo;

import java.util.ArrayList;
import java.util.List;

import fr.formation.annotation.Component;


@Component
public class AlbumRepository {
    public List<String> findAll() {
        return new ArrayList<>();
    }
}
