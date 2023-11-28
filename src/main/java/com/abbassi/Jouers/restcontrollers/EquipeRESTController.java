package com.abbassi.Jouers.restcontrollers;

import com.abbassi.Jouers.entities.Equipe;
import com.abbassi.Jouers.repos.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
@CrossOrigin("*")
public class EquipeRESTController {

    @Autowired
    EquipeRepository equipeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Equipe> getAllEquipes()
    {
        return equipeRepository.findAll();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Equipe getEquipeById(@PathVariable("id") Long id) {
        return equipeRepository.findById(id).get();
    }
}
