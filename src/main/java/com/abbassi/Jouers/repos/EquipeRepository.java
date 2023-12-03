package com.abbassi.Jouers.repos;

import com.abbassi.Jouers.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "equipe")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
