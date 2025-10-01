package web.exemple.gestiondeparc_informatique.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.exemple.gestiondeparc_informatique.entities.Utilisateur;
import web.exemple.gestiondeparc_informatique.entities.Utilise;
import web.exemple.gestiondeparc_informatique.repository.UtilisateurRepository;
import web.exemple.gestiondeparc_informatique.repository.UtiliseRepository;

import java.util.List;
@Service
@Transactional
public class UtilisateurService {
    private final UtilisateurRepository  utilisateurRepository;
    private final UtiliseRepository utiliseRepository;
    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtiliseRepository utiliseRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.utiliseRepository = utiliseRepository;
    }
    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    public void deleteUtilisateur(Long id){
        Utilisateur utilisateur= utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Logiciel introuvable"));
        List<Utilise> utiliseList = utiliseRepository.findAllByUtilisateur(utilisateur);
        utiliseRepository.deleteAll(utiliseList);

        utilisateurRepository.delete(utilisateur);
    }
}
