package web.exemple.gestiondeparc_informatique.dtos;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor @Getter
@Setter @ToString @Builder
public class MachineForm {
    private String typeMachine;
    private LocalDate dateAchat; // Ou LocalDate avec convertisseur
    private String processeur;
    private String stockage;
    private String ram;
    private String adrIP;
    private Long numF;
    private Long numMarque;
    private Long numEcran;
    private Long numGarantie;
    private Long numCarteVideo;
    private Long numDD;
    private Long numEmplacement;

    // getters et setters
}
