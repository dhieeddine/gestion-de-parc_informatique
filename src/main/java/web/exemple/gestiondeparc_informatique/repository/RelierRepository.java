package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Relier;

public interface RelierRepository extends JpaRepository<Relier,Long> {
}
