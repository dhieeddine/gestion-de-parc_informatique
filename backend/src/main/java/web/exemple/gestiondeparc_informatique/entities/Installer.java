package web.exemple.gestiondeparc_informatique.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString @Builder
public class Installer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="numMachine")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name="numLogiciel")
    private Logiciel logiciel;
}
