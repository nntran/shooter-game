package fr.ntdt.game.shooter.objet;

import java.util.Objects;
import java.util.UUID;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 * Objet animé
 */
public abstract class ObjetAnime /* extends Panel */ {

    private UUID id;

    // Nom de l'objet
    private String nom;

    // Position de l'objet dans la scene
    protected Point pos;

    // Image de l'objet
    private Image image;

    // largeur et hauteur de l'image
    private int largeur;
    private int hauteur;

    /**
     * 
     * @param nom      Nom de l'objet
     * @param imageUri Chemin de l'image (ex: src/resources/monimage.png)
     */
    protected ObjetAnime(String nom, String imageUri) {
        id = UUID.randomUUID();
        this.nom = nom;
        pos = new Point(0, 0);

        // charger l'image
        ImageIcon imgIcon = new ImageIcon(imageUri);
        image = imgIcon.getImage();

        largeur = image.getWidth(null);
        hauteur = image.getHeight(null);
    }

    public UUID getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public Point getPos() {
        return this.pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public ObjetAnime pos(Point pos) {
        setPos(pos);
        return this;
    }

    /**
     * Deplacer l'objet vers une nouvelle position
     * 
     * @param dx
     * @param dy
     */
    public void deplacer(int dx, int dy) {
        int x = pos.getX();
        int y = pos.getY();
        pos.setX(x + dx);
        pos.setY(y + dy);
    }

    /**
     * Dessiner l'objet
     * 
     * @param g
     * @param observer
     */
    public void dessiner(Graphics g, ImageObserver observer) {

        // Afficher l'objet
        if (image != null)
            g.drawImage(image, pos.getX() - 25, pos.getY(), observer);
        else {
            g.setColor(Color.WHITE);
            g.fillOval(pos.getX(), pos.getY(), 10, 10);
        }

        // Afficher le nom de l'objet
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g.drawString(nom, pos.getX() - 40, pos.getY() + 70);
    }

    /**
     * Cette méthode est appelée si l'ojet est touchée par un autre objet
     * 
     * @param objet
     */
    public abstract void touche(ObjetAnime objet);

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ObjetAnime)) {
            return false;
        }
        ObjetAnime objetAnime = (ObjetAnime) o;
        return Objects.equals(id, objetAnime.id) && Objects.equals(nom, objetAnime.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return getNom() + " {" + " id='" + getId() + "'" + ", pos='" + getPos() + "'" + "}";
    }
}
