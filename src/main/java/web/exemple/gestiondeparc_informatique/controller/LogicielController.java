package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Logiciel;
import web.exemple.gestiondeparc_informatique.repository.LogicielRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")

public class LogicielController {
    private final LogicielRepository repository;

    @GetMapping(path= "/logiciels")
    public List<Logiciel> getAll() { return repository.findAll(); }

    @GetMapping("/logiciels/{id}")
    public ResponseEntity<Logiciel> getById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
