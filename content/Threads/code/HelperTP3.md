
# Fiche mémo – Threads en Java (pour *Rush au resto*)

## 1. Concepts de base

- **Thread** = fil d’exécution (chemin d’instructions).
- **Thread principal** = celui qui commence dans `main`.
- On peut créer d’autres threads pour faire du travail en parallèle
  (ex. : un cuisinier qui traite des commandes).

---

## 2. Créer un thread

### 2.1. Implémenter `Runnable` (recommandé)

```java
public class MonTravail implements Runnable {

    @Override
    public void run() {
        // Code exécuté dans le thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Travail - étape " + i);
        }
    }
}
````

```java
public class App {
    public static void main(String[] args) {
        MonTravail travail = new MonTravail();
        Thread t = new Thread(travail, "MonThread");
        t.start(); // démarre le thread, appelle run() dans ce thread
    }
}
```

> **Attention** : on utilise `start()`, **pas** `run()` directement.

---

## 3. Méthodes utiles de `Thread`

```java
t.start();      // démarre le thread (appelle run() en parallèle)
Thread.sleep( ms );  // met le thread courant en pause (ms millisecondes)
t.join();       // attendre que le thread t se termine
Thread.currentThread().getName(); // nom du thread courant
```

Exemple avec `sleep` et `join` :

```java
Thread t = new Thread(new MonTravail(), "Travailleur");
t.start();

try {
    t.join(); // on attend la fin du thread
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
System.out.println("Travail terminé");
```

---

## 4. Données partagées et `synchronized`

Dès qu’on a plusieurs threads, on peut avoir des **données partagées**
(ex. : `List<Commande> fileCommandes` accessible par `RestaurantJeu` et par `Cuisinier`).

Pour éviter des accès en même temps :

### 4.1. Méthode `synchronized`

```java
public class Compteur {
    private int valeur = 0;

    public synchronized void incrementer() {
        valeur++;
    }

    public synchronized int getValeur() {
        return valeur;
    }
}
```

### 4.2. Bloc `synchronized`

```java
public void faireQuelqueChose() {
    // code non protégé
    synchronized (this) {
        // section critique : un thread à la fois
    }
}
```

Dans le TP, on utilisera :

```java
public synchronized Commande retirerProchaineCommande() { ... }

public synchronized void marquerCommandeTerminee(Commande cmd) { ... }
```

---

## 5. Schéma producteur / consommateur (version simple)

Idée pour *Rush au resto* :

* **Producteur** : `RestaurantJeu` → ajoute des commandes dans une file.
* **Consommateur** : thread `Cuisinier` → enlève les commandes et les prépare.

Version simple (sans wait/notify) :

```java
public class FileCommandes {
    private final List<Commande> file = new ArrayList<>();

    public synchronized void ajouter(Commande cmd) {
        file.add(cmd);
    }

    public synchronized Commande retirer() {
        if (file.isEmpty()) {
            return null;
        }
        return file.remove(0);
    }
}
```

Côté cuisinier :

```java
public class Cuisinier implements Runnable {

    private final RestaurantJeu resto;

    public Cuisinier(RestaurantJeu resto) {
        this.resto = resto;
    }

    @Override
    public void run() {
        while (resto.isServiceActif()) {
            Commande cmd = resto.retirerProchaineCommande();
            if (cmd == null) {
                try {
                    Thread.sleep(50); // rien à faire → pause
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                continue;
            }

            int temps = cmd.calculerTempsPreparationTotal();
            // simuler la préparation
            try {
                Thread.sleep(100L * Math.max(1, temps));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            resto.marquerCommandeTerminee(cmd);
        }
    }
}
```

---

## 6. `wait()` / `notify()` et `Semaphore` (pour aller plus loin)

Pour le TP, **non obligatoires** mais à connaître en théorie :

* `wait()` / `notifyAll()` : utilisés dans un bloc `synchronized` pour endormir un thread
  jusqu’à ce qu’une condition soit vraie (file non vide, place libre, etc.).
* `Semaphore` : objet de la librairie `java.util.concurrent` pour limiter le nombre
  de threads qui accèdent à une ressource (ex. parking à 3 places).

On reste sur `synchronized` + `sleep()` pour l’épreuve,
mais ces notions existent pour des solutions plus avancées.

---

## 7. À retenir pour *Rush au resto*

* Un thread **obligatoire** : le cuisinier (`Cuisinier implements Runnable`).
* Le thread principal :

  * lit le fichier d’actions,
  * appelle `demarrerService`, `avancerTemps`, `afficherEtat`, etc.
* `RestaurantJeu` :

  * contient les collections partagées (`List`, `Map`),
  * expose des méthodes `synchronized` pour y accéder,
  * calcule l’état et les statistiques.
* Pas de `System.out.println` direct dans les threads →
  on passe par un `LoggerJeu` pour garder un format de sortie propre.

