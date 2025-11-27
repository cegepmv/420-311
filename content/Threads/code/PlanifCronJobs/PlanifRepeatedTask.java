package PlanifCronJobs;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class PlanifRepeatedTask {
    public static void main(String[] args) {
        Timer timer = new Timer(); // Crée une nouvelle instance de Timer

        // Définit la tâche en étendant TimerTask
        TimerTask tache = new TimerTask() {
            @Override
            public void run() {
                // Code à exécuter
                System.out.println("Tâche exécutée le : " + new Date());
            }
        };

        // Planifie la tâche pour une exécution répétée à délai fixe
        long delaiInitial = 1000L; // Délai avant la première exécution (1 seconde)
        long periode = 5000L; // Temps entre les exécutions suivantes (5 secondes)
        
        timer.schedule(tache, delaiInitial, periode);

        // Pour arrêter le timer après un certain temps (optionnel)
        // try {
        //     Thread.sleep(25000); // Laisse la tâche s'exécuter pendant 25 secondes
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // timer.cancel(); // Termine le thread du timer
    }
}