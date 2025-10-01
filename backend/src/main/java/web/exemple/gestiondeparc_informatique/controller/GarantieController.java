package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Garantie;
import web.exemple.gestiondeparc_informatique.repository.GarantieRepository;
import web.exemple.gestiondeparc_informatique.services.GarantieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class GarantieController {

    private final GarantieRepository garantieRepository;
    private final GarantieService garantieService;

    @GetMapping("/garanties")
    public List<Garantie> getAll() {
        return garantieRepository.findAll();
    }

    @GetMapping("/garanties/{id}")
    public ResponseEntity<Garantie> getById(@PathVariable Long id) {
        return garantieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/garanties")
    public Garantie saveGarantie(@RequestBody Garantie garantie) {
        return garantieService.saveGarantie(garantie);
    }

    @DeleteMapping("/garanties/{id}")
    public ResponseEntity<Void> deleteGarantie(@PathVariable Long id) {
        try {
            garantieService.deleteGarantie(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
