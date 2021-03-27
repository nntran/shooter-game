package fr.ntdt.game.shooter.objet.avion.impl;

/**
 * Bombardier lourd avec une grande capacité d’emport et un long rayon d’action
 * larguant leurs bombes à haute altitude
 */
public class BombardierSpirit extends Bombardier {

    public BombardierSpirit() {
        super("Northrop B-2 Spirit");

        setResistance(0.3f);
    }
}
