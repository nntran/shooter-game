
public class Moteur {

    // Type de moteur (diesel, essence, electrique)
    String type = "";

    // Puissance du moteur en chevaux (CV)
    short puissance = 2;

    public Moteur() {

        this("electrique", (short) 90);
    }

    public Moteur(String type, short puissance) {
        this.type = type;
        this.puissance = puissance;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Moteur type(String type) {
        setType(type);
        return this;
    }

    public short getPuissance() {
        return this.puissance;
    }

    public void setPuissance(short puissance) {
        this.puissance = puissance;
    }

    public Moteur puissance(short puissance) {
        setPuissance(puissance);
        return this;
    }

    public void demarrer() {

    }

    public void arreter() {

    }

    @Override
    public String toString() {
        return "Moteur {" + " type='" + getType() + "'" + ", puissance='" + getPuissance() + " CV'" + "}";
    }

}
