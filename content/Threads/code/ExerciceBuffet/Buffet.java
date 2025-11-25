package content.Threads.code.ExerciceBuffet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buffet {
    private final List<String> buffer = new ArrayList<>();
    private final Semaphore semPlacesLibres = new Semaphore(3);
    private final Semaphore semPlatsDispo = new Semaphore(0);

    public void produire(String plat) {
        try {
            semPlacesLibres.acquire();
            synchronized (buffer) {
                buffer.add(plat);
                System.out.println("Producteur dépose " + plat + " (buffer=" + buffer.size() + ")");
            }
            semPlatsDispo.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String consommer() {
        try {
            semPlatsDispo.acquire();
            String plat;
            synchronized (buffer) {
                plat = buffer.remove(0);
                System.out.println("Consommateur prend " + plat + " (buffer=" + buffer.size() + ")");
            }
            semPlacesLibres.release();
            return plat;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
