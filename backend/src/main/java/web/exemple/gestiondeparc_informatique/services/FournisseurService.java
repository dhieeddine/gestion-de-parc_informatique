package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Ecran;
import web.exemple.gestiondeparc_informatique.entities.Fournisseur;
import web.exemple.gestiondeparc_informatique.entities.Machine;
import web.exemple.gestiondeparc_informatique.repository.EcranRepository;
import web.exemple.gestiondeparc_informatique.repository.FournisseurRepository;
import web.exemple.gestiondeparc_informatique.repository.MachineRepository;

import java.util.List;

@Service
@Transactional
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;
    private final MachineRepository machineRepository;
    private final EcranRepository ecranRepository;

    @Autowired
    public FournisseurService(FournisseurRepository fournisseurRepository,
                              MachineRepository machineRepository, EcranRepository ecranRepository) {
        this.fournisseurRepository = fournisseurRepository;
        this.machineRepository = machineRepository;
        this.ecranRepository = ecranRepository;
    }

    public Fournisseur saveFournisseur(Fournisseur fournisseur)  {
        return fournisseurRepository.save(fournisseur);
    }

    public void deleteFournisseur(Long id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur introuvable"));

        List<Machine> machinesLiees = machineRepository.findAllByFournisseur(fournisseur);

        machineRepository.deleteAll(machinesLiees);
        List<Ecran> ecranList = ecranRepository.findAllByFournisseur(fournisseur);

        ecranRepository.deleteAll(ecranList);



        // Supprimer le fournisseur
        fournisseurRepository.delete(fournisseur);
    }
}
