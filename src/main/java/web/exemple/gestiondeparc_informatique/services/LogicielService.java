package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.dtos.NewLogicielDTO;
import web.exemple.gestiondeparc_informatique.entities.Installer;
import web.exemple.gestiondeparc_informatique.entities.Logiciel;
import web.exemple.gestiondeparc_informatique.repository.InstallerRepository;
import web.exemple.gestiondeparc_informatique.repository.LogicielRepository;

import java.util.List;

@Service
@Transactional
public class LogicielService {
    private final LogicielRepository logicielRepository;
    private final InstallerRepository installerRepository;

    @Autowired
    public LogicielService(LogicielRepository logicielRepository, InstallerRepository installerRepository){
        this.logicielRepository = logicielRepository;
        this.installerRepository = installerRepository;
    }

    public Logiciel saveLogiciel(NewLogicielDTO newLogicielDTO)  {
        Logiciel logiciel = Logiciel.builder()
                .nomL(newLogicielDTO.getNomL())
                .typeL(newLogicielDTO.getTypeL())
                .licenceL(newLogicielDTO.getLicenceL())
                .versionL(newLogicielDTO.getVersionL())
                .dateL(newLogicielDTO.getDateL())
                .numSerieL(newLogicielDTO.getNumSerieL())
                .editeurL(newLogicielDTO.getEditeurL())
                .build();
              return logicielRepository.save(logiciel);
    }

    public void deleteLogiciel(Long id) {
        Logiciel logiciel = logicielRepository.findById(id).orElseThrow(() -> new RuntimeException("Logiciel introuvable"));

        List<Installer> installerList = installerRepository.findAllByLogiciel(logiciel);

       installerRepository.deleteAll(installerList);

        // Supprimer le fournisseur
        logicielRepository.delete(logiciel);
    }
}
