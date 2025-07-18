package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Emplacement;
import web.exemple.gestiondeparc_informatique.entities.Fournisseur;
import web.exemple.gestiondeparc_informatique.repository.EmplacementRepository;
import web.exemple.gestiondeparc_informatique.repository.FournisseurRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmplacementController {

    private final EmplacementRepository emplacementRepository;
    @CrossOrigin("*")



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


}
