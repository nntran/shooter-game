package fr.ntdt.game.shooter.objet.avion.impl;

import fr.ntdt.game.shooter.objet.avion.Avion;

/**
 * Conçus pour détruire des cibles au sol (ou en mer) de manière massive, les
 * bombardiers sont équipés de bombes (atomiques ou non) ou/et de missiles de
 * croisière air/sol
 */
public abstract class Bombardier extends Avion {

    protected Bombardier(String nom, float vitesse) {
        super(nom, vitesse);
    }

}
