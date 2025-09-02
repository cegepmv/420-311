+++
draft = false
title = 'Les structures de données (Java)'
weight = 2.1
+++

## <ins> Notion de structure de données</ins>

Ⓜ️ Le principe de base d'une structure de données, c'est de stocker des éléments auxquels le programmeur veut pouvoir accéder plus tard. On appelle les différentes utilisations possibles de la structure de données des opérations.

## <ins> Les structures de données en Java 
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

Vous pourrez généralement vous contenter de connaître les fonctionnalités supplémentaires qu’offre chacune des classes LinkedList, ArrayList, Vector, HashSet, TreeSet, PriorityQueue et ArrayDeque. Mais, dans certains cas, vous devrez avoir quelques notions sur l’architecture d’interfaces employée par les concepteurs de la librairie. Elle se présente comme suit :

Collection

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