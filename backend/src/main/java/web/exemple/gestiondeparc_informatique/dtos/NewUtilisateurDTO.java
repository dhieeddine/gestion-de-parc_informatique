package web.exemple.gestiondeparc_informatique.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NewUtilisateurDTO {
    private String nomU;
    private String prenomU;
    private String password;
    private String droitU;

}
