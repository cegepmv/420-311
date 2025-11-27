package content.Threads.code.ProdConsWaitNotifyDemo;

public class Producteur implements Runnable {

    private final FilePartagee file;

    public Producteur(FilePartagee file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            // Produire 5 éléments
            for (int i = 1; i <= 5; i++) {
                String valeur = "Tâche " + i;
                file.produire(valeur);
                Thread.sleep(500); // petite pause entre chaque production
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[Producteur] Interrompu");
        }
    }
}

