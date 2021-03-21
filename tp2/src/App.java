
public class App {
    public static void main(String[] args) throws Exception {

        Voiture berline = new Voiture("Renault");

        Voiture sportive = new Voiture("BMW");
        sportive.setMoteur(new Moteur("essence", (short) 350));
        sportive.setCouleur("rouge");
        sportive.setNbPortes(2);

        System.out.println(berline);
        System.out.println(sportive);
    }
}
