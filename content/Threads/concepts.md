+++
draft = false
title = 'Treads en Java'
weight = 81
+++


## 1) De la machine au programme : processeur, multitâche, multithread

### 1.1 Processeur, mono-cœur vs multi-cœurs

* **Monoprocesseur (mono-cœur)** : à un **instant donné**, un seul programme tourne sur l’unité centrale. L’**illusion de simultanéité** vient du système d’exploitation (OS) qui **passe la main** très vite d’un programme à l’autre (préemption + quantum de temps).
* **Multiprocesseur / multicœur** : une même puce contient **plusieurs cœurs** indépendants. On peut exécuter **plusieurs threads réellement en parallèle** (un par cœur), ce qu’on appelle **TLP – Thread Level Parallelism**.

### 1.2 Multitâche (au niveau OS)

* Le **multitâche** désigne la capacité d'un système d'exploitation à exécuter (ou donner l’illusion d’exécuter) **plusieurs processus** “en même temps” en **partageant le CPU**.
* Sur I/O (clavier, disque, réseau…), l’OS **profite des attentes** d’un programme pour **planifier** un autre.

### 1.3 Multithreading (à l’intérieur d’un processus)

* Le **multithread** étend le multitâche **à l’échelle d’une application** : un **processus** peut contenir **plusieurs threads**, chacun étant un **flux d’exécution**.
* Sur **multi-cœurs**, des threads peuvent **avancer vraiment en parallèle** appelé Thread Level Parallelism (TLP). Sur **mono-cœur**, on retrouve l’**illusion** via le **time-slicing** de l’OS/JVM.

## 2) Threads, sections critiques, exclusion mutuelle

### 2.1 Notion de thread 
* **Thread Level Parallelism** : ce terme est utilisé pour décrire le fonctionnement interne des données lors de l’exécution de tâches divisées sur plusieurs threads. 
* Les tâches sont exécutées en parallèle sur les multiples cœurs du processeur avec chacun son propre thread.
* Un **« thread »** est l’appellation donnée à la technique utilisée par un programme pour séparer plusieurs tâches et les exécuter simultanément.
* Un processus est capable de contenir plusieurs « threads » qui utiliseront les ressources fournies par celui-ci.
* Cependant, **les threads s’exécutent indépendamment**. On peut voir cela comme des mini processus dans un gros processus.
* L’utilisation la plus intéressante des threads est quand ils sont utilisés pour **diviser les tâches** d’un seul processus sur plusieurs processeurs (cœurs).
* L’utilisation de plusieurs threads nécessite une gestion des opérations effectuées de telle sorte que le même espace mémoire ne soit pas manipulé deux fois simultanément.
* Ce problème est contournable avec l’utilisation des algorithmes, mais un programmeur qui ne fait pas attention pourra faire face à une étreinte mortelle (« deadlock »). 
* Ce problème survient quand un des deux « threads » attend que l’autre se termine, mais l’autre « thread » attend que le premier se termine. Nous sommes donc en présence d’une boucle infinie qui ne se terminera jamais puisque chaque « thread » attend l’un après l’autre.

### 2.2 Définitions essentielles

Dans un système distribué, les processus sont susceptibles d’accéder à une ou plusieurs ressources partagées (variables, pages, mémoires, fichiers, etc.). Pour éviter les incohérences dues aux accès concurrents des processus, il est indispensable que ceux-ci synchronisent leurs accès.

* **Exclusion mutuelle** : garantir qu’**au plus un thread** exécute **la section critique** à un instant donné. 

* **Objet critique** : ressource **non réentrante**/non simultanément accessible (imprimante, fichier, structure mémoire…).

* **Section critique** : code qui **manipule** un objet critique. Sans protection, l’exécution concurrente peut produire des **résultats imprévisibles** lorsqu’elle est exécutée simultanément par des processus différents.

![deadlock](/420-311/images/Thread_deadlock.jpg)

### 2.3 Problèmes classiques

* **Condition de course (race)** : deux threads lisent/modifient un état partagé **sans coordination** → incohérences.
* **Interblocage (deadlock)** : t1 tient le verrou A et attend B, t2 tient B et attend A → **attente circulaire** infinie.
* **Famine (starvation)** / **livelock** : un thread n’obtient jamais les ressources / tout le monde bouge mais **rien n’avance**.

