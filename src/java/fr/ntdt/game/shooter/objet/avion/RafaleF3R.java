package fr.ntdt.game.shooter.objet.avion;

import fr.ntdt.game.shooter.objet.arme.BlasterAlphaX3;
import fr.ntdt.game.shooter.objet.arme.LanceMissiles;

/**
 * Implémentation d'un avion de chasse de type Rafale F3-R
 */
public class RafaleF3R extends Avion {

    public RafaleF3R() {
        super("Rafale F3-R", "avion.png");

        setArmePrincipale(new LanceMissiles());
        setArmeSecondaire(new BlasterAlphaX3());
    }

}
