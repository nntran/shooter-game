package fr.ntdt.game.shooter.objet.arme.impl;

import fr.ntdt.game.shooter.objet.ObjetAnime;
import fr.ntdt.game.shooter.objet.arme.Arme;

public class Bombe extends Arme {

    protected Bombe() {
        super("Bombe");
    }

    @Override
    public Portee getPortee() {
        return Portee.COURT;
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
