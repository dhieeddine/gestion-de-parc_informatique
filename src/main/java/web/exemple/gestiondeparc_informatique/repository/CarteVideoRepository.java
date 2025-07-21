package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.CarteVideo;

public interface CarteVideoRepository extends JpaRepository<CarteVideo,Long> {

    CarteVideo findByNumCarteVideo(Long numCarteVideo);
}
