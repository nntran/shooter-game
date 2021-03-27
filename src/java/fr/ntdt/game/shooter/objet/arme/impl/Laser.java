package fr.ntdt.game.shooter.objet.arme.impl;

import fr.ntdt.game.shooter.objet.arme.Arme;

/**
 * Arme laser
 */
public class Laser extends Arme {

    public Laser() {
        super("Laser");
    }

    @Override
    public Portee getPortee() {
        return Portee.LONG;
    }

    @Override
    public void tirer() {
        // TODO Auto-generated method stub

    }

}
