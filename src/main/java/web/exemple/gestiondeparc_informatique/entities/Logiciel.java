package web.exemple.gestiondeparc_informatique.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString @Builder
public class Logiciel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numL;
    private String nomL;
    private String typeL;
    private String licenceL;
    private String versionL;
    private String editeurL;
    private String numSerieL;
    private LocalDate dateL;
}
