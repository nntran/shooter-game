package fr.ntdt.game.shooter.objet.arme;

public abstract class Laser extends Arme {

    protected Laser(String nom, String image) {
        super(nom, image);
    }

    @Override
    public Portee getPortee() {
        return Portee.LONG;
    }

}
