package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Logiciel;

public interface LogicielRepository extends JpaRepository<Logiciel,Long> {
    Logiciel findByNumL(Long numL);
}
