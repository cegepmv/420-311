package content.Threads.code.ExerciceParking;

import java.util.concurrent.Semaphore;

public class Parking {
    private final Semaphore places = new Semaphore(3);

    public void entrer(String nomVoiture) {
        try {
            System.out.println(nomVoiture + " attend une place...");
            places.acquire();
            System.out.println(nomVoiture + " entre dans le parking.");
            Thread.sleep(1000); // simule le temps de stationnement
            System.out.println(nomVoiture + " sort du parking.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            places.release();
        }
    }
}
