package content.Threads.code.ProdConsWaitNotifyDemo;

public class MainWaitNotifyDemo {

    public static void main(String[] args) {
        FilePartagee file = new FilePartagee();

        Thread cons1 = new Thread(new Consommateur(file), "C1");
        Thread cons2 = new Thread(new Consommateur(file), "C2");
        Thread prod  = new Thread(new Producteur(file), "P");

        cons1.start();
        cons2.start();

        // On laisse les consommateurs démarrer et probablement constater que la file est vide
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        prod.start();
    }
}

