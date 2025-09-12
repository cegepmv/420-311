+++
draft = false
title = 'Les structures de données en Java '
weight = 22
+++


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

### 🔹 Les listes chaînées - classe LinkedList 

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

### 🔹 ArrayDeque

File à deux extrémités (FIFO ou LIFO).
* **Exemple** : File d’impression.

```java
import java.util.ArrayDeque;

public class ExempleArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<String> file = new ArrayDeque<>();
        file.add("Doc1");
        file.add("Doc2");
        file.add("Doc3");

        System.out.println("Déqueue : " + file.poll());
    }
}
```
**Complexité :**
* Insertion/suppression en tête ou fin : O(1).
* Accès index : O(n).
* Mémoire : O(n).

### 🔹 **Vector**

Est un tableau dynamique comme `ArrayList`, mais **synchronisé** (donc plus sûr en environnement multithread).
* **Exemple** : Une liste partagée entre plusieurs threads où la sécurité des accès est importante.
* **Complexité** :

  * Accès par index : **O(1)**.
  * Insertion fin : **O(1) amorti** (redimensionnement si plein).
  * Insertion/suppression au milieu : **O(n)**.
  * Mémoire : **O(n)** (+ espace supplémentaire pour redimensionnement).

```java
import java.util.Vector;

public class ExempleVector {
    public static void main(String[] args) {
        Vector<String> vecteur = new Vector<>();
        vecteur.add("Alice");
        vecteur.add("Bob");
        vecteur.add("Charlie");

        System.out.println("Élément à l’index 1 : " + vecteur.get(1));

        vecteur.remove("Alice");
        System.out.println("Après suppression : " + vecteur);
    }
}
```
**Complexité :**
* Accès par index : O(1).
* Insertion fin : O(1) amorti (redimensionnement si plein).
* Insertion/suppression au milieu : O(n).
* Mémoire : O(n) (+ espace supplémentaire pour redimensionnement).


### 🔹 Stack

Structure LIFO (dernier entré, premier sorti).
* **Exemple** : Pile d’assiettes.

```java
import java.util.Stack;

public class ExempleStack {
    public static void main(String[] args) {
        Stack<String> pile = new Stack<>();
        pile.push("A");
        pile.push("B");
        pile.push("C");

        System.out.println("Pop : " + pile.pop());
        System.out.println("Sommet : " + pile.peek());
    }
}
```
**Complexité** :
* Ajout : O(1).
* Suppression : O(1).
* lecture sommet : O(1).
* Mémoire : O(n).

### Les ensembles (Interface Set) 

Deux classes principales permettent d’implémenter la notion d’**ensemble** en Java : **HashSet** et **TreeSet**.

#### Qu’est-ce qu’un ensemble ?

Théoriquement, un **ensemble** est une **collection d’éléments uniques**, où :

* aucun élément ne peut apparaître plusieurs fois,
* l’ordre des éléments n’a pas d’importance.

Ainsi, à chaque fois qu’on insère un nouvel élément dans un **HashSet** ou un **TreeSet**, Java vérifie automatiquement que l’élément n’existe pas déjà.

#### L’importance de `equals`, `hashCode` et `compareTo`

* Pour des types simples comme `String`, `File` ou les types numériques (`Integer`, `Double`...), tout fonctionne naturellement : l’égalité est déjà bien définie.
* En revanche, pour des **objets définis par l’utilisateur**, il est souvent nécessaire de **redéfinir** correctement :

  * la méthode `equals()` (et `hashCode()`) → pour les ensembles basés sur le hachage,
  * la méthode `compareTo()` (ou fournir un `Comparator`) → pour les ensembles basés sur les arbres.

👉 Sans cette redéfinition, deux objets représentant la même valeur mais ayant des références différentes seront considérés comme distincts.

#### Pourquoi un ordre interne ?

Même si, en théorie, un ensemble est "non ordonné", les concepteurs des collections Java ont dû organiser les données pour rendre les **tests d’appartenance** (ex. `set.contains(x)`) efficaces.
Sinon, il faudrait parcourir tous les éléments un par un, ce qui coûterait **O(n)**.

Deux stratégies ont donc été retenues :

### 🔹 HashSet

* **Définition** : Ensemble non ordonné, sans doublons.
   * Utilise une **fonction de hachage** pour répartir les éléments dans des cases.
   * Avantage : test d’appartenance, insertion et suppression très rapides → **O(1)** en moyenne.
   * Inconvénient : les éléments n’ont **aucun ordre visible**.
* **Exemple** : Liste d’étudiants inscrits (pas de doublons).

