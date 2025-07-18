package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Fournisseur;
import web.exemple.gestiondeparc_informatique.repository.FournisseurRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FournisseurController {

    private final FournisseurRepository fournisseurRepository;
    @CrossOrigin("*")



    @GetMapping(path="/fournisseurs")
    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        return fournisseurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
