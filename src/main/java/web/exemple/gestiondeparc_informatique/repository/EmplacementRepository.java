package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Emplacement;

public interface EmplacementRepository extends JpaRepository<Emplacement,Long> {
    Emplacement findByNumEmplacement(Long numEmplacement);
}
