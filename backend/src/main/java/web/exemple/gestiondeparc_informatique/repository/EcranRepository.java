package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Ecran;
import web.exemple.gestiondeparc_informatique.entities.Fournisseur;

import java.util.List;

public interface EcranRepository extends JpaRepository<Ecran,Long> {
    Ecran findByNumEcran(Long  numEcran);
    List<Ecran> findAllByFournisseur(Fournisseur  fournisseur);

}
