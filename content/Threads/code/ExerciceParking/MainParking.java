package content.Threads.code.ExerciceParking;

public class MainParking {
    public static void main(String[] args) {
        Parking parking = new Parking();

        for (int i = 1; i <= 5; i++) {
            String nom = "V" + i;
            Thread t = new Thread(new Voiture(nom, parking), nom);
            t.start();
        }
    }
}