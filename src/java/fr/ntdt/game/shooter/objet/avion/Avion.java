package fr.ntdt.game.shooter.objet.avion;

import fr.ntdt.game.shooter.objet.Objet;
import fr.ntdt.game.shooter.objet.Point;
import fr.ntdt.game.shooter.objet.arme.Arme;
import fr.ntdt.game.shooter.objet.arme.Balle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Modélisation d'un avion (abstraction)
 */
public class Avion extends Objet {

    /**
     * Santé maximale
     */
    public static final float SANTE_MAX = 1.0f;

    // Santé courante
    private float sante = SANTE_MAX;

    // Resistance (pourcentage 1% par défaut)
    private float resistance = 0.01f;

    // Armes principale et secondaire
    protected Arme armePrincipale, armeSecondaire;

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
        return this.armePrincipale;
    }

    public void setArmePrincipale(Arme principale) {
        this.armePrincipale = principale;
        if (this.armePrincipale != null) {
            this.armePrincipale.setPos(new Point(pos.getX(), pos.getY()));
        }
    }

    public Avion armePrincipale(Arme principale) {
        setArmePrincipale(principale);
        return this;
    }

    public Arme getArmeSecondaire() {
        return this.armeSecondaire;
    }

    public void setArmeSecondaire(Arme secondaire) {
        this.armeSecondaire = secondaire;
        if (this.armeSecondaire != null) {
            this.armeSecondaire.setPos(new Point(pos.getX(), pos.getY()));
        }
    }

    public Avion armeSecondaire(Arme secondaire) {
        setArmeSecondaire(secondaire);
        return this;
    }

    @Override
    public void deplacer(int x, int y) {

        // Déplace l'avion
        super.deplacer(x, y);

        // Il faut mettre à jour la position de mes armes
        if (armePrincipale != null) {
            armePrincipale.deplacer(x, y);
        }

        if (armeSecondaire != null) {
            armeSecondaire.deplacer(x, y);
        }
    }

    @Override
    public void dessiner(Graphics g, ImageObserver observer) {

        // dessiner l'avion
        super.dessiner(g, observer);

        // afficher l'arme principale
        if (armePrincipale != null) {
            // g.setColor(Color.CYAN);
            // g.setFont(new Font("Monospaced", Font.PLAIN, 10));
            // g.drawString(principale.getNom(), pos.getX() - 40, pos.getY() + 90);
            armePrincipale.dessiner(g, observer);
        }

        // afficher l'arme secondaire
        if (armeSecondaire != null) {
            // g.setColor(Color.CYAN);
            // g.setFont(new Font("Monospaced", Font.PLAIN, 10));
            // g.drawString(principale.getNom(), pos.getX() - 40, pos.getY() + 90);
            armeSecondaire.dessiner(g, observer);
        }
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

    /**
     * Tire sur les objets ciblés
     * 
     * @param cibles Objets cibles
     * @return retourne les balles tirées
     */
    public List<Balle> tirer(List<Objet> cibles) {
        List<Balle> ballesTirees = new ArrayList<Balle>();
        if (armePrincipale != null) {
            Balle balles[] = armePrincipale.tirer(cibles);
            if (balles != null)
                ballesTirees.addAll(Arrays.asList(balles));
        }
        if (armeSecondaire != null) {
            Balle balles[] = armeSecondaire.tirer(cibles);
            if (balles != null) {
                ballesTirees.addAll(Arrays.asList(balles));
            }
        }
        return ballesTirees;
    }
}
