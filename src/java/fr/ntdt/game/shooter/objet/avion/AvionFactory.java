package fr.ntdt.game.shooter.objet.avion;

/**
 * Conception d'une usine de fabrication des avions
 */
public interface AvionFactory {

    /**
     * Créer un avion en lui attribuant un matricule (numéro de série)
     * 
     * @param nom
     * @return
     */
    public Avion creerAvion(String nom);

}
