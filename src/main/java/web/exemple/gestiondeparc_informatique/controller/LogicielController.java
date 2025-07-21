package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.dtos.NewLogicielDTO;
import web.exemple.gestiondeparc_informatique.entities.Logiciel;
import web.exemple.gestiondeparc_informatique.repository.LogicielRepository;
import web.exemple.gestiondeparc_informatique.services.LogicielService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")

public class LogicielController {
    private final LogicielRepository repository;
    private final LogicielService logicielService;

    @GetMapping(path= "/logiciels")
    public List<Logiciel> getAll() { return repository.findAll(); }

    @GetMapping("/logiciels/{id}")
    public ResponseEntity<Logiciel> getById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path = "/logiciels", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Logiciel saveLogiciel(
            NewLogicielDTO newLogicielDTO
    ) {
        return logicielService.saveLogiciel(newLogicielDTO);
    }


    @DeleteMapping("/logiciels/{id}")
    public ResponseEntity<Void> deleteLogiciel(@PathVariable Long id) {
        try {
            logicielService.deleteLogiciel(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



}