## 3) Les threads en Java
* Java présente l’originalité d’appliquer les algorithmes de multiprogrammation au sein d’un même programme dont on dit alors qu’il est formé de plusieurs threads indépendants. 
* Le contrôle de l’exécution de ces différents threads (c’est-à-dire la façon dont la main passe de l’un à l’autre) se fera alors, au moins partiellement, au niveau du programme lui-même et ces threads pourront facilement communiquer entre eux et partager des données.
* En Java, un thread est un objet qui dispose d’une méthode nommée run qui sera exécutée lorsque le thread sera démarré. 
* Il existe deux façons de créer des threads: 
  - soit en exploitant la classe prédéfinie Thread, 
  - soit en créant une classe spécifique implémentant l’interface Runnable.
*	Un programme comporte toujours au moins un thread dit "thread principal" correspondant tout simplement à la méthode main. 
*	Le lancement d’un thread fait référence à la méthode « run » et cela en appelant la méthode « start ».
* La méthode start ne peut être appelée qu’une seule fois pour un objet thread donné. Dans le cas contraire, on obtiendra une exception IllegalThreadStateException.
* En java, les threads possèdent une méthode « sleep », qui est une méthode statique (de la classe Thread) et qui met en sommeil le thread en cours d’exécution.

### 3.1 Créer un thread

Deux approches idiomatiques :

```java
// 1) Runnable
class Tache implements Runnable {
  @Override public void run() { /* travail */ }
}
Thread t = new Thread(new Tache(), "T1");
t.start();

// 2) Étendre Thread 
class Worker extends Thread {
  public Worker(String name) { super(name); }
  @Override public void run() { /* travail */ }
}
new Worker("W1").start();
```

> **Important** : on **n’appelle jamais** `run()` directement pour démarrer un thread — on appelle **`start()`** qui confie l’exécution à la JVM/OS. `start()` **ne peut être appelé qu’une fois** par instance, sinon `IllegalThreadStateException`.

Exemple : 
```java
public class MonTravail implements Runnable {

    private final String nom;

    public MonTravail(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        // Code exécuté dans le thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(nom + " - étape " + i);
            try {
                Thread.sleep(500); // pause de 500 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nom + " interrompu");
                return;
            }
        }
        System.out.println(nom + " terminé.");
    }
}
```

Et dans un main :

```java
public class App {
    public static void main(String[] args) {
        MonTravail travail1 = new MonTravail("Tâche A");
        MonTravail travail2 = new MonTravail("Tâche B");

        Thread t1 = new Thread(travail1, "Thread-A");
        Thread t2 = new Thread(travail2, "Thread-B");

        t1.start(); // démarre le thread, appelle run() en parallèle
        t2.start();

        System.out.println("Main continue pendant que A et B travaillent...");
    }
}
```

### 3.2 Méthodes essentielles de `Thread`

* `start()` : demande à la JVM d’exécuter `run()` dans un **nouveau** thread.
* `sleep(ms[, ns])` *(statique)* : endort **le thread courant** (doit être entouré d’un try/catch (InterruptedException)).
* `interrupt()` / `isInterrupted()` / `interrupted()` : **signal d’arrêt** non violent (coopératif).
* `join()` / `join(timeout)` : **attendre la fin** d’un autre thread.
* `setPriority(1..10)` : **à éviter** en pratique (portabilité/équité non garanties).
* `yield()` : propose de laisser la main (effet non garanti → diagnostique/démo).

> Méthodes historiques comme `stop()`, `suspend()`, `resume()`, `destroy()` sont **dangereuses/déconseillées** (incohérences d’état). On privilégie **l’interruption** et un **arrêt gracieux**.

#### Exemple avec join()
Parfois, on veut que le thread principal attende qu’un autre thread finisse.

```java
Thread t = new Thread(new MonTravail("Tâche C"));
t.start();

// attendre que t soit terminé
try {
    t.join();
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
System.out.println("Tâche C terminée, on continue.");

```
### 3.3 Cycle de vie (états)

![Thread lifecycle](/420-311/images/Thread_lifecycle2.png)

