package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Peripherique;

public interface PeripheriqueRepository extends JpaRepository<Peripherique,Long> {
}
