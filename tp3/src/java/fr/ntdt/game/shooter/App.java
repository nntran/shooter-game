package fr.ntdt.game.shooter;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;

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
        new App();
    }

}
