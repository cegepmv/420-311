package PlanifCronJobs.Exo2;

import java.util.Timer;
import java.util.TimerTask;

public class MinuteurTask extends TimerTask {

    private int tempsRestant;
    private final Timer timer;

    public MinuteurTask(int tempsInitial, Timer timer) {
        this.tempsRestant = tempsInitial;
        this.timer = timer;
    }

    @Override
    public void run() {
        if (tempsRestant > 0) {
            System.out.println("Temps restant : " + tempsRestant + " s");
            tempsRestant--;
        } else {
            System.out.println("BOUM ! (minuteur terminé)");
            timer.cancel();
        }
    }
}