package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Emplacement;
import web.exemple.gestiondeparc_informatique.entities.Machine;
import web.exemple.gestiondeparc_informatique.repository.EmplacementRepository;
import web.exemple.gestiondeparc_informatique.repository.MachineRepository;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class EmplacementService {
    @Autowired
    private  EmplacementRepository emplacementRepository;
    private MachineRepository machineRepository;
    public EmplacementService(EmplacementRepository emplacementRepository, MachineRepository machineRepository) {
        this.emplacementRepository = emplacementRepository;
        this.machineRepository = machineRepository;
    }


    public Emplacement saveEmplacement(Emplacement emplacement)  throws IOException {
              return emplacementRepository.save(emplacement);
    }

    public void deleteEmplacement(Long id) {
        Emplacement emplacement = emplacementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emplacement introuvable"));

        List<Machine> machinesLiees = machineRepository.findAllByEmplacement(emplacement);

        machineRepository.deleteAll(machinesLiees);




        emplacementRepository.delete(emplacement);
    }

    public Emplacement getEmplacementById(Long numEmplacement) {
       return emplacementRepository.findByNumEmplacement(numEmplacement);
    }
}