```java
import java.util.HashSet;

public class ExempleHashSet {
    public static void main(String[] args) {
        HashSet<String> etudiants = new HashSet<>();
        etudiants.add("Alice");
        etudiants.add("Bob");
        etudiants.add("Alice"); // ignoré

        System.out.println("Étudiants : " + etudiants);
    }
}
```
* **Complexité** :

    * Recherche : O(1).
    * Insertion : O(1).
    * Suppression : O(1).
    * Mémoire : O(n).

### 🔹 TreeSet

🌼 La classe TreeSet propose une autre organisation utilisant un "arbre binaire" (**arbre binaire de recherche équilibré**), lequel permet d’ordonner totalement les éléments. On y utilise, cette fois, la relation d’ordre naturel induite par la méthode `compareTo` des objets ou par un comparateur (qu’on peut fournir à la construction de l’ensemble).

🌼 Dans ces conditions, la recherche dans cet arbre d’un élément de valeur donnée est généralement moins rapide que dans une table de hachage, mais plus rapide qu’une recherche séquentielle. On peut montrer que son efficacité est en **O(log n)**. Il est légèrement plus lent qu’un HashSet.

🌼 Par ailleurs, l’utilisation d’un arbre binaire permet de disposer en permanence d’un ensemble totalement ordonné (trié). On notera d’ailleurs que la classe TreeSet dispose de deux méthodes spécifiques first et last fournissant respectivement le premier et le dernier élément de l’ensemble.

* **Exemple** : Classement des notes.

```java
import java.util.TreeSet;

public class ExempleTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> notes = new TreeSet<>();
        notes.add(85);
        notes.add(90);
        notes.add(70);

        System.out.println("Notes triées : " + notes);
    }
}
```
* **Complexité** :

    * Recherche : O(log n).
    * Insertion : O(log n).
    * Suppression : O(log n).
    * Mémoire : O(n).

##### Comparaison

* **HashSet** : rapide, sans ordre → parfait pour vérifier l’appartenance rapidement.
* **TreeSet** : plus lent, mais les éléments sont triés → utile si on veut parcourir l’ensemble dans un ordre précis.

### Dictionnaire et table associative (l'interface Map)
![l'interface Map](/420-311/images/interfaceMap.jpg)

🌼 Depuis le JDK 5.0, les tables associatives sont génériques, au même titre que les collections, mais elles sont définies par deux paramètres de type (celui des clés, noté généralement K, celui des valeurs, noté généralement V) au lieu d’un.

#### Implémentation des Map 
🌼 Comme pour les ensembles, l’intérêt des tables associatives est de pouvoir y retrouver rapidement une clé donnée pour en obtenir l’information associée. On va donc tout naturellement retrouver les deux types d’organisation rencontrés pour les ensembles :
* 👍 Table de hachage : classe HashMap,
* 👍 Arbre binaire : classe TreeMap.
🌼 Dans les deux cas, seule la clé sera utilisée pour ordonnancer les informations.
🌼 Dans le premier cas, on se servira du code de hachage des objets formant les clés ; dans le second cas, on se servira de la relation d’ordre induite par compareTo ou par un comparateur fixé à la construction.

🌼 L’accès à un élément d’un HashMap sera en O (1) tandis que celle à un élément d’un TreeMap sera en O (Log N).

🌼 En contrepartie de leur accès moins rapide, les TreeMap seront (comme les TreeSet) ordonnés en permanence suivant leurs clés.

#### Présentation générale des classes HashMap et TreeMap 
🌼 Comme nous l’avons signalé, les classes HashMap et TreeMap n’implémentent plus l’interface Collection, mais une autre interface nommée Map. Ceci provient essentiellement du fait que leurs éléments ne sont plus à proprement parler des objets, mais des "paires" d’objets c’est-à-dire une association entre deux objets.

#### 👍 Ajout d’information
🌼 La plupart des constructeurs créent une table vide. Pour ajouter une clé à une table, on utilise la méthode put à laquelle on fournit la clé et la valeur associée ; par exemple, si K désigne le type des clés et V celui des valeurs :
```java
/* création d’une table vide */
HashMap <K, V> m = new HashMap <K, V> () ;
/* ajoute à m, un élément associant la clé "m" (String) à la valeur 3 (Integer) */ 
m.put ("m", 3) ;
```
🌼 Si la clé fournie à put existe déjà, la valeur associée remplacera l’ancienne (une clé donnée ne pouvant figurer qu’une seule fois dans une table). D’ailleurs, put fournit en retour soit l’ancienne valeur si la clé existait déjà, soit nul.

🌼 Notez que, comme pour les autres collections, les clés et les valeurs doivent être des objets. Il n’est théoriquement pas nécessaire que toutes les clés soient de même type, pas plus que les éléments. En pratique, ce sera presque toujours le cas pour des questions évidentes de facilité d’exploitation de la table.

#### 👍 Recherche d’information
🌼 On obtient la valeur associée à une clé donnée à l’aide de la méthode get, laquelle fournit nulle si la clé cherchée n’est pas présente (V représente le type de la valeur) :
```java
V o = get ("x") ; // fournit la valeur associée à la clé "x" //

if (o == null) System.out.println ("Aucune valeur associée à la clé x") ;
```
🌼 L’efficacité de cette recherche est en O (1) pour HashMap et en O(Log N) pour TreeMap.

🌼 La méthode containsKey permet de savoir si une clé donnée est présente avec la même efficacité.

#### 👍 Suppression d’information
🌼 On peut supprimer un élément d’une table en utilisant la méthode remove, laquelle fournit en retour l’ancienne valeur associée si la clé existe ou la valeur null dans le cas contraire :
```java
V val = remove (cle) ;	// supprime l’élément (clé + valeur) de clé "x" if (val != null)
System.out.println ("On a supprimé l’élément de clé " + cle + " et de valeur" + val);
```

### 🔹 HashMap
Associe une clé à une valeur, accès rapide.
* **Exemple** : Dictionnaire (mot → définition).

```java
import java.util.HashMap;

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
**Complexité** :
* Recherche : O(1) (moyenne), O(n) (pire cas si collisions).
* Insertion : O(1).* 
* Suppression : O(1).
* Mémoire : O(n) + surcharge pour les tables de hachage.


### 🔹 TreeMap
Map triée par clés.
* **Exemple** : Carnet d’adresses trié par nom.

```java
import java.util.TreeMap;

public class ExempleTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> carnet = new TreeMap<>();
        carnet.put("Charlie", 555123);
        carnet.put("Alice", 555789);
        carnet.put("Bob", 555456);

        System.out.println("Carnet trié : " + carnet);
        
        System.out.println("Premier : " + arbre.firstEntry());
        System.out.println("Dernier : " + arbre.lastEntry());
    }
}
```
**Complexité** :
* Recherche : O(log n).
* Insertion : O(log n).
* Suppression : O(log n).
* Mémoire : O(n).

### 🔹 LinkedHashMap
Map qui garde l’ordre d’insertion.
* **Exemple** : Historique de navigation.

```java
import java.util.LinkedHashMap;

