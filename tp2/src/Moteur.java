
public class Moteur {

    String type = "";
    short nbCv = 2;

    public Moteur() {

        this("electrique", (short) 90);
    }

    public Moteur(String type, short nbCv) {
        this.type = type;
        this.nbCv = nbCv;
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

    public short getNbCv() {
        return this.nbCv;
    }

    public void setNbCV(short nbCv) {
        this.nbCv = nbCv;
    }

    public Moteur nbCV(short nbCv) {
        setNbCV(nbCv);
        return this;
    }

    public void demarrer() {

    }

    public void arreter() {

    }

    @Override
    public String toString() {
        return "Moteur {" + " type='" + getType() + "'" + ", nbCv='" + getNbCv() + "'" + "}";
    }

}
