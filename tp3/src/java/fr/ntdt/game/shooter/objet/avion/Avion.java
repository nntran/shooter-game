package fr.ntdt.game.shooter.objet.avion;

import fr.ntdt.game.shooter.objet.Objet;
import fr.ntdt.game.shooter.objet.arme.Arme;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * Modélisation d'un avion (abstraction)
 */
public class Avion extends Objet {

    // Vitesse de vol (1 à 10)
    private int vitesse = 1;

    /**
     * Santé maximale
     */
    public static final float SANTE_MAX = 1.0f;

    // Santé courante
    private float sante = SANTE_MAX;

    // Resistance (pourcentage 1% par défaut)
    private float resistance = 0.01f;

    // Armes principale et secondaire
    protected Arme principale, secondaire;

    // Nombre de bombs max
    public static int NB_BOMBS_MAX = 4;

    /**
     * Constructeur pour créer un avion
     * 
     * @param nom
     * @param image
     */
    public Avion(String nom, String image) {
        super(nom, image != null ? "src/ressources/" + image : null);
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
            this.sante = 0f;
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

    public Arme getArmePrincipale() {
        return this.principale;
    }

    public void setArmePrincipale(Arme principale) {
        this.principale = principale;
    }

    public Avion principale(Arme principale) {
        setArmePrincipale(principale);
        return this;
    }

    public Arme getArmeSecondaire() {
        return this.secondaire;
    }

    public void setArmeSecondaire(Arme secondaire) {
        this.secondaire = secondaire;
    }

    public Avion secondaire(Arme secondaire) {
        setArmeSecondaire(secondaire);
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

    public void dessiner(Graphics g, ImageObserver observer) {

        super.dessiner(g, observer);

        // Afficher le nom de l'objet
        g.setColor(Color.CYAN);
        g.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g.drawString(principale.getNom(), pos.getX() - 40, pos.getY() + 90);
    }

    @Override
    public void touche(Objet objet) {
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
