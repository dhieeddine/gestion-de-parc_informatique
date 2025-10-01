package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
    Marque findByNumMarque(Long numMarque);
}
