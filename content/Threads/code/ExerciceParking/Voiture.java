package content.Threads.code.ExerciceParking;

public class Voiture implements Runnable {
    private final String nom;
    private final Parking parking;

    public Voiture(String nom, Parking parking) {
        this.nom = nom;
        this.parking = parking;
    }

    @Override
    public void run() {
        parking.entrer(nom);
    }
}
