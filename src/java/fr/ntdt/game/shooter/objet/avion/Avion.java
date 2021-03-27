package fr.ntdt.game.shooter.objet.avion;

import fr.ntdt.game.shooter.objet.ObjetAnime;
import fr.ntdt.game.shooter.objet.arme.Arme;

/**
 * Modélisation d'un avion (abstraction)
 */
public abstract class Avion extends ObjetAnime {

    // Vitesse de vol (0 à 1)
    private float vitesse = 0.1f;

    /**
     * Santé maximale
     */
    public final float SANTE_MAX = 1.0f;

    // Santé courante
    private float sante = SANTE_MAX;

    // Resistence
    private float resistance = 0.5f;

    // Armes principale et secondaire
    private Arme principale, secondaire;

    // Nombre de bombs max
    public static int NB_BOMBS_MAX = 5;

    /**
     * Constructeur pour créer un avion
     * 
     * @param nom
     * @param vitesse
     */
    protected Avion(String nom, float vitesse) {
        super(nom, "src/ressources/avion-60p.png");
        this.vitesse = vitesse;
    }

    public float getVitesse() {
        return this.vitesse;
    }

    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }

    public Avion vitesse(float vitesse) {
        setVitesse(vitesse);
        return this;
    }

    public float getSante() {
        return this.sante;
    }

    public void setSante(float sante) {
        if (sante < 0f)
            this.sante = 0;
        else if (sante > SANTE_MAX)
            this.sante = SANTE_MAX;
        else
            this.sante = sante;
    }

    public Avion sante(float sante) {
        setSante(sante);
        return this;
    }

    public float getResistance() {
        return this.resistance;
    }

    public void setResistance(float resistance) {
        if (resistance < 0f)
            this.resistance = 0f;
        else if (resistance > 1.0f)
            this.sante = 1.0f;
        else
            this.resistance = resistance;
    }

    public Avion resistance(float resistance) {
        setResistance(resistance);
        return this;
    }

    /**
     * Action voler
     */
    public abstract void tirer();

    /**
     * Touché par une arme d'un ennemi
     * 
     * @param ennemi
     * @param arme
     */
    public void touche(Avion ennemi, Arme arme) {

    }
}
