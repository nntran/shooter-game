package fr.ntdt.game.shooter.objet.arme;

import fr.ntdt.game.shooter.objet.Objet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class Balle extends Objet implements Runnable {

    private Thread animator;

    protected Balle(String nom, String imageUri) {
        super(nom, imageUri);

        animator = new Thread(this);
        animator.start();
    }

    /**
     * Retourne la vitese de déplacement de la balle (0 à 100)
     * 
     * @return
     */
    public abstract int getVitesse();

    @Override
    public void run() {
        int dy = -5;
        int delai = 101 - getVitesse();
        while (pos.getY() > 0) {

            deplacer(pos.getX(), pos.getY() + dy);

            try {
                Thread.sleep(delai);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void dessiner(Graphics g, ImageObserver observer) {

        g.setColor(Color.YELLOW);
        g.drawOval(pos.getX(), pos.getY(), 2, 2);
    }

    protected void finalize() {
        animator.interrupt();
        try {
            animator.join();
        } catch (InterruptedException e) {

        }
        animator = null;
        System.out.println("Balle detruite: " + getNom() + " (" + getId() + ")");
    }
}