package web.exemple.gestiondeparc_informatique.dtos;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor @AllArgsConstructor @Getter
@Setter @ToString @Builder
public class NewLogicielDTO {
    private String nomL;
    private String typeL;
    private String licenceL;
    private String versionL;
    private String editeurL;
    private String numSerieL;
    private LocalDate dateL;

}
