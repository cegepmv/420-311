+++
draft = false
title = 'Complexité algorithmique'
weight = 31
+++

## Qu’est-ce que la complexité algorithmique ?
La **complexité algorithmique** désigne en informatique la quantité de ressources qu’un algorithme consomme lors de son exécution (On utilise Grand O pour décrire la performance d'une algorithme). Elle se décline en deux dimensions principales :

* **La complexité temporelle**, qui mesure le temps d’exécution.
* **La complexité spatiale**, qui évalue la mémoire supplémentaire requise en dehors des données d’entrée.

Ces deux aspects sont indépendants : un algorithme peut être très rapide mais consommer beaucoup de mémoire, ou inversement.

Pour bien évaluer un algorithme, il faut examiner son comportement dans différents contextes :

* le **meilleur cas**,
* le **pire cas** (souvent privilégié pour anticiper les situations extrêmes),
* et le **cas moyen**, qui reflète son usage habituel.

Comparer la complexité de plusieurs algorithmes résolvant le même problème permet ainsi de choisir la solution la plus adaptée en fonction des contraintes de performance.


## Comment et pourquoi mesurer la complexité ?

Pour mesurer la complexité d’un algorithme, on utilise la notation Big O, écrite sous la forme O(f(n)). Elle exprime la croissance du temps ou de la mémoire nécessaires en fonction de la taille de l’entrée, généralement notée n.

Le but de cette notation est de mettre en évidence le comportement asymptotique : comment l’algorithme évolue lorsque n devient très grand. On ignore donc les détails secondaires (constantes et termes mineurs) pour ne retenir que le terme dominant. Par exemple, une complexité exacte de `3n² + 5n + 7` se résume en O(n²), puisque n² domine pour de grandes valeurs de n.
* Un programme qui fonctionne n’est pas forcément **efficace**.
* Exemple concret :

  * Rechercher un mot dans un dictionnaire papier (O(log n)).
  * Rechercher une photo dans une pile désordonnée (O(n)).
* Plus les données sont grosses, plus le choix de l’algorithme est critique.


## Notation Big-O (pire cas)

La notation **Big-O** décrit comment le **temps d’exécution** évolue en fonction de la taille de l’entrée (*n*).

| Complexité     | Exemple                      | Interprétation        |
| -------------- | ---------------------------- | --------------------- |
| **O(1)**       | Accès à un tableau par index | Constant              |
| **O(log n)**   | Recherche binaire            | Logarithmique : croissance lente      |
| **O(n)**       | Parcours d’une liste         | Linéaire         |
| **O(n log n)** | Tri rapide/merge sort        | Plus rapide que O(n²) |
| **O(n²)**      | Doubles boucles imbriquées   | Quadratique : explose vite          |
| **O(2^n)**     | Problèmes combinatoires      | Exponentielle : impraticable          |

💡 Règle d’or :

* Pour **n petit**, toutes les méthodes semblent rapides.
* Pour **n grand**, seules les bonnes structures/algorithmes tiennent la route.


![Complexité algorithmique](/420-311/images/Complex_algo.png)


## Exemples en Java

### 🔹 O(1) – Affichage simple
```java
public static void affiche(int[] tab) {
    // O(1)
    System.out.println(tab[0]);
}
```
Aussi :

```java
public static void affiche(int[] tab) {
    // O(2) qui sera simplifée à O(1)
    System.out.println(tab[0]);
    System.out.println(tab[1]);
}
```

### 🔹 O(n) – Boucle (itération sur tous les élements)

```java
public static void afficheTableau(int[] tab) {
    // O(n)
    for (int num : tab) {
        System.out.println(num);
    }
}
```
Même chose pour les boucles `for`, `while` et `do while`

### 🔹 O(n ^ 2) – Bouble inbriquée
```java
public static void afficheTableau2D(int[] tab) {
    // O(n ^ 2)
    for (int num1 : tab) {
        for (int num2 : tab) {
            System.out.println(num1 * num2);
        }
    }
}
```

### 🔹 O(log n) – Recherche binaire

⚠️ Nécessite un tableau trié.

```java
public static boolean rechercheBinaire(int[] tab, int val) {
    int g = 0, d = tab.length - 1;
    while (g <= d) {
        int m = (g + d) / 2;
        if (tab[m] == val) return true;
        if (tab[m] < val) g = m + 1;
        else d = m - 1;
    }
    return false;
}
```
> Si nous cherchant dans un tableau d'un million d'éléments, 19 comparaisons seront suffusantes pour trouver l'élément recherché. 

### 🔹 Comparaison avec des exemples

```java
import java.util.*;

public class Bench {
    public static void main(String[] args) {
        int n = 1_000_000;
        int[] tab = new int[n];
        for (int i = 0; i < n; i++) tab[i] = i;
        int cible = n - 1;

        // Recherche linéaire
        long t1 = System.nanoTime();
        rechercheLineaire(tab, cible);
        long t2 = System.nanoTime();
        System.out.println("Lineaire : " + (t2 - t1) / 1_000_000.0 + " ms");

        // Recherche binaire
        long t3 = System.nanoTime();
        rechercheBinaire(tab, cible);
        long t4 = System.nanoTime();
        System.out.println("Binaire : " + (t4 - t3) / 1_000_000.0 + " ms");
    }

    public static boolean rechercheLineaire(int[] tab, int val) {
        for (int x : tab) if (x == val) return true;
        return false;
    }

    public static boolean rechercheBinaire(int[] tab, int val) {
        int g = 0, d = tab.length - 1;
        while (g <= d) {
            int m = (g + d) / 2;
            if (tab[m] == val) return true;
            if (tab[m] < val) g = m + 1; else d = m - 1;
        }
        return false;
    }
}
```
On peut dire que :
* Un algorithme linéaire, qui met une seconde à traiter un tableau à 100 éléments, mettra 100 secondes à traiter un tableau à 10 000 éléments.
* Un algorithme quadratique qui met également une seconde à traiter le cas d'un tableau à 100 éléments mettra 10 000 secondes (soit près de trois heures) à traiter le cas du tableau à 10 000 éléments.
* Un algorithme en O(2n) qui mettrait aussi une seconde avec 100 éléments qui mettrait 2100 secondes à traiter ne serait-ce que 200 éléments, soit environ 4.1022 années (4000 milliards de milliards d'années).


## Analyse de boucles

* Boucle simple `for (int i=0; i<n; i++)` → O(n).
* Boucles imbriquées `for i, for j` → O(n²).
* Boucle divisant par 2 `while (n > 1) n/=2` → O(log n).

        > Un algorithme linéaire, qui met une seconde à traiter un tableau à 100 éléments, mettra 100 secondes à traiter un tableau à 10 000 éléments.
        > Un algorithme quadratique qui met également une seconde à traiter le cas d'un tableau à 100 éléments mettra 10 000 secondes (soit près de trois heures) à traiter le cas du tableau à 10 000 éléments.
        > Un algorithme en O(2n) qui mettrait aussi une seconde avec 100 éléments qui mettrait 2100 secondes à traiter ne serait-ce que 200 éléments, soit environ 4.1022 années (4000 milliards de milliards d'années).


## Complexité spatiale (mémoire)
La complexité spatiale (ou complexité mémoire) mesure la quantité de mémoire nécessaire pour exécuter un algorithme en fonction de la taille de l’entrée (n).

💡 On ne parle pas seulement de la mémoire des données initiales, mais aussi :

de la mémoire supplémentaire utilisée par l’algorithme (variables, structures temporaires, pile d’appels).

* **O(1)** : pile, file, liste chaînée → mémoire proportionnelle aux données.
* **O(n)** : tableau de n éléments.
* **O(n²)** : matrice d’adjacence pour un graphe.

Exemple 1 : Complexité spatiale O(1)
```java
public static void afficheTableau(int[] tab) {
    // O(1) space
    for (int num : tab) {
        System.out.println(num);
    }
}
```

Exemple 2 : Complexité spatiale O(n)
```java
public static void afficheTableau(int[] tab) {
    // O(n) space (c'est l'espace qu'on a alloué à l'iterieur de cette méthode)
    int[] tabCopy = new int[tab.length];

    for (int num : tab) {
        System.out.println(num);
    }
}
```
Exemple 3 : Complexité spatiale O(n) (récursion)

```java
public static int factoriel(int n) {
    // O(n) space
    if (n == 0) return 1;
    return n * factoriel(n - 1);
}
```

---

## Exercices

1. Quelle est la complexité de :

   ```java
   for (int i=0; i<n; i++) 
       for (int j=0; j<n; j++) 
           System.out.println(i + "," + j);
   ```
2. Quelle est la complexité de :

   ```java
   for (int i=0; i<n; i*=2) 
       System.out.println(i);
   ```
3. Quelle est la complexité spatiale d’un tableau `int[1000][1000]` ?

---

## Fiche synthèse 

* Complexité temporelle → combien de temps ça prend.

* Complexité spatiale → combien de mémoire ça utilise.

* Parfois, il faut choisir :

    * Moins de temps mais plus de mémoire (ex. table de hachage).

    * Moins de mémoire mais plus de temps (ex. recherche linéaire dans une liste).

* On utilise la notion grand O (Big O) pour mesurer la complexité :
    * **O(1)** : accès direct.
    * **O(log n)** : recherche dichotomique, arbres équilibrés.
    * **O(n)** : parcours d’une collection.
    * **O(n log n)** : tris efficaces.
    * **O(n²)** : algorithmes naïfs à doubles boucles.
    * **O(2^n)** : problèmes combinatoires → à éviter.
