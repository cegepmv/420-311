package PlanifCronJobs;

import java.util.Scanner;
import java.util.Timer;

public class MainChrono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Combien de secondes ? ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Valeur invalide.");
            return;
        }

        Timer timer = new Timer("ChronoTimer", true); // true = daemon

        ChronoTask task = new ChronoTask(n, timer);

        // Démarre immédiatement, puis toutes les 1000 ms (1 seconde)
        timer.scheduleAtFixedRate(task, 0, 1000);

        // Optionnel : attendre la fin du chrono avant de quitter main
        try {
            Thread.sleep((n + 1L) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Programme terminé.");
    }
}
