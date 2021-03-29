package fr.ntdt.game.shooter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import fr.ntdt.game.shooter.objet.Point;
import fr.ntdt.game.shooter.objet.Objet;
import fr.ntdt.game.shooter.objet.avion.Avion;
import fr.ntdt.game.shooter.objet.avion.RafaleF3R;

public class Scene extends Panel implements Runnable {

    private final int LARGEUR = 640;
    private final int HAUTEUR = 780;

    private final int DELAI_RAFRESH = 5;

    // Processus qui assure l'animation et le rafraichissement des
    // objets dans la scène
    private Thread animator;

    // Avion du joueur
    private Avion avion;

    public Scene() {

        setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        addKeyListener(new KeyboardAdapter());

        // Création d'un avion dans la scène
        avion = new RafaleF3R();
        int la = avion.getLargeur();
        int ha = avion.getHauteur();
        int x = (LARGEUR - (la / 2)) / 2;
        int y = (HAUTEUR - ha - 80);
        avion.setPos(new Point(x, y));

        // Création d'un processus qui assure l'animation et le rafraichissement des
        // objets dans la scène
        animator = new Thread(this);
        animator.start();
    }

    // @Override
    // public void addNotify() {

    // super.addNotify();

    // animator = new Thread(this);
    // animator.start();
    // }

    // Override paint to perform your own painting
    @Override
    public void paint(Graphics g) {
        // paint parent's background
        super.paint(g);
        // set background color for this JPanel
        setBackground(Color.BLACK);

        // It is a good programming practice to delegate the actual painting to a
        // specific method.
        Graphics2D g2d = (Graphics2D) g;

        // The Graphics2D class extends the Graphics class. It provides more
        // sophisticated control over geometry, coordinate transformations, colour
        // management, and text layout.
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // The rendering hints are used to make the drawing smooth.
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        // Afficher l'avion
        avion.dessiner(g, this);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

        while (true) {

            repaint();

            try {
                Thread.sleep(DELAI_RAFRESH);
            } catch (InterruptedException e) {
                String msg = String.format("Thread interrupted: %s", e.getMessage());
                JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class KeyboardAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            int pas = 8;
            if (key == KeyEvent.VK_LEFT) {
                avion.deplacer(-pas, 0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                avion.deplacer(pas, 0);
            }

            if (key == KeyEvent.VK_UP) {
                avion.deplacer(0, -pas);
            }

            if (key == KeyEvent.VK_DOWN) {
                avion.deplacer(0, pas);
            }
        }
    }
}
