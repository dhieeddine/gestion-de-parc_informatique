package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Relier;

public interface InstallerRepository extends JpaRepository<Relier,Long> {
}
