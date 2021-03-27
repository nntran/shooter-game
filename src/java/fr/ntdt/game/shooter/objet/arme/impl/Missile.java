package fr.ntdt.game.shooter.objet.arme.impl;

import fr.ntdt.game.shooter.objet.ObjetAnime;
import fr.ntdt.game.shooter.objet.arme.Arme;

/**
 * Modélisation arme de type missile
 */
public class Missile extends Arme {

    protected Missile(String nom) {
        super(nom);
    }

    @Override
    public Portee getPortee() {
        return Portee.LONG;
    }

    @Override
    public void tirer() {
        // TODO Auto-generated method stub

    }

    @Override
    public void touche(ObjetAnime objet) {
        // TODO Auto-generated method stub

    }

}
