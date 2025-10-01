package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Utilisateur;
import web.exemple.gestiondeparc_informatique.entities.Utilise;

import java.util.List;

public interface UtiliseRepository extends JpaRepository<Utilise,Long> {
    List<Utilise> findAllByUtilisateur(Utilisateur utilisateur);
}
