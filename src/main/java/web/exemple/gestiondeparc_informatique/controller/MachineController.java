package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.Machine;
import web.exemple.gestiondeparc_informatique.repository.MachineRepository;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequiredArgsConstructor
public class MachineController {

    private final MachineRepository machineRepository;
    @GetMapping(path="/machines")
    public List<Machine> findAll() {
        return machineRepository.findAll();
    }


    @GetMapping("/machines/{id}")
    public ResponseEntity<Machine> getById(@PathVariable Long id) {
        return machineRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}

