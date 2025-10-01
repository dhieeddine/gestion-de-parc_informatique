package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.dtos.MachineForm;
import web.exemple.gestiondeparc_informatique.entities.Machine;
import web.exemple.gestiondeparc_informatique.repository.*;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequiredArgsConstructor
public class MachineController {

    private final MachineRepository machineRepository;
    private final EcranRepository ecranRepository;
    private final MarqueRepository marqueRepository;
    private final FournisseurRepository fournisseurRepository;
    private final GarantieRepository garantieRepository;
    private final CarteVideoRepository carteVideoRepository;
    private final DdurRepository ddurRepository;
    private final EmplacementRepository emplacementRepository;

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

    @PostMapping("/machines")
    public ResponseEntity<?> saveMachine(@ModelAttribute MachineForm form) {
        Machine machine = Machine.builder()
                .typeMachine(form.getTypeMachine())
                .dateAchat(form.getDateAchat())
                .processeur(form.getProcesseur())
                .stockage(form.getStockage())
                .ram(form.getRam())
                .adrIP(form.getAdrIP())
                .fournisseur(fournisseurRepository.findById(form.getNumF()).orElse(null))
                .marque(marqueRepository.findById(form.getNumMarque()).orElse(null))
                .ecran(ecranRepository.findById(form.getNumEcran()).orElse(null))
                .garantie(garantieRepository.findById(form.getNumGarantie()).orElse(null))
                .carteVideo(carteVideoRepository.findById(form.getNumCarteVideo()).orElse(null))
                .disqueDur(ddurRepository.findById(form.getNumDD()).orElse(null))
                .emplacement(emplacementRepository.findById(form.getNumEmplacement()).orElse(null))
                .build();

        machineRepository.save(machine);
        return ResponseEntity.ok("✅ Machine enregistrée !");
    }





    @DeleteMapping("/machines/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        if (machineRepository.existsById(id)) {
            machineRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }



}

