package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Utilise;

public interface UtiliseRepository extends JpaRepository<Utilise,Long> {
}