Un thread peut passer par plusieurs états lors de son cycle de vie: 
1.	**En cours d'exécution** : le processeur est en train d'exécuter le thread. Le mécanisme de gestion de threads décide quel thread doit être dans l'état d'exécution. Cette exécution sera fonction du temps CPU alloué par le système.

    a.	Dès que ce temps est écoulé, le thread attend que le gestionnaire le rappelle. 

    b.	Un thread se retrouve dans cet état à la suite de l'appel de « yield » (pour passer la main et donner ainsi donc la chance à un autre thread afin de s'exécuter) ou bien à la suite d’une interruption.
2.	**État bloqué** : En fonction de l'action sur le thread, ce dernier passe de l'état « en cours d'exécution » vers l'état bloqué. Il faudra une action « spéciale » pour sortir de cet état. On distingue trois possibilités pour arriver à cet état:

    a. **État en attente**: Un appel à la méthode « wait » de la classe Object met le thread en attente. Il faudra un appel à la méthode **`notify()`** (ou **`notifyAll()`**) pour quitter cet état et revenir à l'état prêt. 
    
    b. **État au repos** : Un appel à la méthode static « sleep » permet d'endormir pendant un certain temps un thread. Ce dernier se réveille et se met à l'état.

    c.	**État bloqué** : Par exemple quand le thread est en attente d'une ressource. Pour sortir de cet état, il faut que l'opération soit terminée avant de passer à l'état « prêt ».

3.	**Prêt(RUNNABLE)** : la création du thread nécessite l'attribution de certaines ressources avant qu'il ne soit éligible pour l'exécution. L’OS/Horaireur choisit qui tourne.

    * Un appel à la méthode « start » ne signifie pas que le thread sera exécuté sur le champ, mais plutôt qu'il est prêt pour être exécuté par le système d'exploitation. Ce dernier devra allouer un temps machine (CPU) pour l'exécution de ce thread. 
    * Un thread quittant l'état bloqué doit impérativement passer par l'état « prêt » et attendre que le mécanisme de gestion de threads lui attribue un temps CPU.
4.	Mort: un thread est dans cet état à la suite de la fin de l'exécution de la méthode **`run()`** lui étant associée, ou bien après son arrêt à la suite de l'appel de la méthode **`stop()`** ou a levé une exception non rattrapée.


### 3.4 Le modèle mémoire Java (JMM) en pratique

* **Visibilité** : quand une écriture par t1 devient visible par t2 ?
* **Atomicité** : une opération se fait-elle “d’un seul coup” ?
* Outils :

  * `volatile` ⇒ **visibilité garantie** (pas d’atomicité).
  * `synchronized` / **verrous** (`ReentrantLock`) ⇒ exclusion + **publication** (visibilité).
  * **Types atomiques** (`AtomicInteger`, `LongAdder`) ⇒ **opérations atomiques** sans verrou explicite.

### 3.5 Diagramme d’état C.V.L d’un thread 

![Diagramme d’état thread](/420-311/images/Diagramme_etat_CVL_thread .png)

* Nous avons déjà vu comment un thread pouvait être mis en sommeil ou mis en attente du verrou d’un objet. Nous allons ici faire le point sur les différents "états" dans lesquels peut se trouver un thread et sur les actions qui le font passer d’un état à un autre. Au départ, on crée un objet thread. Tant que l’on ne fait rien, il n’a aucune chance d’être exécuté.
* L’appel de start rend le thread disponible pour l’exécution. Il est alors considéré comme prêt. L’environnement peut faire passer un thread de l’état prêt à l’état "en cours d’exécution".
* On notera bien que cette transition ne peut pas être programmée explicitement. C’est le système qui décide (en utilisant éventuellement des requêtes formulées par le programme).
* Un thread en cours d’exécution peut subir différentes actions :
* Il peut être interrompu par l’environnement qui le ramène à l’état prêt. C’est ce qui se produit lorsque l’on doit donner la main à un autre thread (sur le même processeur). Cette transition peut être "programmée" en appelant la méthode yield de la classe Thread.
* Dans ce cas, rien ne dit que ce même thread ne sera pas à nouveau placé en exécution (par exemple, si aucun autre thread n’est prêt).
* Il peut être mis "en sommeil" par appel de la méthode sleep. Cet état est différent de l'état prêt, car un thread en sommeil ne peut pas être lancé par l’environnement. Lorsque le temps de sommeil est écoulé, l’environnement replace le thread dans l’état prêt (il ne sera relancé que lorsque les circonstances le permettront).
* Il peut être mis dans une liste d’attente associée à un objet (appel de wait). Dans ce cas, c’est l’appel de notifyAll qui le ramènera à l’état prêt.
* Il peut lancer une opération d’entrée-sortie et il se trouve alors bloqué tant que l’opération n’est pas terminée.
* Il peut s’achever.

