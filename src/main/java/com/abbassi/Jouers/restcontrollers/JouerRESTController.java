package com.abbassi.Jouers.restcontrollers;

import com.abbassi.Jouers.dto.JouerDTO;
import com.abbassi.Jouers.entities.Jouer;
import com.abbassi.Jouers.service.JouerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JouerRESTController {
    @Autowired
    JouerService jouerService;

    @RequestMapping(path = "all",method = RequestMethod.GET)
    public List<JouerDTO> getAllJouers(){
        return jouerService.getAllJouers();
    }

    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public JouerDTO getJouerById(@PathVariable("id") Long id) {
        return jouerService.getJouer(id);
    }


    @RequestMapping(value = "/addjouer",method = RequestMethod.POST)
    //@PostMapping("/addjouer")
    public JouerDTO createJouer(@RequestBody JouerDTO jouerDTO) {
        return jouerService.saveJouer(jouerDTO);
    }


    @RequestMapping(value = "/updatejouer",method = RequestMethod.PUT)
    //@PutMapping("/updatejouer")
    public JouerDTO updateJouer(@RequestBody JouerDTO jouerDTO) {
        return jouerService.updateJouer(jouerDTO);
    }


    @RequestMapping(value="/deljouer/{id}",method = RequestMethod.DELETE)
    public void deleteJouer(@PathVariable("id") Long id)
    {
        jouerService.deleteJouerById(id);
    }


    @RequestMapping(value="/jouerseq/{idEquipe}",method = RequestMethod.GET)
    public List<Jouer> getJouersByEquipeId(@PathVariable("idEquipe") Long idEquipe) {
        return jouerService.findByEquipeIdEquipe(idEquipe);
    }

    @RequestMapping(value="/jouers ByName/{nom}",method = RequestMethod.GET)
    public List<Jouer> findByNomJouerContains(@PathVariable("nom") String nom) {
        return jouerService.findByNomJouerContains(nom);
    }
}
