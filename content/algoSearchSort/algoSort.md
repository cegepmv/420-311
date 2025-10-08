+++
draft = true
title = '📘 Chapitre : Les algorithmes de tri'
weight = 62
+++


### **Tri à bulles (Bubble Sort)**

Le tri à bulles ou tri par propagation ou permutation est un algorithme de tri qui consiste à faire remonter progressivement les plus grands éléments d'un tableau, comme les bulles d'air remontent à la surface d'un liquide.

Le tri à bulles est souvent enseigné en tant qu'exemple algorithmique. Cependant, sa complexité est de l'ordre de n² en moyenne (où n est la taille du tableau), ce qui le classe parmi les mauvais algorithmes de tri. Il n'est donc quasiment pas utilisé en pratique.

**Principe :**
Comparer chaque paire d’éléments consécutifs et les échanger si nécessaire.
Les plus grands "remontent" vers la fin du tableau.

**Complexité :**

* Pire cas : **O(n²)**
* Meilleur cas (déjà trié) : **O(n)**

**Exemple Java :**

```java
public class TriBulle {
    public static void trier(int[] tab) {
        boolean echange;
        do {
            echange = false;
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    int tmp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = tmp;
                    echange = true;
                }
            }
        } while (echange);
    }
}
```

---

### **Tri par sélection (Selection Sort)**
Le tri par sélection (ou tri par extraction) est un algorithme de tri par comparaison. Il est particulièrement simple, mais inefficace sur de grandes entrées, car il s'exécute en temps quadratique en le nombre d'éléments à trier.

Sur un tableau de n éléments (numérotés de 1 à n), le principe du tri par sélection est le suivant :

* Rechercher le plus petit élément du tableau, et l'échanger avec l'élément d'indice 1 ;
* Rechercher le second plus petit élément du tableau, et l'échanger avec l'élément d'indice 2 ;
* Continuer de cette façon jusqu'à ce que le tableau soit entièrement trié. 	
  * si t[j] < t [min], alors min ← j
  * si min ≠ i, alors échanger t[i] et t [min]


**Principe :**
Trouver le plus petit élément du tableau et le placer au début.
Répéter pour le reste du tableau.

**Complexité :**

* Tous les cas : **O(n²)**
  Mais peu d’échanges (n−1 au total).

**Exemple Java :**

```java
public class TriSelection {
    public static void trier(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[min]) {
                    min = j;
                }
            }
            int tmp = tab[i];
            tab[i] = tab[min];
            tab[min] = tmp;
        }
    }
}
```

---

### **Tri par insertion (Insertion Sort)**

Le tri par insertion est un algorithme de tri classique dont le principe est très simple. C'est le tri que la plupart des personnes utilisent naturellement pour trier des cartes : prendre les cartes mélangées une à une sur la table, et former une main en insérant chaque carte à sa place.

En général, le tri par insertion est beaucoup plus lent que d'autres, car sa complexité asymptotique est quadratique.

Le tri par insertion est cependant considéré comme le tri le plus efficace sur des entrées de petite taille. Il est aussi très rapide lorsque les données sont déjà presque triées. Pour ces raisons, il est utilisé en pratique en combinaison avec d'autres méthodes comme le tri rapide (ou Quick sort).

En programmation informatique, on applique le plus souvent ce tri à des tableaux.

**Principe :**
On insère progressivement chaque élément à sa place dans la partie déjà triée.

**Complexité :**

* Pire cas : **O(n²)** (tableau inversé)
* Meilleur cas : **O(n)** (tableau déjà trié)

**Exemple Java :**

```java
public class TriInsertion {
    public static void trier(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            int x = tab[i];
            int j = i - 1;
            while (j >= 0 && tab[j] > x) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = x;
        }
    }
}
```

---

## **Comparaison des tris**

| Tri               | Meilleur cas | Pire cas | Complexité moyenne | Avantage                 | Inconvénient          |
| ----------------- | ------------ | -------- | ------------------ | ------------------------ | --------------------- |
| **À bulles**      | O(n)         | O(n²)    | O(n²)              | Simple à comprendre      | Très lent             |
| **Par sélection** | O(n²)        | O(n²)    | O(n²)              | Peu d’échanges           | Lent                  |
| **Par insertion** | O(n)         | O(n²)    | O(n²)              | Bon pour petits tableaux | Lent si grand tableau |

