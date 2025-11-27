+++
draft = false
title = 'Exercices sur les threads'
weight = 83
+++

## Exercices Threads simples

### Exercice 1:

#### Créer un thread simple
Écrire une classe Compteur qui :
- implémente Runnable ;
- affiche les nombres de 1 à 10 avec Thread.sleep(200) entre chaque ;
- lancer deux compteurs en parallèle dans main.

### Exercice 2:

#### Partage de données + synchronized

- Créer une classe CompteurPartage avec un entier valeur.
- Deux threads incrémentent valeur 1000 fois chacun, avec et sans synchronized.
- Observer la différence sur le résultat.

### Exercice 3:

#### Mini producteur / consommateur

- Une liste de String partagée ;
- le thread principal ajoute des chaînes "Tâche 1", "Tâche 2", … dans la liste ;
- un thread travailleur prend les tâches et les affiche avec un sleep.


## Exercices avec de `Semaphore`

### Exercice 1 
#### Parking à 3 places avec `Semaphore`

On veut simuler un **petit parking** qui ne peut accueillir que **3 voitures** en même temps.

* Chaque voiture est un thread.
* Le parking a une capacité maximale de 3.
* Si le parking est plein, la voiture doit **attendre** qu’une place se libère.

#### Consignes

1. Créer une classe `Parking` avec :

   * un attribut `Semaphore` initialisé à **3** permissions ;
   * une méthode `entrer(String nomVoiture)` :

     * affiche que la voiture attend une place ;
     * appelle `acquire()` sur le sémaphore ;
     * affiche que la voiture est entrée dans le parking ;
     * simule un stationnement avec `Thread.sleep(...)` ;
     * libère la place avec `release()` ;
     * affiche que la voiture sort du parking.

2. Créer une classe `Voiture` qui implémente `Runnable` :

   * possède une référence vers le `Parking` ;
   * dans `run()`, appelle `parking.entrer(nomVoiture)`.

3. Dans un `main`, créer **5 threads voitures** (par ex. V1, V2, V3, V4, V5) et les démarrer.

#### Résultat attendu (approx.)

On veut voir quelque chose du genre (l’ordre peut varier) :

```text
V1 attend une place...
V2 attend une place...
V3 attend une place...
V1 entre dans le parking.
V2 entre dans le parking.
V3 entre dans le parking.
V4 attend une place...
V5 attend une place...
V1 sort du parking.
V4 entre dans le parking.
V2 sort du parking.
V5 entre dans le parking.
...
```

> On ne doit jamais voir plus de **3 voitures “dans le parking”** en même temps.



### Exercice 2 
#### File de commandes limitée (buffet) avec `Semaphore`

On simule un **buffet** où :

* un **producteur** ajoute des plats dans un **buffer de taille max = 3** ;
* un **consommateur** prend les plats un par un.

On ne veut **jamais** :

* déposer un plat si le buffer est plein ;
* retirer un plat si le buffer est vide.

#### Sémaphores à utiliser

On va utiliser **2 sémaphores** :

* `semPlacesLibres` : nombre de places disponibles dans le buffer

  * initialisé à 3 ;
* `semPlatsDispo` : nombre de plats actuellement disponibles

  * initialisé à 0.

Et **une seule** structure de données partagée :

* par exemple, un `List<String> buffer = new ArrayList<>();`
* accès protégé par `synchronized`.

#### Consignes

1. Créer une classe `Buffet` :

   * Attributs :

     * `List<String> buffer`
     * `Semaphore semPlacesLibres` (3)
     * `Semaphore semPlatsDispo` (0)
   * Méthode `produire(String plat)` :

     1. `semPlacesLibres.acquire()`
     2. `synchronized(buffer) { ... }` → ajouter le plat au buffer
     3. `semPlatsDispo.release()`
   * Méthode `consommer()` :

     1. `semPlatsDispo.acquire()`
     2. `String plat; synchronized(buffer) { ... }` → retirer le plat du buffer
     3. `semPlacesLibres.release()`
     4. retourner le plat

2. Créer une classe `Producteur` (implémente `Runnable`) :

   * Dans `run()` :

     * produire par ex. 10 plats (`"Plat 1"`, `"Plat 2"`, …), avec un petit `sleep`.

3. Créer une classe `Consommateur` (implémente `Runnable`) :

   * Dans `run()` :

     * consommer dans une boucle (ex. 10 plats), avec un petit `sleep`.

4. Dans le `main` :

   * Créer un `Buffet buffet = new Buffet();`
   * Créer un thread producteur + un thread consommateur.
   * Démarrer les deux.

#### Résultat attendu (approx.)

On veut voir une alternance du style :

```text
Producteur dépose Plat 1
Producteur dépose Plat 2
Consommateur prend Plat 1
Producteur dépose Plat 3
Producteur veut déposer Plat 4 mais le buffer est plein → il attend (bloqué dans acquire)
Consommateur prend Plat 2
...
```

> Le **buffer** ne doit jamais contenir plus de 3 plats.
> Le consommateur **n’essaie pas** de prendre un plat quand il n’y en a pas (il attend automatiquement).

---

## Exercices avec `Timer` et `TimerTask`
### Exercice 1 – Mini horloge console

On veut créer un programme qui affiche une “horloge simulée” dans la console.

#### Spécifications

1. Le programme demande à l’utilisateur un nombre de secondes, par exemple :

   ```text
   Combien de secondes ? 5
   ```

2. Le programme démarre un `Timer` qui affiche chaque seconde :

   ```text
   t = 1 s
   t = 2 s
   ...
   t = N s
   ```

3. Après `N` secondes, le programme :

   * arrête le `Timer` (annule les tâches),
   * affiche un message de fin, par exemple :

   ```text
   Fin du chrono.
   ```

#### Contraintes

* Utiliser `java.util.Timer` et `java.util.TimerTask`.
* Ne pas utiliser de boucle `while(true) { Thread.sleep(...); }` pour cette horloge.
* Bien fermer le `Timer` avec `cancel()` lorsque le chrono est terminé.

#### Pistes

* Créer une classe `ChronoTask` qui étend `TimerTask` et qui :

  * connaît le nombre de secondes max,
  * incrémente un compteur interne à chaque exécution de `run()`.
* Dans `main` :

  * lire le nombre de secondes avec un `Scanner`,
  * créer un `Timer`,
  * programmer la tâche avec `scheduleAtFixedRate(...)`.



### Exercice 2 – Minuteur à rebours

Variante : au lieu d’afficher `t = 1 s`, `t = 2 s`, …, on affiche un **compte à rebours** :

Exemple pour 5 secondes :

```text
Temps restant : 5 s
Temps restant : 4 s
Temps restant : 3 s
Temps restant : 2 s
Temps restant : 1 s
BOUM ! (ou un message de votre choix)
```

* Même principe : `Timer` + `TimerTask`, mais on décrémente au lieu d’incrémenter.
