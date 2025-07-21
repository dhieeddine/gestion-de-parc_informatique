package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Fournisseur;
import web.exemple.gestiondeparc_informatique.repository.FournisseurRepository;
import web.exemple.gestiondeparc_informatique.services.FournisseurService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")

public class FournisseurController {

    private final FournisseurRepository fournisseurRepository;
    private final FournisseurService fournisseurService;




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
    @PostMapping(path="/fournisseurs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Fournisseur saveFournisseur(
            @RequestPart("nomF") String nomF,
            @RequestPart("adresseF") String adresseF,
            @RequestPart("codePF") String codePF,
            @RequestPart("telF") String telF) throws IOException {
            Fournisseur fournisseur = new Fournisseur(null, nomF, adresseF, codePF, telF);
        return fournisseurService.saveFournisseur(fournisseur);
    }

    @DeleteMapping("/fournisseurs/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        try {
            fournisseurService.deleteFournisseur(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
