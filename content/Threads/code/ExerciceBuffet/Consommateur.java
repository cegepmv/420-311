public class Consommateur implements Runnable {
    private final Buffet buffet;

    public Consommateur(Buffet buffet) {
        this.buffet = buffet;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffet.consommer();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}