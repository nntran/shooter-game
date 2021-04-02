package fr.ntdt.game.shooter.objet.arme;

import fr.ntdt.game.shooter.objet.Objet;
import fr.ntdt.game.shooter.objet.Point;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.List;
import java.util.ArrayList;

public class LanceMissiles extends Arme {

    public static final int NB_MISSILES = 3;
    private List<Missile> missiles;

    public LanceMissiles() {
        super("Lance missiles MX5", null);

        missiles = new ArrayList<>(NB_MISSILES);
    }

    @Override
    public Portee getPortee() {
        return Portee.LONG;
    }

    @Override
    public Balle[] tirer(List<Objet> cibles) {
        synchronized (this) {
            // for (int i = NB_MISSILES; i > 0; i--) {
            Missile m = new Missile();
            m.setPos(new Point(pos.getX(), pos.getY()));
            missiles.add(m);
            // }
        }
        return null;
    }

    @Override
    public void touche(Objet objet) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dessiner(Graphics g, ImageObserver observer) {

        // Afficher l'objet
        super.dessiner(g, observer);

        // Afficher les missiles
        System.out.println("Nombre de missiles: " + missiles.size());
        for (Missile missile : missiles) {
            missile.dessiner(g, observer);
        }
    }

    private class Missile extends Balle {

        protected Missile() {
            super("", null);
        }

        @Override
        public void touche(Objet objet) {
            // TODO Auto-generated method stub

        }

        @Override
        public int getVitesse() {
            return 85;
        }

        @Override
        public void run() {
            super.run();
            if (this.getPos().getY() < 20) {
                synchronized (missiles) {
                    missiles.remove(this);
                }
            }
        }
    }

}
