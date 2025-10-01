package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Installer;
import web.exemple.gestiondeparc_informatique.entities.Logiciel;

import java.util.List;

public interface InstallerRepository extends JpaRepository<Installer,Long> {
    List<Installer> findAllByLogiciel(Logiciel logiciel);
}
