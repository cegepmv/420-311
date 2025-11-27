package PlanifCronJobs;

import java.util.Timer;
import java.util.TimerTask;

public class ChronoTask extends TimerTask {

    private int secondeCourante = 0;
    private final int maxSecondes;
    private final Timer timer;

    public ChronoTask(int maxSecondes, Timer timer) {
        this.maxSecondes = maxSecondes;
        this.timer = timer;
    }

    @Override
    public void run() {
        secondeCourante++;
        System.out.println("t = " + secondeCourante + " s");

        if (secondeCourante >= maxSecondes) {
            System.out.println("Fin du chrono.");
            timer.cancel(); // arrête le Timer et toutes les futures exécutions
        }
    }
}