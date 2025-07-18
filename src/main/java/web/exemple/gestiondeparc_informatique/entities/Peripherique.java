package web.exemple.gestiondeparc_informatique.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString @Builder
public class Peripherique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMateriel;

    @ManyToOne
    @JoinColumn(name="numF")
    private Fournisseur fournisseur;

    private String nomMateriel;
    private String typeP;

    @ManyToOne
    @JoinColumn(name="numGarantie")
    private Garantie garantie;

    private String etatMateriel;
    private String adrIPMateriel;
}
