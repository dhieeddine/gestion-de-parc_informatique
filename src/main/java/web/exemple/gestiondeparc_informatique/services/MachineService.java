package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Machine;
import web.exemple.gestiondeparc_informatique.repository.MachineRepository;


@Service
@Transactional
public class MachineService {
    private final MachineRepository machineRepository;
    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }
    public Machine saveMachine(Machine machine){
       return machineRepository.save(machine);
    }
    public void deleteMachine(Long id) {
        Machine machine = machineRepository.findByNumMachine(id);




        machineRepository.delete(machine);
    }
}
