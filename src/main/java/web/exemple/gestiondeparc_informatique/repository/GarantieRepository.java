package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Garantie;

public interface GarantieRepository extends JpaRepository<Garantie,Long> {
    Garantie findByNumGarantie(Long  numGarantie);
}
