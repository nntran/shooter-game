
public class Roue {

    // Dimension de la roue
    String dimension;

    // Taille de la jante (en pouces)
    int taille = 15;

    public String getDimension() {
        return this.dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Roue dimension(String dimension) {
        setDimension(dimension);
        return this;
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Roue taille(int taille) {
        setTaille(taille);
        return this;
    }

    @Override
    public String toString() {
        return "Roue {" + " dimension='" + getDimension() + "'" + ", taille='" + getTaille() + "'" + "}";
    }

}
