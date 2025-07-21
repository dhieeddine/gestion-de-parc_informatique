package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Marque;
import web.exemple.gestiondeparc_informatique.repository.MarqueRepository;
import web.exemple.gestiondeparc_informatique.services.MarqueService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class MarqueController {

    private final MarqueRepository marqueRepository;
    private final MarqueService marqueService;

    @GetMapping(path = "/marques")
    public List<Marque> getAll() {
        return marqueRepository.findAll();
    }

    @GetMapping("/marques/{id}")
    public ResponseEntity<Marque> getById(@PathVariable Long id) {
        return marqueRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/marques", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Marque saveMarque(@RequestPart("nomMarque") String nomMarque) throws IOException {
        Marque marque = new Marque(null, nomMarque);
        return marqueService.saveMarque(marque);
    }

    @DeleteMapping("/marques/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Long id) {
        try {
            marqueService.deleteMarque(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
