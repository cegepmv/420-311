public class TwoThreadsWaitNotify {
    // Ressource partagée + protocole minimal
    static class Shared {
        int n = 0;
        long square = 0;
        boolean hasItem = false; // true quand (n, n^2) est prêt à afficher
    }

    public static void main(String[] args) throws InterruptedException {
        Shared shared = new Shared();

        Runnable producer = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (shared) {
                        while (shared.hasItem) shared.wait(); // attendre que le consommateur lise
                        shared.n++;
                        shared.square = (long) shared.n * shared.n;
                        shared.hasItem = true;
                        shared.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (shared) {
                        while (!shared.hasItem) shared.wait(); // attendre qu'un item soit prêt
                        System.out.printf("[%s] n=%d, n^2=%d%n",
                                Thread.currentThread().getName(), shared.n, shared.square);
                        shared.hasItem = false;
                        shared.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread t1 = new Thread(producer, "incremente-carre");
        Thread t2 = new Thread(consumer, "afficheur");
        t1.start();
        t2.start();

        Thread.sleep(2000);
        t1.interrupt();
        t2.interrupt();
        t1.join();
        t2.join();
        System.out.println("Arrêt propre.");
    }
}