### 3.6 La classe Java Thread 

| Constructeur                             | Description                                                      |
| ---------------------------------------- | ---------------------------------------------------------------- |
| `public Thread()`                        | Crée un nouveau `Thread` dont le nom est généré automatiquement. |
| `public Thread(Runnable t)`              | Utilise l’objet `t` (sa méthode `run`) comme tâche du `Thread`.  |
| `public Thread(Runnable t, String name)` | Précise l’objet `Runnable` **et** le nom du `Thread`.            |
| `public Thread(String name)`             | Crée un `Thread` avec le nom spécifié.                           |


| Méthode                                                         | Description / Remarque                                                                                            |
| --------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `start()` / `run()`                                             | Démarre le thread / point d’entrée du code. ([Oracle Docs][1])                                                    |
| `join()` / `join(long millis)` / `join(long millis, int nanos)` | Attend la fin du thread (avec ou sans délai). Lance `InterruptedException` si interrompu. ([Oracle Docs][1])      |
| `interrupt()`                                                   | Demande d’interruption (coopérative). N’arrête pas de force : le code doit vérifier et réagir. ([Oracle Docs][2]) |
| `isInterrupted()`                                               | Lit **sans réinitialiser** le drapeau d’interruption. ([Oracle Docs][3])                                          |
| `static interrupted()`                                          | Vérifie le **thread courant** et **réinitialise** le drapeau. ([Oracle Docs][3])                                  |
| `sleep(long millis[, int nanos])`                               | Endort le **thread courant** (peut lancer `InterruptedException`). ([Oracle Docs][1])                             |
| `currentThread()` / `getName()` / `setName(String)`             | Infos/confort (diagnostic, logs). ([Oracle Docs][1])                                                              |
| `setDaemon(boolean)` / `isDaemon()`                             | Marque le thread comme **daemon** (ne bloque pas la sortie du JVM). ([Oracle Docs][1])                            |
| `getState()` / `isAlive()`                                      | Diagnostic d’exécution. ([Oracle Docs][1])                                                                        |
| `yield()` / `onSpinWait()`                                      | Indices planificateur/optimisation (rarement nécessaires).                          |

> ℹ️ Notes utiles :
>
> * `destroy()` et `resume()` sont **déconseillées / obsolètes** depuis longtemps (dangereuses). On utilise plutôt des mécanismes sûrs (flags d’arrêt, `interrupt()`, queues, etc.).
> * `interrupted()` est **statique** et **réinitialise** le flag d’interruption. Pour tester sans le remettre à `false`, utiliser `isInterrupted()`.

#### Méthodes retirées ou à éviter (Java 23)

| Méthode                                | Statut                                                                                                                                                                                      |
| -------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `Thread.suspend()` / `Thread.resume()` | **Supprimées** en JDK 23 (déconseillées depuis 1.2 : sujettes aux deadlocks). Utiliser des mécanismes coopératifs (verrous/conditions, files, flags, interruption). ([bugs.openjdk.org][1]) |
| `Thread.stop(Throwable)`               | **Supprimée** plus tôt (JDK 11) ; dangereuse (libère les verrous de façon non sûre). ([bugs.openjdk.org][2])                                                                                |
| `Thread.destroy()`                     | **À ne pas utiliser** (déconseillée de longue date / non supportée). 



## 4) Priorités des threads  
En théorie, il est possible de modifier la priorité d’un thread à l’aide de la méthode setPriority à laquelle on fournit en argument une valeur entière comprise entre :

