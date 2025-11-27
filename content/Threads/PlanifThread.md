+++
draft = false
title = 'Planifier des threads avec Timer et TimerTask'
weight = 82
+++

En Java, la classe `java.util.Timer` est un utilitaire conçu pour planifier l'exécution d'une `java.util.TimerTask` dans un thread d'arrière-plan, soit une seule fois après un délai spécifié, soit de manière répétée à intervalles réguliers.

## Concepts Clés

### TimerTask : 
TimerTask est une classe abstraite qui implémente l'interface Runnable. Vous devez étendre cette classe et surcharger sa méthode `run()` pour définir la tâche que vous souhaitez exécuter.
### Timer : 
Timer est le planificateur qui exécute la TimerTask. Il opère sur un seul thread d'arrière-plan et est thread-safe.

> On ne crée pas le thread à la main (`new Thread(...)`), c’est le Timer qui s’en charge et qui lance les `TimerTask` au bon moment.

### Exemples : exécuter une tâche après un délai
Voici un exemple simple montrant comment utiliser `Timer` et `TimerTask` :

```java
import java.util.Timer;
import java.util.TimerTask;

public class ExempleTimerSimple {

    public static void main(String[] args) {
        // Création du Timer : il crée un thread en arrière-plan
        Timer timer = new Timer();

        // Définition de la tâche à exécuter plus tard
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tâche exécutée après 5 secondes.");
            }
        };

        // Planifier la tâche dans 5000 ms (5 secondes)
        long delay = 5000L;
        timer.schedule(task, delay);

        System.out.println("Tâche planifiée, le main continue...");
    }
}
```

* `timer.schedule(task, delay)` : exécute **une seule fois** après `delay` millisecondes.
* Le `main` peut se terminer, mais tant que le `Timer` n’est pas arrêté, **le programme reste vivant** (thread du `Timer` non terminé).

## Tâche périodique : exécution répétée

Objectif : afficher l’heure toutes les 2 secondes, après un délai initial de 1 seconde.

```java
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalTime;

public class ExempleTimerPeriodique {

    public static void main(String[] args) {
        Timer timer = new Timer(); // thread en arrière-plan

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Heure actuelle : " + LocalTime.now());
            }
        };

        long delay = 1000L;     // 1 seconde avant la première exécution
        long period = 2000L;    // 2 secondes entre chaque exécution

        // Exécution périodique (schedule = basé sur le délai entre exécutions)
        timer.schedule(task, delay, period);

        System.out.println("Tâche périodique planifiée...");
    }
}
```

Ici :

* `schedule(task, delay, period)` :

  * attend `delay` ms,
  * puis exécute `task` **tous les `period` ms**.
* Toutes les exécutions sont faites dans **le même thread** géré par le `Timer`.



## Annuler une tâche ou un Timer

### Annuler une tâche spécifique

On peut appeler `cancel()` sur le `TimerTask` pour **arrêter les exécutions futures** :

```java
import java.util.Timer;
import java.util.TimerTask;

public class ExempleAnnulationTask {

    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            int compteur = 0;

            @Override
            public void run() {
                compteur++;
                System.out.println("Exécution n° " + compteur);

                if (compteur >= 5) {
                    System.out.println("Annulation de la tâche.");
                    this.cancel(); // annule les prochaines exécutions de CETTE tâche
                }
            }
        };

        long delay = 0L;
        long period = 1000L;

        timer.schedule(task, delay, period);
    }
}
```

### Annuler tout le `Timer`

On peut aussi arrêter complètement le `Timer` (et donc son thread) :

```java
timer.cancel(); // annule *toutes* les tâches et termine le thread du Timer
```

## Méthodes Timer Courantes
La classe `Timer` offre plusieurs méthodes schedule :
| Méthode                                         | Description                                                                                              |
|-------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `schedule(TimerTask task, long delay)`          | Exécute la tâche une seule fois après un délai spécifié en millisecondes.                               |
| `schedule(TimerTask task, Date time)`           | Exécute la tâche une seule fois à une date et heure précises.                                           |
| `schedule(TimerTask task, long delay, long period)` | Exécute la tâche de manière répétée après un délai initial et à intervalles fixes (exécution à délai fixe). |
| `scheduleAtFixedRate(TimerTask task, Date firstTime, long period)` | Exécute la tâche de manière répétée à une heure de début spécifique et à intervalles fixes (exécution à taux fixe). |


Deux méthodes importantes pour les tâches périodiques :

* `schedule(task, delay, period)`
  → l’intervalle est compté **à partir de la fin** de l’exécution précédente.
  Si la tâche est lente, les exécutions **peuvent dériver** dans le temps.

* `scheduleAtFixedRate(task, delay, period)`
  → essaie de maintenir un **rythme régulier** par rapport au temps de départ (compense les retards).
  Utile pour des tâches de type « toutes les 10 secondes pile », comme un timer d’affichage.

Exemple :

```java
timer.scheduleAtFixedRate(task, delay, period);
```

## Caractéristiques et limites de `Timer`

À retenir pour le cours :

1. **Un seul thread** par `Timer`
   → si une tâche prend beaucoup de temps, les suivantes attendent (elles sont **sérielles**).

2. Si une tâche lance une exception non gérée, le thread du `Timer` peut mourir et **aucune autre tâche ne sera exécutée**.

3. `Timer` est une API historique.
   Pour les projets modernes, on préfère souvent :

   * `ScheduledExecutorService` (package `java.util.concurrent`)
     qui peut gérer **plusieurs threads** et offre plus de contrôle.

Mais pour des raisons de simplicité pour introduire la planification et les threads, nous allons nous contenter des classes`Timer` et `TimerTask`.



## Lien avec `Thread` et `Runnable`

* Avec `Thread`, on écrivait :

  ```java
  Runnable r = () -> { /* code */ };
  Thread t = new Thread(r);
  t.start();
  ```

* Avec `Timer` / `TimerTask`, on délègue :

  * la création du thread,
  * la gestion du délai / de la périodicité,
  * et la relance de la tâche.

Cela permet de **se concentrer sur la logique de la tâche** (`run()`) plutôt que sur la gestion des threads.



## Ressources
[Oracle : TimerTask](https://docs.oracle.com/javase/8/docs/api/java/util/TimerTask.html)

