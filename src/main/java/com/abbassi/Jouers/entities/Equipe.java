package com.abbassi.Jouers.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe", nullable = false)
    private Long idEquipe;
    private String nomEquipe;
    private String league;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    private List<Jouer> jouers ;

}
