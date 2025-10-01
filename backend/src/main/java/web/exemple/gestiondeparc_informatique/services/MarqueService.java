package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Marque;
import web.exemple.gestiondeparc_informatique.repository.MarqueRepository;

import java.util.List;

@Service
@Transactional
public class MarqueService {
    @Autowired
    private MarqueRepository marqueRepository;

    public MarqueService(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public Marque saveMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public void deleteMarque(Long id) {
        Marque marque = marqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marque introuvable"));
        marqueRepository.delete(marque);
    }

    public List<Marque> getAll() {
        return marqueRepository.findAll();
    }

    public Marque getById(Long id) {
        return marqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marque introuvable"));
    }
}
