package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Ecran;
import web.exemple.gestiondeparc_informatique.repository.EcranRepository;

import java.util.List;

@Service
@Transactional
public class EcranService {
    @Autowired
    private EcranRepository ecranRepository;

    public EcranService(EcranRepository ecranRepository) {
        this.ecranRepository = ecranRepository;
    }

    public Ecran saveEcran(Ecran ecran) {
        return ecranRepository.save(ecran);
    }

    public void deleteEcran(Long id) {
        Ecran ecran = ecranRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Écran introuvable"));
        ecranRepository.delete(ecran);
    }

    public List<Ecran> getAll() {
        return ecranRepository.findAll();
    }

    public Ecran getById(Long id) {
        return ecranRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Écran introuvable"));
    }
}
