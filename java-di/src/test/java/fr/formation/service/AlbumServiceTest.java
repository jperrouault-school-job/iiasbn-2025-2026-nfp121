package fr.formation.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.formation.repo.AlbumRepository;
import fr.formation.repo.PhotoRepository;

@ExtendWith(MockitoExtension.class) // Exécution du test avec Mockito
class AlbumServiceTest {
    @Mock // Demande à Mockito de créer un Mock du type
    private AlbumRepository repository;

    @Mock
    private PhotoRepository photoRepository;

    @InjectMocks // Demande à Mockito de créer une instance de AlbumService, en injectant les Mocks disponibles
    private AlbumService service;

    @Test
    void shouldHaveDependencies() {
        service.findAll();

        Mockito.verify(repository).findAll();
    }
}
