package fr.ntdt.game.shooter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.ntdt.game.shooter.objet.avion.Avion;

/**
 * 
 */
public final class Controlleur {

    private static final int TOUCHE_TIR = KeyEvent.VK_A;

    private boolean pressed = false;

    // Interdire l'instanciation de cette classe
    public Controlleur(Scene scene) {

        final Avion avion = scene.getAvion();

        scene.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();

                if (key == TOUCHE_TIR) {
                    avion.tirer();
                }
            }
        });

        AvionControlleur controller = new AvionControlleur(avion);
        scene.addMouseListener(controller);
        scene.addMouseMotionListener(controller);
    }

    private class AvionControlleur extends MouseAdapter {

        boolean pressed = false;
        Avion avion;

        public AvionControlleur(Avion avion) {
            this.avion = avion;
        }

        public void mousePressed(MouseEvent e) {
            pressed = !pressed;
        }

        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            if (pressed) {
                int x = e.getX();
                int y = e.getY();
                // System.out.println("X: " + x + " Y: " + y);
                if (y > 100) {
                    int h = avion.getHauteur();
                    avion.deplacer(x, y - h);
                }
            }
        }
    }
}
