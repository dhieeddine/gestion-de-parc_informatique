package web.exemple.gestiondeparc_informatique.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString @Builder
public class Ddur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numDD;
    private String capaciteDD;
    private String typeDD;
    private String etatDD;
}
