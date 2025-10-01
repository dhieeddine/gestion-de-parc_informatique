package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Ecran;
import web.exemple.gestiondeparc_informatique.repository.EcranRepository;
import web.exemple.gestiondeparc_informatique.services.EcranService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class EcranController {

    private final EcranRepository ecranRepository;
    private final EcranService ecranService;

    @GetMapping("/ecrans")
    public List<Ecran> getAll() {
        return ecranRepository.findAll();
    }

    @GetMapping("/ecrans/{id}")
    public ResponseEntity<Ecran> getById(@PathVariable Long id) {
        return ecranRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/ecrans", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Ecran saveEcran(@RequestBody Ecran ecran) {
        return ecranService.saveEcran(ecran);
    }

    @DeleteMapping("/ecrans/{id}")
    public ResponseEntity<Void> deleteEcran(@PathVariable Long id) {
        try {
            ecranService.deleteEcran(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
