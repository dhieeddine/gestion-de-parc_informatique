package web.exemple.gestiondeparc_informatique.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter
@Setter @ToString @Builder
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMachine;

    @ManyToOne @JoinColumn(name="numEcran")
    private Ecran ecran;

    @ManyToOne @JoinColumn(name="numMarque")
    private Marque marque;

    @ManyToOne @JoinColumn(name="numF")
    private Fournisseur fournisseur;

    @ManyToOne @JoinColumn(name="numGarantie")
    private Garantie garantie;

    @ManyToOne @JoinColumn(name="numCarteVideo")
    private CarteVideo carteVideo;

    @ManyToOne @JoinColumn(name="numDD")
    private Ddur disqueDur;

    @ManyToOne @JoinColumn(name="numEmplacement")
    private Emplacement emplacement;

    private String typeMachine;
    private LocalDate dateAchat;
    private String processeur;
    private String stockage;
    private String ram;
    private String adrIP;
}
