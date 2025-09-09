+++
draft = false
title = 'Les structures de données en Java '
weight = 22
+++

## <ins> 
Le langage Java a élargi et harmonisé la bibliothèque de classes utilitaires (java.util). 
On y trouve désormais des classes permettant de manipuler les principales structures de données, c’est-à-dire les    vecteurs dynamiques, les ensembles, les listes chaînées, les queues et les tables associatives.

![Java collection hierarchy](/420-311/images/Collection_Hierarchy.jpg)

![Java choix collection diagram](/420-311/images/choix_sdd.png)

### Structure générale des collections en Java 
Une collection représente un groupe d'objets, connu par ses éléments. Certaines collections acceptent les doublons, d'autres pas. Certaines sont ordonnées, d'autres pas. 

![Java choix collection diagram](/420-311/images/Collection_Hierarchy_Java.jpg)

### Interface Collection 
Depuis la version 1.6 de Java, il y a un changement dans la structure des collections. Il y a eu l’ajout du package `java.util.concurrent`

![Java choix collection diagram](/420-311/images/Collection_Interfaces.jpg)

#### Exemples : 

* Besoin d’accès rapide par clé ? → HashMap.
* Besoin de garder l’ordre trié ? → Arbre.
* Besoin d’un traitement dans l’ordre d’arrivée ? → File.

Vous pourrez généralement vous contenter de connaître les fonctionnalités supplémentaires qu’offre chacune des classes LinkedList, ArrayList, Vector, HashSet, TreeSet, PriorityQueue et ArrayDeque. Mais, dans certains cas, vous devrez avoir quelques notions sur l’architecture d’interfaces employée par les concepteurs de la librairie. Elle se présente comme suit :

**Collection**

* List implémentée par LinkedList, ArrayList et Vector
* Set implémentée par HashSet
    * SortedSet implémentée par TreeSet
        * NavigableSet implémentée par TreeSet (Java 6)
* Queue (JDK 5.0) implémentée par LinkedList, PriorityQueue
    * Deque (Java 6) implémentée par ArrayDeque, LinkedList

### L'interface Iterable
![Java choix collection diagram](/420-311/images/Iterator_interface.jpg)

```java
public interface <E> Collection extends Iterable <E>
```
`Collection` est l'interface racine dans la hiérarchie des collections. Une `collection` représente un groupe d'objets, connu sous le nom de ses éléments. Certaines collections :
* Permettent de dupliquer les éléments et d'autres pas.
* Elles sont ordonnées et d'autres pas.

Le JDK ne fournit pas directement les implémentations de cette interface : il fournit des implémentations de sous-interfaces plus spécifiques telles que Set et List.

### L'interface List

![Java choix collection diagram](/420-311/images/List_interface.jpg)

```java
public interface List<E> extends Collection<E>
```

Une liste est une collection ordonnée (également connu sous le nom de séquence).

* L'utilisateur de cette interface à un contrôle précis sur l'endroit où est inséré chaque élément dans la liste.
* L'utilisateur peut accéder aux éléments par leur index (position dans la liste), et rechercher des éléments dans la liste. Les listes permettent généralement les éléments dupliqués.

Les listes permettent de multiples éléments nuls. Il n'est pas inconcevable que quelqu'un puisse vouloir mettre en place une liste qui interdit les doublons, par exemple : en lançant des exceptions d'exécution lorsque l'utilisateur tente de les insérer, cet usage est rare.

![Java choix collection diagram](/420-311/images/List_implementations.jpg)

#### Les listes chaînées - classe LinkedList 
La classe LinkedList permet de manipuler des listes dites "doublement chaînées". À chaque élément de la collection, on associe (de façon totalement transparente pour le programmeur) deux informations supplémentaires qui ne sont autres que les références à l’élément précédent et au suivant. Une telle collection peut ainsi être parcourue à l’aide d’un itérateur bidirectionnel de type ListIterator.

Le grand avantage d’une telle structure est de permettre des ajouts ou des suppressions à une position donnée avec une efficacité en O (1) (ceci grâce à un simple jeu de modification de références).

En revanche, l’accès à un élément en fonction de sa valeur ou de sa position dans la liste sera peu efficace puisqu’il nécessitera obligatoirement de parcourir une partie de la liste. L’efficacité sera donc en moyenne en O (N).