* MIN.PRIORITY (égale à 1) et MAX.PRIORITY (égale à 10).
* La priorité par défaut étant représentée par NORM.PRIORITY (égale à 5).
La priorité d’un thread est exploitée par l’environnement de la façon suivante :
* Lorsqu’il peut donner la main à un thread, il choisit celui de plus haute priorité parmi ceux qui sont dans l’état prêt. S’il y a plusieurs threads candidats, le thread choisi dépendra de l’environnement ;
* Si un thread plus prioritaire que le thread en cours d’exécution devient prêt, on lui donne la main (l’autre thread passant à l’état prêt).

Aucune garantie n’est fournie quant à la répartition équitable du temps d’exécution entre différents threads de même priorité. Comme nous l’avons déjà évoqué, suivant les environnements, on pourra avoir un partage de temps systématique entre ces threads ou, au contraire, voir un thread s’exécuter totalement avant qu’un autre n’obtienne la main.

On notera que d’éventuels appels de yield ne changent rien à ce problème. En revanche, comme nous l’avons vu, des appels judicieux de sleep peuvent permettre d’aboutir à une relative indépendance de l’environnement.

D’une manière générale, il n’est guère conseillé d’agir sur les priorités des threads dans des programmes qui se veulent portables.


## 5) Synchronisation et coordination

L’avantage des threads sur les processus est qu’ils appartiennent à un même programme. Ils peuvent donc éventuellement partager les mêmes objets. Cet avantage s’accompagne parfois de contraintes. En effet, dans certains cas, il faudra éviter que deux threads puissent accéder (presque) en même temps au même objet. Ou encore, un thread devra attendre qu’un autre ait achevé un certain travail sur un objet avant de pouvoir lui-même poursuivre son exécution.

Le premier problème est réglé par l’emploi de méthodes mutuellement exclusives qu’on appelle souvent, un peu abusivement, **méthodes synchronisées**, en faisant référence à la façon de les déclarer avec le mot-clé synchronized. Nous verrons que, dans certains cas, on pourra se contenter de **blocs synchronisés**.

Le second problème sera réglé par des mécanismes d’attente et de notification mis en œuvre à l’aide des méthodes wait et notify.


### 5.1 Méthodes synchronisées `synchronized` : verrou intrinsèque (moniteur)

Prenons un exemple simple de deux threads répétant indéfiniment les actions suivantes :
  * Incrémentation d’un nombre et calcul de son carré (premier thread),
  * Affichage du nombre et de son carré (second thread).

On voit que si le premier thread se trouve interrompu entre l’incrémentation et le calcul de carré, le second risque d’afficher le nouveau nombre et l’ancien carré.

Pour pallier cette difficulté, Java permet de déclarer des méthodes avec le mot-clé synchronized.

À un instant donné, une seule méthode ainsi déclarée peut être appelée pour un objet donné.

```java
class Compteur {
  private int v = 0;
  public synchronized void inc() { v++; }
  public synchronized int get() { return v; }
}
```

* Variante **bloc** (pour réduire la zone critique) :

```java
synchronized (verrou) {
  // section critique
}
```

* **Rappel** : le verrou est lié à **l’objet** (ou à la `Class` pour static).

#### Exemple :

Ici, si deux threads appellent incrementer() en même temps, l’un attendra que l’autre ait fini.
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
Le mot-clé synchronized permet de dire : 
> « Un seul thread à la fois peut exécuter ce bloc de code. »

### 5.2 Attente et notification 
* Il arrive que l’on ait besoin de coordonner l’exécution de threads, un thread devant attendre qu’un autre ait effectué une certaine tâche pour continuer son exécution.

* Là encore, Java offre un mécanisme basé sur l’objet et sur les méthodes synchronisées que nous venons d’étudier :

  * Une méthode synchronisée peut appeler la méthode wait de l’objet dont elle possède le verrou, ce qui a pour effet :
    * De rendre le verrou à l’environnement qui pourra, le cas échéant, l’attribuer à une autre méthode synchronisée,
    * De mettre "en attente" le thread correspondant ; plusieurs threads peuvent être en attente sur un même objet ; tant qu’un thread est en attente, l’environnement ne lui donne pas la main ;

  * Une méthode synchronisée peut appeler la méthode notifyAll d’un objet pour prévenir tous les threads en attente sur cet objet et leur donner la possibilité de s’exécuter (le mécanisme utilisé et le thread effectivement sélectionné pourront dépendre de l’environnement).

