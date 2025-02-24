package fr.ntdt.game.shooter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fr.ntdt.game.shooter.objet.Objet;
import fr.ntdt.game.shooter.objet.Point;
import fr.ntdt.game.shooter.objet.arme.Arme;
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

    // Avions ennemies
    private List<Objet> ennemies;

    public Scene() {

        // set background color for this JPanel
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

        // Création d'un avion dans la scène
        avion = new RafaleF3R();
        int la = avion.getLargeur();
        int ha = avion.getHauteur();
        int x = (LARGEUR - (la / 2)) / 2;
        int y = (HAUTEUR - ha - 80);
        avion.setPos(new Point(x, y));

        ennemies = creerEnnemies();

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

    /**
     * 
     * @return
     */
    public Avion getAvion() {
        return avion;
    }

    /**
     * 
     * @return
     */
    public List<Objet> getEnnemies() {
        return ennemies;
    }

    // Override paint to perform your own painting
    @Override
    public void paint(Graphics g) {
        // paint parent's background
        super.paint(g);

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

        // affichier les armes en haut de la scène
        Arme principale = avion.getArmePrincipale();
        Arme secondaire = avion.getArmeSecondaire();

        g.setColor(Color.CYAN);
        g.setFont(new Font("Monospaced", Font.PLAIN, 10));
        if (principale != null) {
            g.drawString(principale.getNom(), 100, 10);
        }
        if (secondaire != null) {
            g.drawString(secondaire.getNom(), 100, 30);
        }

        // dessiner l'avion dans cette scène
        avion.dessiner(g, this);

        // afficher les ennemies
        for (Objet ennemie : ennemies) {
            ennemie.dessiner(g, this);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run() {

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

    /**
     * 
     * @return Liste des ennemies visibles sur la scène
     */
    private List<Objet> creerEnnemies() {
        // TODO : à implémenter

        List<Objet> ennemies = new ArrayList<>();
        Avion ennemie1 = new Avion("Ennemie 1", "avion-2.png");
        ennemie1.rotation(180);
        ennemie1.setPos(new Point(300, 100));
        ennemies.add(ennemie1);

        return ennemies;
    }
}
