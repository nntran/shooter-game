package fr.ntdt.game.shooter.objet.arme;

import fr.ntdt.game.shooter.objet.Objet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.List;

/**
 * Modélisation des armes qui seront utilisées par les avions
 */
public abstract class Arme extends Objet {

    /**
     * Dégat minimum
     */
    public static final float DEGAT_MIN = 0.1f;

    /**
     * Dégat maximum
     */
    public static final float DEGAT_MAX = 0.5f;

    /**
     * Puissance minimale de tir
     */
    public static final float PUISSANCE_MIN = 0.1f;

    /**
     * Puissance maximale de tir
     */
    public static final float PUISSANCE_MAX = 0.5f;

    // Facteur de dégat de l'arme (0.01 à 0.5) à l'impact
    private float degat = DEGAT_MIN;

    // Puissance de tir (0.01 à 0.5)
    private float puissance = PUISSANCE_MIN;

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
        if (degat < DEGAT_MIN)
            this.degat = DEGAT_MIN;
        else if (degat > DEGAT_MAX)
            this.degat = DEGAT_MAX;
        else
            this.degat = degat;
    }

    public Arme degat(float degat) {
        setDegat(degat);
        return this;
    }

    public float getPuissance() {
        return this.puissance;
    }

    public void setPuissance(float puissance) {
        if (puissance < PUISSANCE_MIN)
            this.puissance = PUISSANCE_MIN;
        else if (puissance > PUISSANCE_MAX)
            this.puissance = PUISSANCE_MAX;
        else
            this.puissance = puissance;
    }

    public Arme puissance(float puissance) {
        setPuissance(puissance);
        return this;
    }

    /**
     * Portée de l'arme à spécifier
     * 
     * @return rtourne la portée de l'arme
     */
    public abstract Portee getPortee();

    /**
     * Tirer sur les cibles spéciés
     * 
     * @param cibles Objets cibles
     * @return retourne les balles tirés
     */
    public abstract Balle[] tirer(Objet... cibles);

    @Override
    public void dessiner(Graphics g, ImageObserver observer) {

        // je ne veux pas affichier le nom de l'objet (comportement par défaut de la
        // classe mère "Objet")
        // super.dessiner(g, observer);

        // position de mon objet "arme"
        int x = pos.getX();
        int y = pos.getY();

        // je veux afficher l'image seulement
        if (image != null)
            g.drawImage(image, x, y, observer);
    }

}
