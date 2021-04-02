package fr.ntdt.game.shooter.objet.arme;

import java.util.List;

import fr.ntdt.game.shooter.objet.Objet;

public class Speciale extends Arme {

    protected Speciale(String nom, String image) {
        super(nom, image);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Portee getPortee() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Balle[] tirer(List<Objet> cibles) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void touche(Objet objet) {
        // TODO Auto-generated method stub

    }

}
