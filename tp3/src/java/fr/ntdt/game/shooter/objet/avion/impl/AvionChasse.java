package fr.ntdt.game.shooter.objet.avion.impl;

import fr.ntdt.game.shooter.objet.avion.Avion;

/**
 * Modélisation d'un avion de chasse (abstraction)
 */
public class AvionChasse extends Avion {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param nom
     */
    public AvionChasse(String nom) {
        super(nom, null);
    }

}
