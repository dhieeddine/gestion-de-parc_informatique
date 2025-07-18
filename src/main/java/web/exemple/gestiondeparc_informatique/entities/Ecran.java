package web.exemple.gestiondeparc_informatique.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString @Builder
public class Ecran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numEcran;

    @ManyToOne
    @JoinColumn(name="numMarque")
    private Marque marque;

    private String tailleEcran;

    @ManyToOne
    @JoinColumn(name="numGarantie")
    private Garantie garantie;

    @ManyToOne
    @JoinColumn(name="numFournisseur")
    private Fournisseur fournisseur;
}
