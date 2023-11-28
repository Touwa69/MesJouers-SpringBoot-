package com.abbassi.Jouers.repos;

import com.abbassi.Jouers.entities.Equipe;
import com.abbassi.Jouers.entities.Jouer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;  

@RepositoryRestResource(path = "rest")
public interface JouerRepository extends JpaRepository<Jouer, Long> {

    List<Jouer> findByNomJouer(String nom);
    List<Jouer> findByNomJouerContains(String nom);

    /* @Query("select j from Jouer j where j.nomJouer like %?1 and j.prixJouer > ?2")*/
    //List<Jouer> findByNomPrix (String nom, Double prix);

//    @Query("select j from Jouer j where j.nomJouer like %:nom and p.prixJouer > :prix")
//    List<Jouer> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    @Query("select j from Jouer j where j.equipe = ?1")
    List<Jouer> findByEquipe (Equipe equipe);

    List<Jouer> findByEquipeIdEquipe(Long id);

    List<Jouer> findByOrderByNomJouerAsc();

    @Query("select j from Jouer j order by j.nomJouer ASC, j.prixJouer DESC")
    List<Jouer> trierJouersNomsPrix ();
}
