package content.Threads.code.ExerciceBuffet;

public class Producteur implements Runnable {
    private final Buffet buffet;

    public Producteur(Buffet buffet) {
        this.buffet = buffet;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String plat = "Plat " + i;
            buffet.produire(plat);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
