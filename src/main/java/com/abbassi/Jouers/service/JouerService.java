package com.abbassi.Jouers.service;

import com.abbassi.Jouers.dto.JouerDTO;
import com.abbassi.Jouers.entities.Equipe;
import com.abbassi.Jouers.entities.Jouer;

import java.util.List;

public interface JouerService {
    JouerDTO saveJouer(JouerDTO j);
    JouerDTO updateJouer(JouerDTO j);


    JouerDTO getJouer(Long id);
    List<JouerDTO> getAllJouers();


    void deleteJouer(Jouer j);
    void deleteJouerById(Long id);

    List<Jouer> findByNomJouer(String nom);
    List<Jouer> findByNomJouerContains(String nom);
    //List<Jouer> findByNomPrix (String nom, Double prix);
    List<Jouer> findByEquipe (Equipe equipe);
    List<Jouer> findByEquipeIdEquipe(Long id);
    List<Jouer> findByOrderByNomJouerAsc();
    List<Jouer> trierJouersNomsPrix ();

    JouerDTO convertEntityToDto(Jouer j);
    Jouer convertDtoToEntity(JouerDTO jouerDTO);
}
