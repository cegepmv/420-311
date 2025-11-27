package content.Threads.code.ProdConsWaitNotifyDemo;

public class Consommateur implements Runnable {

    private final FilePartagee file;

    public Consommateur(FilePartagee file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            // Consommer 3 éléments chacun, par exemple
            for (int i = 0; i < 3; i++) {
                String valeur = file.consommer();
                // Simuler un traitement
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[Consommateur-" + Thread.currentThread().getName() + "] Interrompu");
        }
    }
}
