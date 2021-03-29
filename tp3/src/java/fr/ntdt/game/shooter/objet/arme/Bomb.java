package fr.ntdt.game.shooter.objet.arme;

/**
 * 
 */
public abstract class Bomb extends Arme {

    protected Bomb(String nom, String image) {
        super(nom, image);
    }

    @Override
    public Portee getPortee() {
        return Portee.COURT;
    }
}
