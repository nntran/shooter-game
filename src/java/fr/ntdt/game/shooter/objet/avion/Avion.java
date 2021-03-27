package fr.ntdt.game.shooter.objet.avion;

import javax.lang.model.util.ElementScanner6;

import fr.ntdt.game.shooter.objet.ObjetAnime;
import fr.ntdt.game.shooter.objet.arme.Arme;

/**
 * Modélisation d'un avion (abstraction)
 */
public abstract class Avion extends ObjetAnime {

    // Vitesse de vol (1 à 10)
    private int vitesse = 1;

    /**
     * Santé maximale
     */
    public final float SANTE_MAX = 1.0f;

    // Santé courante
    private float sante = SANTE_MAX;

    // Resistence (pourcentage)
    private float resistance = 0.01f;

    // Armes principale et secondaire
    private Arme principale, secondaire;

    // Nombre de bombs max
    public static int NB_BOMBS_MAX = 5;

    /**
     * Constructeur pour créer un avion
     * 
     * @param nom
     * @param image
     */
    public Avion(String nom, String image) {
        super(nom, image != null ? image : "src/ressources/avion-60p.png");
    }

    public int getVitesse() {
        return this.vitesse;
    }

    public void setVitesse(int vitesse) {
        if (vitesse < 1)
            this.vitesse = 1;
        else if (vitesse > 10)
            this.vitesse = 10;
        else
            this.vitesse = vitesse;
    }

    public Avion vitesse(int vitesse) {
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

    @Override
    public void deplacer(int dx, int dy) {

        // Prendre en compte la vitesse de l'avion
        if (dx > 0)
            dx = dx * vitesse;
        if (dy > 0)
            dy = dy * vitesse;

        super.deplacer(dx, dy);
    }

    @Override
    public void touche(ObjetAnime objet) {
        // implémenter un effet d'impact / collision en fonction de l'objet touché
        // (arme, avion, ...)

        if (objet instanceof Arme) {
            Arme arme = (Arme) objet;
            float degat = arme.getDegat();
            degat -= (degat * resistance);

            sante -= degat;

        } else {
            sante -= 0.01;
        }

        if (sante < 0)
            sante = 0;
    }
}
