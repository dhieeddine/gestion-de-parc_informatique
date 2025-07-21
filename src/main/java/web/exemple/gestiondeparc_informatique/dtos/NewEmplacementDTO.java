package web.exemple.gestiondeparc_informatique.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter
@Setter
public class NewEmplacementDTO {
    private String nomEmplacement;
    private String service;
}
