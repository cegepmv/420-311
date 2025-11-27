package PlanifCronJobs.Exo2;

import java.util.Scanner;
import java.util.Timer;

public class MainMinuteur {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Durée du minuteur (secondes) : ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Valeur invalide.");
            return;
        }

        Timer timer = new Timer("MinuteurTimer", true);
        MinuteurTask task = new MinuteurTask(n, timer);

        timer.scheduleAtFixedRate(task, 0, 1000);

        try {
            Thread.sleep((n + 2L) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Programme principal terminé.");
    }
}