**Exemple**
```java
    LinkedList nombres = new LinkedList<>(); // => // LinkedList<Integer> nombres = new LinkedList<>();
    nombres.addFirst(10);
    nombres.addLast(20);
    nombres.addLast(30);
    nombres.addLast(40);
    nombres.addFirst(50);
    nombres.removeLast();
    nombres.removeFirst();
    System.out.println(nombres);
    System.out.println(nombres.size());
    System.out.println(nombres.contains(20));
    System.out.println(nombres.indexOf(20));
    var tab = nombres.toArray();
    System.out.println(Arrays.toString(tab));

    //Iterating LinkedList
    Iterator<Integer> iterator = nombres.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
```


---

### 📖 Exemples

#### 1. Tableau (`Array`)

```java
public class ExempleTableau {
    public static void main(String[] args) {
        int[] nombres = {10, 20, 30, 40};

        // Accès par index (O(1))
        System.out.println("Premier élément : " + nombres[0]);

        // Parcours (O(n))
        for (int n : nombres) {
            System.out.println(n);
        }
    }
}
```

#### 2. Liste (`ArrayList`)

```java
import java.util.*;

public class ExempleArrayList {
    public static void main(String[] args) {
        List<String> noms = new ArrayList<>();

        noms.add("Alice");
        noms.add("Bob");
        noms.add("Charlie");

        // Accès par index
        System.out.println("Deuxième nom : " + noms.get(1));

        // Suppression
        noms.remove("Alice");

        System.out.println("Liste : " + noms);
    }
}
```

---

#### 3. Pile (`Stack`)

```java
import java.util.*;

public class ExemplePile {
    public static void main(String[] args) {
        Stack<Integer> pile = new Stack<>();

        pile.push(10);
        pile.push(20);
        pile.push(30);

        System.out.println("Sommet : " + pile.peek()); // 30
        System.out.println("Pop : " + pile.pop());     // enlève 30
    }
}
```

---

#### 4. File (`Queue`)

```java
import java.util.*;

public class ExempleFile {
    public static void main(String[] args) {
        Queue<String> file = new LinkedList<>();

        file.add("Alice");
        file.add("Bob");
        file.add("Charlie");

        System.out.println("Premier : " + file.peek()); // Alice
        System.out.println("Dequeue : " + file.poll()); // enlève Alice
    }
}
```

---

#### 5. Ensemble (`HashSet`)

```java
import java.util.*;

public class ExempleHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Alice");
        set.add("Bob");
        set.add("Alice"); // ignoré car doublon

        System.out.println("Contient Bob ? " + set.contains("Bob"));
        System.out.println("Ensemble : " + set);
    }
}
```



#### 6. Table de hachage (`HashMap`)

```java
import java.util.*;

public class ExempleHashMap {
    public static void main(String[] args) {
        Map<String, Integer> notes = new HashMap<>();

        notes.put("Alice", 85);
        notes.put("Bob", 90);

        System.out.println("Note de Bob : " + notes.get("Bob"));

        // Parcours des clés/valeurs
        for (Map.Entry<String, Integer> e : notes.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }
}
```


#### 7. Arbre (`TreeMap`)

```java
import java.util.*;

public class ExempleTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> arbre = new TreeMap<>();

        arbre.put(3, "Charlie");
        arbre.put(1, "Alice");
        arbre.put(2, "Bob");

        // Les clés sont triées automatiquement
        System.out.println("Arbre trié : " + arbre);

        System.out.println("Premier : " + arbre.firstEntry());
        System.out.println("Dernier : " + arbre.lastEntry());
    }
}
```

#### 8. Tas (Heap) (`PriorityQueue`)

```java
import java.util.*;

public class ExempleTas {
    public static void main(String[] args) {
        PriorityQueue<Integer> tas = new PriorityQueue<>();

        tas.add(30);
        tas.add(10);
        tas.add(20);

        // Extrait toujours le plus petit élément
        System.out.println("Min : " + tas.poll()); // 10
        System.out.println("Min suivant : " + tas.poll()); // 20
    }
}
```

---

# 📌 Résumé

* **Tableau** : accès rapide par index, taille fixe.
* **ArrayList** : tableau dynamique.
* **Stack** : pile (LIFO).
* **Queue** : file (FIFO).
* **HashSet** : ensemble sans doublons.
* **HashMap** : table clé/valeur, accès O(1).
* **TreeMap** : table clé/valeur triée.
* **PriorityQueue** : tas binaire (heap), priorité minimale d’abord.



