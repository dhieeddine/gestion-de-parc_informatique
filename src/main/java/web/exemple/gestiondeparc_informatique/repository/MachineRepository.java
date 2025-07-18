package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Machine;

public interface MachineRepository extends JpaRepository<Machine,Long> {
    Machine findByNumMachine(Long numMachine);

}
