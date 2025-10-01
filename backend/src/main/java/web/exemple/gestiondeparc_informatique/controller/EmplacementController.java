package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Emplacement;
import web.exemple.gestiondeparc_informatique.repository.EmplacementRepository;
import web.exemple.gestiondeparc_informatique.services.EmplacementService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")

public class EmplacementController {

    private final EmplacementRepository emplacementRepository;
    private final EmplacementService emplacementService;



    @GetMapping(path="/emplacements")
    public List<Emplacement> getAll() {
        return emplacementRepository.findAll();
    }

    @GetMapping("/emplacements/{id}")
    public ResponseEntity<Emplacement> getById(@PathVariable Long id) {
        return emplacementRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="/emplacements", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Emplacement saveEmplacement(
            @RequestPart("nomEmplacement") String nomEmplacement,
            @RequestPart("service") String service) throws IOException {
            Emplacement emplacement = new Emplacement(null,nomEmplacement, service);
            return emplacementService.saveEmplacement(emplacement);    }
    @DeleteMapping("/emplacements/{id}")
    public ResponseEntity<Void> deleteEmplacement(@PathVariable Long id) {
        try {
            emplacementService.deleteEmplacement(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



}