> **Remarque** :
> Il existe également une méthode `notify` qui se contente de prévenir un seul des threads en attente. Son utilisation est fortement déconseillée (le thread choisi dépendant de l’environnement).


#### `wait/notify/notifyAll` : coordination bas-niveau

* À n’utiliser **que dans** un bloc/méthode `synchronized` **sur le même objet**.
* `wait()` libère le verrou et met le thread en attente.
* `notifyAll()` réveille **tous** les threads en attente (préféré à `notify()`).

```java
import java.util.ArrayList;
import java.util.List;

public class FileTaches {

    private final List<String> taches = new ArrayList<>();
    private final int capaciteMax;

    public FileTaches(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    // Producteur : ajoute une tâche
    public void ajouter(String tache) throws InterruptedException {
        synchronized (taches) {
            // Tant que la file est pleine, on attend
            while (taches.size() == capaciteMax) {
                taches.wait();
            }
            taches.add(tache);
            // On réveille les consommateurs potentiels
            taches.notifyAll();
        }
    }

    // Consommateur : retire une tâche
    public String retirer() throws InterruptedException {
        synchronized (taches) {
            // Tant qu'il n'y a rien, on attend
            while (taches.isEmpty()) {
                taches.wait();
            }
            String t = taches.remove(0);
            // On réveille les producteurs potentiels (qui attendaient une place)
            taches.notifyAll();
            return t;
        }
    }
}
```
#### Points clés :

- On utilise toujours while et pas if autour de wait() :
  - pour se protéger des réveils intempestifs (spurious wakeups),
  - pour re-vérifier la condition après le réveil (taille de la liste).
- On synchronise sur le même objet (taches) dans les deux méthodes.
- wait() :
  - libère le verrou sur taches,
  - met le thread en attente,
  - le thread se réveille quand quelqu’un fait notify() / notifyAll() sur taches et qu’il peut reprendre le verrou.

### 5.3 Alternatives modernes (recommandé)

* **Collections concurrentes** : `ConcurrentHashMap`, `CopyOnWriteArrayList`.
* **Queues bloquantes** : `BlockingQueue` (`Array/LinkedBlockingQueue`, `SynchronousQueue`) pour **producteur/consommateur**.
* **Synchronisateurs** : `CountDownLatch`, `CyclicBarrier`, `Phaser`, `Semaphore`.

#### Producteurs/Consommateurs simplifié

```java
public class FileTaches {
    private final List<String> taches = new ArrayList<>();

    public synchronized void ajouterTache(String t) {
        taches.add(t);
    }

    public synchronized String retirerTache() {
        if (taches.isEmpty()) {
            return null;
        }
        return taches.remove(0);
    }
}
```
Thread consommateur :

```java
public class Travailleur implements Runnable {

    private final FileTaches file;

    public Travailleur(FileTaches file) {
        this.file = file;
    }

    @Override
    public void run() {
        while (true) {
            String tache = file.retirerTache();
            if (tache == null) {
                try {
                    Thread.sleep(50); // rien à faire pour l’instant
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                continue;
            }

            System.out.println("Traitement de : " + tache);
            // … traitement + sleep
        }
    }
}
```

#### Sémaphore (`java.util.concurrent.Semaphore`)

