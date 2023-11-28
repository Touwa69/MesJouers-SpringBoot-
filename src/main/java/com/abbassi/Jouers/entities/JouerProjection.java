package com.abbassi.Jouers.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomJouer", types = {Jouer.class})
public interface JouerProjection {
    public String getNomJouer();
}
