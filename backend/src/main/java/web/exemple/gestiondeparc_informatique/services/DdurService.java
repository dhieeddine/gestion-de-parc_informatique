package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Ddur;
import web.exemple.gestiondeparc_informatique.repository.DdurRepository;

import java.util.List;

@Service
@Transactional
public class DdurService {
    @Autowired
    private DdurRepository ddurRepository;

    public DdurService(DdurRepository ddurRepository) {
        this.ddurRepository = ddurRepository;
    }

    public Ddur saveDdur(Ddur ddur) {
        return ddurRepository.save(ddur);
    }

    public void deleteDdur(Long id) {
        Ddur ddur = ddurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disque dur introuvable"));
        ddurRepository.delete(ddur);
    }

    public List<Ddur> getAll() {
        return ddurRepository.findAll();
    }

    public Ddur getById(Long id) {
        return ddurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disque dur introuvable"));
    }
}