public class ExempleLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> historique = new LinkedHashMap<>();
        historique.put(1, "Google");
        historique.put(2, "YouTube");
        historique.put(3, "Wikipedia");

        System.out.println("Historique : " + historique);
    }
}
```
**Complexité** :
* Recherche : O(log n).
* Insertion : O(log n).
* Suppression : O(log n).
* Mémoire : O(n).






### 🔹 LinkedHashSet

* **Définition** : Ensemble qui garde l’ordre d’insertion.
* **Exemple** : Liste d’achats sans doublons.

```java
import java.util.LinkedHashSet;

public class ExempleLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> courses = new LinkedHashSet<>();
        courses.add("Lait");
        courses.add("Pain");
        courses.add("Lait"); // ignoré
        courses.add("Oeufs");

        System.out.println("Liste d’achats : " + courses);
    }
}
```





## Tableau des complexités

| Structure         | Accès      | Insertion       | Suppression   | Mémoire |
| ----------------- | ---------- | --------------- | ------------- | ------- |
| **HashMap**       | O(1)       | O(1)            | O(1)          | O(n)    |
| **TreeMap**       | O(log n)   | O(log n)        | O(log n)      | O(n)    |
| **LinkedHashMap** | O(1)       | O(1)            | O(1)          | O(n)    |
| **LinkedList**    | O(n)       | O(1) tête/fin   | O(1) tête/fin | O(n)    |
| **ArrayList**     | O(1) index | O(1) fin amorti | O(n)          | O(n)    |
| **Vector**        | O(1) index | O(1) fin amorti | O(n)          | O(n)    |
| **Stack**         | O(n) accès | O(1) push       | O(1) pop      | O(n)    |
| **ArrayDeque**    | O(n) accès | O(1) tête/fin   | O(1) tête/fin | O(n)    |
| **HashSet**       | O(1)       | O(1)            | O(1)          | O(n)    |
| **TreeSet**       | O(log n)   | O(log n)        | O(log n)      | O(n)    |
| **LinkedHashSet** | O(1)       | O(1)            | O(1)          | O(n)    |







### 🔹 Tas (Heap) (`PriorityQueue`)

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


