+++
draft = false
title = 'Les structures de données'
weight = 21
+++

## Notion de structure de données</ins>

Ⓜ️ Le principe de base d'une structure de données, c'est de stocker des éléments auxquels le programmeur veut pouvoir accéder plus tard. On appelle les différentes utilisations possibles de la structure de données des opérations.

## Classification des structures de données

### 🔹 Structures de base

#### <ins> **Tableau (array)** : 
Une collection d’éléments de même type stockés en mémoire de façon contiguë.
Chaque élément est accessible par son index.

#### Schéma
```
Index :  0    1    2    3
Valeur: [10] [20] [30] [40]
```


#### Complexité

* Accès direct : **O(1)**
* Recherche d’une valeur : **O(n)**
* Insertion/suppression : **O(n)** (décalage nécessaire)

#### Avantages

* Accès rapide par index.
* Simple à utiliser.

#### Inconvénients

* Taille fixe (souvent).
* Insertion/suppression coûteuses.


#### Exemple réel

Les sièges d’un avion numérotés → on sait directement où est le siège 25B.

#### <ins> **Liste chaînée (linked list)** : 

Une séquence de **nœuds** où chaque nœud contient une valeur et une référence vers le suivant (et parfois vers le précédent → liste doublement chaînée).

#### Schéma

```
Tête → [10|•] → [20|•] → [30|null]
```

![Single and Doubly Linked List](/420-311/images/LinkedListDigram.jpg)

Liste simplement chaînée et liste doublement chaînée 

![Liste simplement chaînée circulaire](/420-311/images/CirclySinglyLinkedList.webp)
Liste simplement chaînée circulaire

#### Complexité

* Insertion/suppression en tête : **O(1)**

    Insertion : 
    - à la fin O(1)
    - au début O(1)
    - au milieu O(n)
    
    suppression : 
    - au début O(1)
    - à la fin O(n) / O(1) dans les Listes doublement chaînées.
    - au milieu O(n)
* Accès à un élément : **O(n)**

#### Avantages

* Taille dynamique.
* Insertion/suppression rapides en tête/fin.

#### Inconvénients

* Accès séquentiel (lent).
* Plus de mémoire (pointeurs).

#### Exemple réel

Un collier de perles où chaque perle est attachée à la suivante.


### 🔹 Structures linéaires spécialisées
#### <ins> **Pile (Stack)**

Structure **LIFO** (Last In, First Out).
Le dernier élément inséré est le premier retiré.

#### Schéma

```
Push(10) → Push(20) → Push(30)
Pile: [30] [20] [10]
Pop() → 30
```

![Pile](/420-311/images/stack.webp)
stack

#### Opérations

* `push(x)` : ajouter en haut.
* `pop()` : retirer le dernier.
* `peek()` : lire le dernier sans le retirer.

#### Complexité

* Insertion/retrait : **O(1)**

#### Exemple réel

Pile d’assiettes à laver à la main.


#### <ins> **File (Queue)**

Structure **FIFO** (First In, First Out).
Le premier élément inséré est le premier retiré.

#### Schéma

```
Enqueue(10) → Enqueue(20) → Enqueue(30)
File: [10] [20] [30]
Dequeue() → 10
```

![File](/420-311/images/Data_Queue.png)
File

#### Opérations

* `enqueue(x)` : ajouter à la fin.
* `dequeue()` : retirer au début.
* `peek()` : lire le premier sans le retirer.

#### Complexité

* Insertion/retrait : **O(1)**

#### Exemple réel

File d’attente à la caisse d’un magasin.

#### <ins> **File de priorité (Priority Queue / Tas / Heap)**

Une file où chaque élément a une **priorité**. L’élément avec la plus haute priorité sort en premier.
Souvent implémentée avec un **tas binaire (heap)**.

#### Schéma (tas min)

```
        10
       /  \
     20    15
    / \
  30   25
```

[Explication simple](https://www.youtube.com/watch?v=K7G287nYk14)

#### Complexité

* Insertion : **O(log n)**
* Extraction du min/max : **O(log n)**

#### Exemple réel

Service d’urgence à l’hôpital → les cas graves passent avant.


### 🔹 Structures hiérarchiques


#### <ins> **Arbre (Tree)**

Une structure hiérarchique composée de **nœuds** reliés par des arêtes.
Chaque nœud a :

* une valeur,
* des enfants.

#### Schéma (arbre binaire)

```
        10
       /  \
      5    20
     / \     \
    2   8     30
```

#### Types

* **Arbre binaire** : max 2 enfants.
* **Arbre binaire de recherche (BST)** : gauche < racine < droite.
* **Arbres équilibrés** (AVL, Red-Black).

#### Complexité (BST équilibré)

* Recherche, insertion, suppression : **O(log n)**

#### Exemple réel

Arborescence des dossiers/fichiers dans un ordinateur.

#### <ins> **Graphe (Graph)**

Un ensemble de **sommets (nœuds)** reliés par des **arêtes (liens)**.
Peut être orienté ou non, pondéré ou non.

#### Schéma

```
 A —— B —— C
 |     \
 D      E
```

#### Représentations

* Liste d’adjacence.
* Matrice d’adjacence.

#### Complexité

* Parcours BFS/DFS : **O(V + E)** (V = sommets, E = arêtes).

#### Exemple réel

Un réseau social (Facebook : personnes = sommets, amitiés = arêtes).

### 🔹 Structures de recherche

#### <ins> **Table de hachage (Hash Table / HashMap)**

Associe une **clé** à une **valeur** via une **fonction de hachage**.

#### Schéma

```
Clé → Hachage → Index → Valeur
"Bob" → h("Bob")=2 → table[2] = 90
```

#### Complexité

* Insertion/recherche/suppression : **O(1)** en moyenne.

#### Avantages

* Accès très rapide.

#### Inconvénients

* Collisions possibles (deux clés pour le même index).
* Consomme plus de mémoire.

#### Exemple réel

Annuaire téléphonique (nom → numéro).

---

## 📌 Tableau récapitulatif

| Structure     | Accès    | Insertion | Suppression | Exemple concret       |
| ------------- | -------- | --------- | ----------- | --------------------- |
| Tableau       | O(1) (index) / O(n) (valeur)    | O(n)      | O(n)        | Sièges d’avion        |
| Liste chaînée | O(n)     | O(1) en tête ou fin    | O(1) en tête       | Collier de perles     |
| Pile (Stack)  | O(n)     | O(1)      | O(1)        | Pile d’assiettes      |
| File (Queue)  | O(n)     | O(1)      | O(1)        | File d’attente        |
| Tas (Heap)    | O(n)     | O(log n)  | O(log n)    | Urgences hôpital      |
| Arbre (BST)   | O(log n) | O(log n)  | O(log n)    | Arborescence fichiers |
| Graphe        | O(V+E)   | O(1)      | O(1)        | Réseau social         |
| Hash Table    | O(1)     | O(1)      | O(1)        | Dictionnaire          |




