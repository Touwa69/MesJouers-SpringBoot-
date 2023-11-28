package com.abbassi.Jouers.dto;

import com.abbassi.Jouers.entities.Equipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JouerDTO {

    private Long idJouer;
    private  String nomJouer;
    private Double prixJouer;
    private Date dateContrat;
    private Equipe equipe;
    private String league;
}
