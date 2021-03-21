
/**
 * Cette classe modélise une voiture
 * 
 */
public class Voiture {

    // La marque de la voiture
    String marque;

    // Couleur de la voiture
    String couleur = "Bleu";

    // Nombre de places
    int nbPlaces = 5;

    // Nombre de portes
    int nbPortes = 4;

    // Moteur
    Moteur moteur = null;

    // Une voiture a 4 roues représentées sous forme d'un tableau
    Roue roues[] = new Roue[4];

    /**
     * Constructeur permettant de créer une nouvelle voiture (un objet ou instance
     * de la classe {@link Voiture})
     * 
     * @param marque Marque de la voiture
     */
    public Voiture(String marque) {
        this.marque = marque;
        this.moteur = new Moteur("diesel", (short) 120);
        roues[0] = new Roue();
        roues[1] = new Roue();
        roues[2] = new Roue();
        roues[3] = new Roue();
    }

    public String getMarque() {
        return marque;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getNbPlaces() {
        return this.nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getNbPortes() {
        return this.nbPortes;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public Moteur getMoteur() {
        return this.moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public Roue[] getRoues() {
        return this.roues;
    }

    public void setRoues(Roue roues[]) {
        this.roues = roues;
    }

    public void avancer() {

    }

    public void reculer() {

    }

    @Override
    public String toString() {
        return "Voiture {" + " marque='" + getMarque() + " couleur='" + getCouleur() + "'" + ", nbPlaces='"
                + getNbPlaces() + "'" + ", nbPortes='" + getNbPortes() + "'" + ", moteur='" + getMoteur() + "'" + "}";
    }

}
