package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Garantie;
import web.exemple.gestiondeparc_informatique.repository.GarantieRepository;

import java.util.List;

@Service
@Transactional
public class GarantieService {
    @Autowired
    private GarantieRepository garantieRepository;

    public GarantieService(GarantieRepository garantieRepository) {
        this.garantieRepository = garantieRepository;
    }

    public Garantie saveGarantie(Garantie garantie) {
        return garantieRepository.save(garantie);
    }

    public void deleteGarantie(Long id) {
        Garantie garantie = garantieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garantie introuvable"));
        garantieRepository.delete(garantie);
    }

    public List<Garantie> getAll() {
        return garantieRepository.findAll();
    }

    public Garantie getById(Long id) {
        return garantieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garantie introuvable"));
    }
}
