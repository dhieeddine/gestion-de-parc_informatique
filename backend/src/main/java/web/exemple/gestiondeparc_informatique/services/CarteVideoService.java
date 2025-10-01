package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.CarteVideo;
import web.exemple.gestiondeparc_informatique.repository.CarteVideoRepository;

import java.util.List;

@Service
@Transactional
public class CarteVideoService {
    @Autowired
    private CarteVideoRepository carteVideoRepository;

    public CarteVideoService(CarteVideoRepository carteVideoRepository) {
        this.carteVideoRepository = carteVideoRepository;
    }

    public CarteVideo saveCarteVideo(CarteVideo carteVideo) {
        return carteVideoRepository.save(carteVideo);
    }

    public void deleteCarteVideo(Long id) {
        CarteVideo carteVideo = carteVideoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte vidéo introuvable"));
        carteVideoRepository.delete(carteVideo);
    }

    public List<CarteVideo> getAll() {
        return carteVideoRepository.findAll();
    }

    public CarteVideo getById(Long id) {
        return carteVideoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte vidéo introuvable"));
    }
}