* Un sémaphore est un objet qui contrôle l'accès à certaines ressources. 
* Un thread qui souhaite accéder à cette ressource doit demander une autorisation à ce sémaphore, qui peut accorder l'accès ou pas. 
* En Java, les sémaphores possèdent un certain nombre d'autorisations, fixé à la construction du sémaphore. 
* Ce nombre marque la limite du nombre de threads qui peut accéder simultanément aux ressources gardées par ce sémaphore.
* La classe Sémaphore présente deux types de méthodes : celles qui permettent de gérer les autorisations, et celles qui permettent d'interroger combien de threads sont éventuellement en attente d'une autorisation.
* Les Méthodes **`acquire()`** et **`acquire(int permits)`** : demande une ou plusieurs autorisations. 
* Ces deux méthodes sont bloquantes : elles ne rendent la main que lorsque le nombre d'autorisations demandé est disponible. 
* Elles lèvent une exception InterruptedException si le thread est interrompu.
* Les méthodes **`acquireUninterruptibly()`** et **`acquireUninterruptibly(int permits)`** : ces deux méthodes sont analogues aux précédentes, sauf qu'elles ne lèvent pas d'exception. 
* Si le thread est interrompu, il continue à attendre une autorisation. Lorsque cette méthode rend la main, le statut interrupted du thread est à true.
**`tryAcquire()`** et  **`tryAcquire(int permits)`** : demande une ou plusieurs autorisations. 
* Ces deux méthodes rendent immédiatement la main, et retournent true ou false, suivant que le bon nombre de permis a été octroyé.
* Au lieu de rendre la main immédiatement, elles peuvent attendre le temps passé en paramètre que des permis se libèrent.
*  **`release()`** et **`release(int permits)`** : rends une autorisation, ou le nombre d'autorisations passées en paramètre.
*  **`availablePermits()`** : retourne le nombre d'autorisations disponibles pour ce sémaphore.
*  Les termes suivants sont couramment utilisés en cryptographie et leurs définitions.


* **Contrôle d’accès** à N ressources identiques.

```java
import java.util.concurrent.Semaphore;

class PoolRessources {
  private final Semaphore sem = new Semaphore(3); // 3 accès simultanés
  void utiliser() throws InterruptedException {
    sem.acquire();
    try { /* section utilisant la ressource */ }
    finally { sem.release(); }
  }
}
```

* `tryAcquire()` pour éviter les blocages, `acquireUninterruptibly()` pour ignorer l’interruption (rarement conseillé).

### 5.4 Verrous explicites (`ReentrantLock`)

* Avantages : `tryLock()`, **plusieurs conditions** (`newCondition()`), diagnostic équitable.

```java
import java.util.concurrent.locks.*;

class CompteurLock {
  private int v = 0;
  private final ReentrantLock lock = new ReentrantLock();
  int incEtGet() {
    lock.lock();
    try { return ++v; }
    finally { lock.unlock(); }
  }
}
```

## 6) Interruption et arrêt **gracieux**

### 6.1 Patron d’interruption

```java
class TacheLongue implements Runnable {
  @Override public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      try {
        // travail…
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // rétablir le flag et sortir
      }
    }
  }
}
```

### 6.2 Arrêter un pool proprement

```java
pool.shutdown();                       // plus de nouvelles tâches
if (!pool.awaitTermination(5, SECONDS)) {
  pool.shutdownNow();                  // interrompre les tâches en cours
}
```

## 7) Deadlocks : comprendre, reproduire, corriger

### 7.1 Exemple de deadlock

```java
public class Deadlock {
  static final Object A = new Object();
  static final Object B = new Object();

  public static void main(String[] args) throws Exception {
    Thread t1 = new Thread(() -> {
      synchronized (A) {
        dormir(100);
        synchronized (B) { /* ... */ }
      }
    }, "T1");

    Thread t2 = new Thread(() -> {
      synchronized (B) {
        dormir(100);
        synchronized (A) { /* ... */ }
      }
    }, "T2");

    t1.start(); t2.start();
    t1.join(); t2.join();
  }

  static void dormir(long ms) { try { Thread.sleep(ms); } catch (InterruptedException ignored) {} }
}
```

→ t1 **garde A** et attend B, t2 **garde B** et attend A : **boucle d’attente**.

### 7.2 Stratégies d’évitement

* **Ordonnancement global** des verrous : **toujours les acquérir dans le même ordre**.

```java
void travail(Object first, Object second) {
  Object a = first.hashCode() < second.hashCode() ? first : second;
  Object b = (a == first) ? second : first;
  synchronized (a) { synchronized (b) { /* section critique */ } }
}
```

* `tryLock(timeout)` + **backoff** (avec `ReentrantLock`).
* **Réduire la granularité** et la **durée** des sections critiques.

## 8) Bonnes pratiques (robustesse, performance, portabilité)

