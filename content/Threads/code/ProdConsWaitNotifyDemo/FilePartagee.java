package content.Threads.code.ProdConsWaitNotifyDemo;

import java.util.LinkedList;
import java.util.Queue;

public class FilePartagee {

    private final Queue<String> queue = new LinkedList<>();

    /**
     * Ajoute un élément dans la file et réveille tous les threads
     * qui pourraient être en attente.
     */
    public void produire(String valeur) {
        synchronized (this) {
            queue.add(valeur);
            System.out.println("[Producteur] Ajout de : " + valeur
                    + " (taille=" + queue.size() + ")");
            // Réveille tous les threads qui font this.wait()
            this.notifyAll();
        }
    }

    /**
     * Retire un élément dans la file.
     * Si la file est vide, attend qu'un producteur ajoute quelque chose.
     */
    public String consommer() throws InterruptedException {
        synchronized (this) {
            // Tant que la file est vide, on attend
            while (queue.isEmpty()) {
                System.out.println("[Consommateur-" + Thread.currentThread().getName()
                        + "] File vide, j'attends...");
                this.wait();  // libère le verrou et attend notifyAll
            }

            String valeur = queue.remove();
            System.out.println("[Consommateur-" + Thread.currentThread().getName()
                    + "] Je consomme : " + valeur
                    + " (taille restante=" + queue.size() + ")");
            return valeur;
        }
    }
}

