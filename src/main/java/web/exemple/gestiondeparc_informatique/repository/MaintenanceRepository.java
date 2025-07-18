package web.exemple.gestiondeparc_informatique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.exemple.gestiondeparc_informatique.entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
}
