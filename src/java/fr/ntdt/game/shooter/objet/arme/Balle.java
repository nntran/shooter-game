package fr.ntdt.game.shooter.objet.arme;

import fr.ntdt.game.shooter.objet.Objet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class Balle extends Objet implements Runnable {

    private Thread animator;

    protected Balle(String nom, String image) {
        super(nom, image != null ? "src/ressources/" + image : null);

        animator = new Thread(this);
        animator.start();
    }

    /**
     * Retourne la vitese de déplacement de la balle (0 à 10)
     * 
     * @return
     */
    public abstract int getVitesse();

    @Override
    public void run() {
        int direction = -1;
        int vitesse = getVitesse();
        int dy = 10 * direction;
        while (pos.getY() > 0) {

            deplacer(pos.getX(), pos.getY() + dy);

            try {
                Thread.sleep(20 - vitesse);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void dessiner(Graphics g, ImageObserver observer) {

        super.dessiner(g, observer);

        // g.setColor(Color.YELLOW);
        // g.drawOval(pos.getX(), pos.getY(), 2, 2);
    }

    protected void finalize() {
        animator.interrupt();
        try {
            animator.join();
        } catch (InterruptedException e) {

        }
        animator = null;
        System.out.println("Balle : " + getNom() + " (" + getId() + ") detruite");
    }
}