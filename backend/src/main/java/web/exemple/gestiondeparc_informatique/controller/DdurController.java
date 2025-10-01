package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Ddur;
import web.exemple.gestiondeparc_informatique.repository.DdurRepository;
import web.exemple.gestiondeparc_informatique.services.DdurService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class DdurController {

    private final DdurRepository ddurRepository;
    private final DdurService ddurService;

    @GetMapping("/ddurs")
    public List<Ddur> getAll() {
        return ddurRepository.findAll();
    }

    @GetMapping("/ddurs/{id}")
    public ResponseEntity<Ddur> getById(@PathVariable Long id) {
        return ddurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/ddurs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Ddur saveDdur(
            @RequestPart("capaciteDD") String capaciteDD,
            @RequestPart("typeDD") String typeDD,
            @RequestPart("etatDD") String etatDD) throws IOException {

        Ddur ddur = new Ddur(null, capaciteDD, typeDD, etatDD);
        return ddurService.saveDdur(ddur);
    }

    @DeleteMapping("/ddurs/{id}")
    public ResponseEntity<Void> deleteDdur(@PathVariable Long id) {
        try {
            ddurService.deleteDdur(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
