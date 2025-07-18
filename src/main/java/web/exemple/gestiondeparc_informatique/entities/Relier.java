package web.exemple.gestiondeparc_informatique.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString @Builder
public class Relier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="numMachine")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name="numPeripherique")
    private Peripherique peripherique;
}
