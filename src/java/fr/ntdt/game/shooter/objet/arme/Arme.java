package fr.ntdt.game.shooter.objet.arme;

import java.util.Objects;

import fr.ntdt.game.shooter.objet.ObjetAnime;

/**
 * Modélisation des armes qui seront utilisées par les avions
 */
public abstract class Arme extends ObjetAnime {

    // Facteur de dégat de l'arme (0.01) à l'impact
    private float degat = (float) 0.01;

    // Type de portée
    public static enum Portee {
        COURT, MOYEN, LONG;
    }

    /**
     * Constructeur de création d'arme
     * 
     * @param nom
     */
    protected Arme(String nom) {
        super(nom, "");
    }

    public float getDegat() {
        return this.degat;
    }

    public void setDegat(float degat) {
        this.degat = degat;
    }

    public Arme degat(float degat) {
        setDegat(degat);
        return this;
    }

    /**
     * Portée de l'arme à spécifier
     * 
     * @return
     */
    public abstract Portee getPortee();

    /**
     * Tirer
     */
    public abstract void tirer();

}
