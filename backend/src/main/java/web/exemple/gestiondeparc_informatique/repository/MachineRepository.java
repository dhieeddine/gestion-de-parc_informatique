package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.exemple.gestiondeparc_informatique.entities.Emplacement;
import web.exemple.gestiondeparc_informatique.entities.Fournisseur;
import web.exemple.gestiondeparc_informatique.entities.Machine;

import java.util.List;
@Repository
public interface MachineRepository extends JpaRepository<Machine,Long> {
    Machine findByNumMachine(Long numMachine);


    List<Machine> findAllByFournisseur(Fournisseur fournisseur);

    List<Machine> findAllByEmplacement(Emplacement emplacement);
}
