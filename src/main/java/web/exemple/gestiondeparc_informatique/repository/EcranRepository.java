package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Ecran;

public interface EcranRepository extends JpaRepository<Ecran,Long> {
    Ecran findByNumEcran(Long  numEcran);

}
