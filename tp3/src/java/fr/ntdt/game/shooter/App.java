package fr.ntdt.game.shooter;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Classe principale de démarrage du jeu
 */
public class App extends JFrame {

    public App() {

        setTitle("Shooter Game");

        // no layout manager
        // setLayout(null);

        Scene scene = new Scene();
        add(scene);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            App game = new App();
            game.setVisible(true);
        });
    }

}
