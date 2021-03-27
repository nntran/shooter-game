package fr.ntdt.game.shooter;

import fr.ntdt.game.shooter.objet.Point;
import fr.ntdt.game.shooter.objet.avion.Avion;
import fr.ntdt.game.shooter.objet.avion.impl.BombardierNighthawk;
import fr.ntdt.game.shooter.objet.avion.impl.RafaleF3R;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Scene extends Panel implements Runnable, ActionListener {

    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private final int DELAY = 25;

    // Avion a1 = new BombardierNighthawk();
    Avion avion = new RafaleF3R();

    private Thread animator;

    public Scene() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        avion.setPos(new Point(WIDTH / 2, HEIGHT - 60));

        addKeyListener(new KeyboardAdapter());
    }

    @Override
    public void addNotify() {

        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

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

        // // Here we create the ellipse.
        // Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        // g2d.setStroke(new BasicStroke(1));
        // g2d.setColor(Color.gray);

        // for (double deg = 0; deg < 360; deg += 5) {
        // AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
        // at.rotate(Math.toRadians(deg));
        // g2d.draw(at.createTransformedShape(e));
        // }

        // // Your custom painting codes. For example,
        // // Drawing primitive shapes
        // g.setColor(Color.YELLOW); // set the drawing color
        // g.drawLine(30, 40, 100, 200);
        // g.drawOval(150, 180, 10, 10);
        // g.drawRect(200, 210, 20, 30);
        // g.setColor(Color.RED); // change the drawing color
        // g.fillOval(300, 310, 30, 50);
        // g.fillRect(400, 350, 60, 50);
        // // Printing texts
        // g.setColor(Color.WHITE);
        // g.setFont(new Font("Monospaced", Font.PLAIN, 12));
        // g.drawString("Testing custom drawing ...", 10, 20);

        avion.afficher(g, this);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

        while (true) {

            // cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                String msg = String.format("Thread interrupted: %s", e.getMessage());
                JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }

    // private void cycle() {

    // int x = avion.getPos().getX();
    // int y = avion.getPos().getY();

    // x += 1;
    // y += 1;

    // if (y > HEIGHT - 60) {
    // y -= 1;
    // }

    // if (x > WIDTH - 30) {
    // x -= 1;
    // }

    // avion.getPos().setX(x);
    // avion.getPos().setY(y);
    // }

    private class KeyboardAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            // avion.deplacer(0, 0);
            int pas = 4;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
