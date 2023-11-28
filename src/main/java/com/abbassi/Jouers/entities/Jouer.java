package com.abbassi.Jouers.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Jouer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jouer", nullable = false)
    private Long idJouer;

    private  String nomJouer;
    private Double prixJouer;
    private Date dateContrat;

    @ManyToOne
    private Equipe equipe;



    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Jouer() {
        super();
    }

    public Jouer(String nomJouer, Double prixJouer, Date dateContrat) {
        super();
        this.nomJouer = nomJouer;
        this.prixJouer = prixJouer;
        this.dateContrat = dateContrat;
    }

    public Long getIdJouer() {
        return idJouer;
    }

    public void setIdJouer(Long idJouer) {
        this.idJouer = idJouer;
    }
    public String getNomJouer() {
        return nomJouer;
    }

    public void setNomJouer(String nomJouer) {
        this.nomJouer = nomJouer;
    }

    public Double getPrixJouer() {
        return prixJouer;
    }

    public void setPrixJouer(Double prixJouer) {
        this.prixJouer = prixJouer;
    }

    public Date getDateContrat() {
        return dateContrat;
    }

    public void setDateContrat(Date dateContrat) {
        this.dateContrat = dateContrat;
    }


    @Override
    public String toString() {
        return "Jouer{" +
                "idJouer=" + idJouer +
                ", nomJouer='" + nomJouer + '\'' +
                ", prixJouer=" + prixJouer +
                ", dateContrat=" + dateContrat +
                '}';
    }
}
