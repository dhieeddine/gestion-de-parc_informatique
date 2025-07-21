package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.dtos.NewUtilisateurDTO;
import web.exemple.gestiondeparc_informatique.entities.Utilisateur;
import web.exemple.gestiondeparc_informatique.repository.UtilisateurRepository;
import web.exemple.gestiondeparc_informatique.services.UtilisateurService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;

    private final UtilisateurService utilisateurService;





    @GetMapping(path="/utilisateurs")
    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> getById(@PathVariable Long id) {
        return utilisateurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/utilisateurs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Utilisateur saveUtilisateur(
            NewUtilisateurDTO  newUtilisateurDTO){
        Utilisateur utilisateur = new Utilisateur(null,newUtilisateurDTO.getNomU(),newUtilisateurDTO.getPrenomU(),newUtilisateurDTO.getPassword(),newUtilisateurDTO.getDroitU());

        return utilisateurService.saveUtilisateur(utilisateur);
    }


    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        try {
            utilisateurService.deleteUtilisateur(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



}