* **Immuabilité d’abord** : partager des objets immuables évite des verrous.
* **Confinement de thread** : chaque thread possède son état (ou `ThreadLocal`).
* **Toujours limiter la section critique** au strict nécessaire.
* **Éviter `wait/notify` bruts** si une **`BlockingQueue`** ou un synchronisateur convient.
* **Timeouts partout** : `get(timeout)`, `orTimeout`, `tryLock(timeout)`.
* **Journalisation** et métriques (débit, latences, longueurs de files).
* **Ne pas compter sur les priorités** de threads pour la logique métier.
* **Tester sous charge** (courses, contention, interblocages).
* **Séparer CPU-bound / I/O-bound** en pools dédiés (évite la famine).

## 9) Exemples à tester

### 9.1 Mesurer une course (race) puis corriger

```java
// Non thread-safe
class Counter { int v=0; void inc(){ v++; } }
public class Race {
  public static void main(String[] a) throws Exception {
    var c = new Counter();
    var t1 = new Thread(() -> { for(int i=0;i<1_000_000;i++) c.inc(); });
    var t2 = new Thread(() -> { for(int i=0;i<1_000_000;i++) c.inc(); });
    t1.start(); 
    t2.start(); 
    t1.join(); 
    t2.join();
    System.out.println("Attendu=2000000, Obtenu="+c.v);
  }
}
```

```java
// Correction atomique
import java.util.concurrent.atomic.AtomicInteger;
public class Atomic {
  public static void main(String[] a) throws Exception {
    var v = new AtomicInteger();
    var t1 = new Thread(() -> { for(int i=0;i<1_000_000;i++) v.incrementAndGet(); });
    var t2 = new Thread(() -> { for(int i=0;i<1_000_000;i++) v.incrementAndGet(); });
    t1.start(); 
    t2.start(); 
    t1.join(); 
    t2.join();
    System.out.println("Résultat="+v.get());
  }
}
```

### 9.2 `invokeAny` / `invokeAll` (meilleur et tous les résultats)

```java
import java.util.*;
import java.util.concurrent.*;

public class Invoke {
  public static void main(String[] args) throws Exception {
    ExecutorService pool = Executors.newFixedThreadPool(4);
    try {
      List<Callable<String>> taches = List.of(
        () -> { Thread.sleep(300); return "A"; },
        () -> { Thread.sleep(100); return "B"; },
        () -> { Thread.sleep(200); return "C"; }
      );
      String fastest = pool.invokeAny(taches); // le plus rapide
      System.out.println("Plus rapide = " + fastest);
      for (Future<String> f : pool.invokeAll(taches)) 
        System.out.println(f.get());
    } finally { 
      pool.shutdown(); 
    }
  }
}
```

### 9.3 Sémaphore pour limiter l’accès concurrent à une ressource

```java
import java.util.concurrent.Semaphore;

public class Limiteur {
  static final Semaphore SEM = new Semaphore(2); // 2 en parallèle

  static void tache(String nom) {
    try {
      if (SEM.tryAcquire()) {
        System.out.println(nom+" entre");
        Thread.sleep(200);
      } else {
        System.out.println(nom+" refuse (limite atteinte)");
      }
    } catch (InterruptedException e) { 
      Thread.currentThread().interrupt(); 
    }
    finally { 
      if (SEM.availablePermits()<2) SEM.release(); 
    }
  }

  public static void main(String[] args) {
    for (int i=0;i<5;i++) 
      new Thread(() -> tache(Thread.currentThread().getName())).start();
  }
}
```

## 10) Résumé

* **Concevoir** le parallélisme : CPU-bound ≠ I/O-bound, **taillez** vos pools.
* **Protéger** l’état partagé : immuabilité → atomiques → `synchronized`/locks.
* **Coordonner** avec `BlockingQueue`, `CountDownLatch`, `Semaphore`, plutôt que `wait/notify` brut.
* **Gérer l’arrêt** : `interrupt` + `shutdown`/`awaitTermination`.
* **Éviter les deadlocks** : ordre de verrous, `tryLock(timeout)`, petites sections.
* **Observer** : logs, métriques, profils de contention, noms de threads (`ThreadFactory`).
* **Tester** sous charge et avec timeouts.

## Ressources

[Oracle Docs](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/Thread.html])                                   