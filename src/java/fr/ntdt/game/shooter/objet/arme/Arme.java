package fr.ntdt.game.shooter.objet.arme;

import fr.ntdt.game.shooter.objet.Objet;

/**
 * Modélisation des armes qui seront utilisées par les avions
 */
public abstract class Arme extends Objet {

    // Facteur de dégat de l'arme (0.01 à 0.5) à l'impact
    private float degat = (float) 0.01;

    /**
     * Dégat maximum
     */
    public static final float DEGAT_MAX = 0.5f;

    /**
     * Type de portée
     */
    public static enum Portee {
        COURT, MOYEN, LONG;
    }

    /**
     * Constructeur de création d'arme
     * 
     * @param nom
     * @param image
     */
    protected Arme(String nom, String image) {
        super(nom, image);
    }

    public float getDegat() {
        return this.degat;
    }

    public void setDegat(float degat) {

        if (degat < 0f)
            this.degat = 0f;
        else if (degat > DEGAT_MAX)
            this.degat = DEGAT_MAX;
        else
            this.degat = degat;
    }

    public Arme degat(float degat) {
        setDegat(degat);
        return this;
    }

    /**
     * Portée de l'arme à spécifier
     * 
     * @return rtourne la portée de l'arme
     */
    public abstract Portee getPortee();

    /**
     * Tirer
     */
    public abstract void tirer();

}
