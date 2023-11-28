package com.abbassi.Jouers.service;

import com.abbassi.Jouers.dto.JouerDTO;
import com.abbassi.Jouers.entities.Equipe;
import com.abbassi.Jouers.entities.Jouer;
import com.abbassi.Jouers.repos.JouerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JouerServiceImpl implements JouerService {

    @Autowired
    JouerRepository jouerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public JouerDTO saveJouer(JouerDTO j) {
        return convertEntityToDto(jouerRepository.save(convertDtoToEntity(j)));
    }

    @Override
    public JouerDTO updateJouer(JouerDTO j) {
        return convertEntityToDto(jouerRepository.save(convertDtoToEntity(j)));
    }

    @Override
    public void deleteJouer(Jouer j) {
        jouerRepository.delete(j);
    }

    @Override
    public void deleteJouerById(Long id) {
        jouerRepository.deleteById(id);
    }

    @Override
    public JouerDTO getJouer(Long id) {
        return convertEntityToDto(jouerRepository.findById(id).get());
    }

    @Override
    public List<JouerDTO> getAllJouers() {
        return jouerRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Jouer> findByNomJouer(String nom) {
        return jouerRepository.findByNomJouer(nom);
    }

    @Override
    public List<Jouer> findByNomJouerContains(String nom) {
        return jouerRepository.findByNomJouerContains(nom);
    }

//    @Override
//    public List<Jouer> findByNomPrix(String nom, Double prix) {
//        return null;
//    }

    @Override
    public List<Jouer> findByEquipe(Equipe equipe) {
        return jouerRepository.findByEquipe(equipe);
    }

    @Override
    public List<Jouer> findByEquipeIdEquipe(Long id) {
        return jouerRepository.findByEquipeIdEquipe(id);
    }

    @Override
    public List<Jouer> findByOrderByNomJouerAsc() {
        return jouerRepository.findByOrderByNomJouerAsc();
    }

    @Override
    public List<Jouer> trierJouersNomsPrix() {
        return jouerRepository.trierJouersNomsPrix();
    }

    @Override
    public JouerDTO convertEntityToDto(Jouer jouer) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        JouerDTO jouerDTO = modelMapper.map(jouer, JouerDTO.class);
        return jouerDTO;
//        JouerDTO jouerDTO = new JouerDTO();
//        jouerDTO.setIdJouer(j.getIdJouer());
//        jouerDTO.setNomJouer(j.getNomJouer());
//        jouerDTO.setPrixJouer(j.getPrixJouer());
//        jouerDTO.setEquipe(j.getEquipe());
//        return jouerDTO;


//        return JouerDTO.builder()
//                .idJouer(j.getIdJouer())
//                .nomJouer(j.getNomJouer())
//                //.prixJouer(j.getPrixJouer())
//                .dateContrat(j.getDateContrat())
//                .equipe(j.getEquipe())
//                //.league(j.getEquipe().getLeague())
//                .build();
    }

    @Override
    public Jouer convertDtoToEntity(JouerDTO jouerDTO) {

        Jouer jouer = new Jouer();
        jouer = modelMapper.map(jouerDTO, Jouer.class);
        return jouer;
//        Jouer jouer = new Jouer();
//
//        jouer.setIdJouer(jouerDTO.getIdJouer());
//        jouer.setNomJouer(jouerDTO.getNomJouer());
//        jouer.setPrixJouer(jouerDTO.getPrixJouer());
//        jouer.setDateContrat(jouerDTO.getDateContrat());
//        jouer.setEquipe(jouerDTO.getEquipe());
//
//        return jouer;
    }
}
