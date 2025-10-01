package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByNumU(Long  numU);
}
