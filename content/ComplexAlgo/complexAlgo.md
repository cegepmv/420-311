+++
draft = true
title = 'Complexité algorithmique'
+++

## Qu’est-ce que la complexité algorithmique ?
La **complexité algorithmique** désigne en informatique la quantité de ressources qu’un algorithme consomme lors de son exécution. Elle se décline en deux dimensions principales :

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

Le but de cette notation est de mettre en évidence le comportement asymptotique : comment l’algorithme évolue lorsque n devient très grand. On ignore donc les détails secondaires (constantes et termes mineurs) pour ne retenir que le terme dominant. Par exemple, une complexité exacte de 3n² + 5n + 7 se résume en O(n²), puisque n² domine pour de grandes valeurs de n.
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
| **O(log n)**   | Recherche binaire            | Croissance lente      |
| **O(n)**       | Parcours d’une liste         | Proportionnel         |
| **O(n log n)** | Tri rapide/merge sort        | Plus rapide que O(n²) |
| **O(n²)**      | Doubles boucles imbriquées   | Explose vite          |
| **O(2^n)**     | Problèmes combinatoires      | Impraticable          |

💡 Règle d’or :

* Pour **n petit**, toutes les méthodes semblent rapides.
* Pour **n grand**, seules les bonnes structures/algorithmes tiennent la route.


## Exemples en Java

### 🔹 O(n) – Recherche linéaire

```java
public static boolean rechercheLineaire(int[] tab, int val) {
    for (int x : tab) {
        if (x == val) return true;
    }
    return false;
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

## Complexité spatiale (mémoire)

* **O(1)** : pile, file, liste chaînée → mémoire proportionnelle aux données.
* **O(n)** : tableau de n éléments.
* **O(n²)** : matrice d’adjacence pour un graphe.


## Analyse de boucles

* Boucle simple `for (int i=0; i<n; i++)` → O(n).
* Boucles imbriquées `for i, for j` → O(n²).
* Boucle divisant par 2 `while (n > 1) n/=2` → O(log n).

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

* **O(1)** : accès direct.
* **O(log n)** : recherche dichotomique, arbres équilibrés.
* **O(n)** : parcours d’une collection.
* **O(n log n)** : tris efficaces.
* **O(n²)** : algorithmes naïfs à doubles boucles.
* **O(2^n)** : problèmes combinatoires → à éviter.
