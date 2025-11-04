+++
draft = false
title = '📘 Chapitre : Les algorithmes de tri'
weight = 62
+++

## Capsule d'introduction aux algorithmes de tri

{{< video src="/420-311/videos/Les_algorithmes_de_tri.mp4" alt="Capsule d'introduction aux algorithmes de tri" controls="true" loop="false" />}}

## Les Algorithmes de Tri Simples (Complexité Quadratique)
Ce groupe d'algorithmes, bien que souvent moins performants avec une complexité de O(n²), est fondamental pour comprendre les principes de base du tri. Leur simplicité conceptuelle en fait un excellent point de départ pour quiconque s'initie aux structures de données et aux algorithmes.


### **Tri à bulles (Bubble Sort)**

Le tri à bulles ou tri par propagation ou permutation est un algorithme de tri qui consiste à faire remonter progressivement les plus grands éléments d'un tableau, comme les bulles d'air remontent à la surface d'un liquide.

Le tri à bulles est souvent enseigné en tant qu'exemple algorithmique. Cependant, sa complexité est de l'ordre de n² en moyenne (où n est la taille du tableau), ce qui le classe parmi les mauvais algorithmes de tri. Il n'est donc quasiment pas utilisé en pratique.

**Principe :**
Comparer chaque paire d’éléments consécutifs et les échanger si nécessaire.
Les plus grands "remontent" vers la fin du tableau.

**Exemple de Fonctionnement:**
Prenons l'exemple du tableau [8, 2, 4, 1, 3].
1. Premier Passage :
    * Compare 8 et 2. 2 < 8, donc on permute : [2, 8, 4, 1, 3]
    * Compare 8 et 4. 4 < 8, donc on permute : [2, 4, 8, 1, 3]
    * Compare 8 et 1. 1 < 8, donc on permute : [2, 4, 1, 8, 3]
    * Compare 8 et 3. 3 < 8, donc on permute : [2, 4, 1, 3, 8]
    * À la fin de ce passage, le plus grand élément, 8, est à sa position correcte.
2. Deuxième Passage :
    * Compare 2 et 4. Pas de permutation. [2, 4, 1, 3, 8]
    * Compare 4 et 1. 1 < 4, donc on permute : [2, 1, 4, 3, 8]
    * Compare 4 et 3. 3 < 4, donc on permute : [2, 1, 3, 4, 8]
    * À la fin de ce passage, le deuxième plus grand élément, 4, est à sa position correcte.

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


Bien que ces algorithmes simples offrent une base solide, leur complexité quadratique les rend peu pratiques pour les grands ensembles de données. Cela nous amène à explorer une classe d'algorithmes plus efficaces, conçus pour gérer de plus grands volumes d'informations.

## Les Algorithmes de tri efficaces (complexité logarithmique)

Les algorithmes de cette catégorie, tels que le tri par fusion et le tri rapide, utilisent des stratégies plus avancées comme l'approche **"diviser pour régner"** pour atteindre une complexité temporelle de **O(n log n)**. Cette performance les rend nettement plus rapides et plus évolutifs que les algorithmes quadratiques, en particulier pour les grands ensembles de données.

### Tri par fusion (Merge Sort)

Le tri par fusion est un exemple classique de l'approche "diviser pour régner". Il est récursif et garantit une performance stable.

**Principe**

L'algorithme fonctionne en deux phases distinctes :

1. **Phase de Division** : Le tableau est divisé récursivement en deux moitiés jusqu'à ce que l'on obtienne des sous-tableaux ne contenant qu'un seul élément. Un tableau d'un seul élément est, par définition, déjà trié.
2. **Phase de fusion** : Les sous-tableaux triés sont ensuite fusionnés deux par deux de manière ordonnée. Lors de la fusion, les éléments des deux sous-tableaux sont comparés et placés dans un nouveau tableau dans le bon ordre, créant ainsi un tableau plus grand qui est également trié. Ce processus se poursuit jusqu'à ce que tous les sous-tableaux aient été fusionnés en un seul tableau final trié.

**Complexité temporelle et spatiale**

- **Complexité temporelle : O(n log n)**. La division récursive du tableau en moitiés produit **log n** niveaux de division. À **chaque niveau**, la phase de fusion nécessite de parcourir tous les `n` éléments pour les combiner en sous-tableaux triés. Le travail `n` effectué `log n` fois donne une complexité temporelle de O(n log n) dans tous les cas.
- **Complexité spatiale : O(n)**. Le principal inconvénient du tri par fusion est sa consommation de mémoire. Des tableaux temporaires sont nécessaires pour stocker les sous-tableaux pendant les phases de division et de fusion. Ce coût en mémoire est le compromis nécessaire pour garantir la vitesse et la stabilité de l'algorithme.

### Tri rapide (Quicksort)

Le tri rapide est l'un des algorithmes de tri les plus utilisés en pratique et constitue la base des fonctions de tri intégrées dans de nombreux langages et frameworks, comme `Arrays.sort` en Java.

**Principe**

Le tri rapide est également un algorithme de type "diviser pour régner". Son mécanisme central repose sur les étapes suivantes :

1. **Choix du pivot** : Un élément du tableau est sélectionné comme "pivot". Le choix du pivot peut varier (premier, dernier ou un élément aléatoire).
2. **Partitionnement** : Le tableau est réorganisé de telle sorte que tous les éléments plus petits que le pivot se retrouvent à sa gauche, et tous les éléments plus grands se retrouvent à sa droite. Après cette étape, le pivot se trouve à sa position finale correcte dans le tableau trié.
3. **Récursion** : Le processus de partitionnement est répété récursivement sur les deux sous-tableaux (celui à gauche du pivot et celui à droite).

Il est important de noter que le tri rapide est un algorithme **instable**, car les permutations d'éléments éloignés peuvent modifier l'ordre relatif des éléments de même valeur.

**Complexité temporelle et spatiale**

- **Complexité temporelle : O(n log n)**. En moyenne et dans le meilleur des cas, le tri rapide atteint cette complexité quasi-linéaire très efficace.
- **Complexité spatiale : O(log n)**. Un avantage clé du tri rapide est qu'il trie "en place", sans nécessiter de tableau auxiliaire pour les données. Cependant, il n'a pas une complexité spatiale de O(1). L'espace est requis par la pile d'appels récursifs, dont la profondeur est en moyenne de O(log n), ce qui le rend très efficace en termes de mémoire.

---

Les algorithmes abordés jusqu'à présent reposent tous sur la comparaison directe des éléments pour déterminer leur ordre. Cependant, une autre catégorie d'algorithmes adopte une approche fondamentalement différente, qui peut s'avérer encore plus rapide dans des conditions spécifiques.

## Les Algorithmes de tri non basés sur la comparaison

Contrairement aux algorithmes précédents, cette catégorie ne compare pas les éléments entre eux. Ils exploitent plutôt des propriétés mathématiques des données, comme leur valeur numérique, pour les classer. Sous certaines conditions, ces algorithmes peuvent atteindre une complexité linéaire, surpassant ainsi les algorithmes basés sur la comparaison.

### Tri par comptage (Counting Sort)

Cet algorithme est particulièrement efficace pour trier des entiers dans une plage de valeurs limitée.

**Principe**

Le tri par comptage fonctionne en déterminant le nombre d'occurrences de chaque élément dans le tableau d'entrée. Ce décompte est stocké dans un tableau auxiliaire, souvent appelé tableau de "comptes". L'index de ce tableau correspond à la valeur de l'élément, et la valeur à cet index correspond à sa fréquence. Ensuite, ce tableau de comptes est utilisé pour reconstruire le tableau original en plaçant chaque élément le bon nombre de fois dans l'ordre croissant.

**Contraintes et cas d'usage**

- **Hypothèse clé** : Les valeurs d'entrée doivent être des entiers positifs dans une plage connue et relativement petite (de 0 à `k`).
- **Gaspillage de mémoire** : L'algorithme devient inefficace si la plage des valeurs (`k`) est très grande par rapport au nombre d'éléments (`n`). Par exemple, trier quelques nombres dont l'un est `1 000 000` nécessiterait un tableau de comptes d'un million d'éléments, ce qui gaspillerait beaucoup de mémoire.
- **Cas d'usage idéal** : Il est le plus adapté lorsque la plupart des valeurs de la plage sont présentes dans le tableau d'entrée, minimisant ainsi les "trous" (valeurs nulles) dans le tableau de comptes.

**Complexité et compromis temps-mémoire**

- **Complexité temporelle : O(n + k)**. Si la plage `k` n'est pas significativement plus grande que le nombre d'éléments `n`, la complexité se simplifie en **O(n)**, soit un temps linéaire.
- **Complexité spatiale : O(k)**. L'algorithme nécessite un espace mémoire supplémentaire pour le tableau de comptes, dont la taille dépend de la valeur maximale `k`.
- Ceci illustre un concept clé en informatique : le **compromis temps-mémoire**. Le tri par comptage atteint sa vitesse exceptionnelle en utilisant de la mémoire supplémentaire.

### Tri par paquets (Bucket Sort)

Le tri par paquets généralise l'idée du tri par comptage en distribuant les éléments dans plusieurs "paquets".

**Principe**

Le processus se déroule en trois étapes :

1. **Distribution** : Les éléments du tableau d'entrée sont répartis dans un nombre prédéfini de "paquets" (buckets). Pour déterminer dans quel paquet un élément doit aller, on peut utiliser une formule simple, comme diviser la valeur de l'élément par le nombre de paquets.
2. **Tri** : Chaque paquet est ensuite trié individuellement. Un autre algorithme de tri, comme le tri par insertion, est généralement utilisé pour cette étape, car il est efficace sur de petits ensembles de données.
3. **Combinaison** : Enfin, les éléments des paquets triés sont concaténés pour former le tableau final trié.

**Impact du nombre de paquets**

La performance du tri par paquets est directement liée au nombre de paquets utilisés. Plus il y a de paquets, plus chaque paquet contient peu d'éléments, ce qui rend leur tri individuel plus rapide. Cependant, un grand nombre de paquets augmente la consommation de mémoire.

**Complexité et compromis temps-mémoire**

- **Complexité temporelle : O(n) à O(n²)**. Dans le meilleur des cas, si les éléments sont répartis de manière uniforme dans les paquets, la complexité peut être linéaire, soit **O(n)**. Dans le pire des cas, si tous les éléments tombent dans le même paquet, la complexité devient celle de l'algorithme de tri sous-jacent (par exemple, **O(n²)** si le tri par insertion est utilisé).
- **Complexité spatiale : O(n + k)**, où `n` est le nombre d'éléments et `k` le nombre de paquets.
- Cet algorithme est un autre exemple clair du **compromis temps-mémoire**, où l'on sacrifie de la mémoire pour obtenir une exécution plus rapide.

---

## ⚙️ **Exemple de fonctionnement**

### 🧩 1. **Tri par fusion (Merge Sort)**

#### 🔹 Étapes

1️⃣ Diviser le tableau :

```
[8, 2, 4, 1, 3]
→ [8, 2] et [4, 1, 3]
```

2️⃣ Diviser à nouveau :

```
[8, 2] → [8] et [2]
[4, 1, 3] → [4] et [1, 3] → [1] et [3]
```

3️⃣ Fusionner en triant :

```
Fusion [8] et [2] → [2, 8]
Fusion [1] et [3] → [1, 3]
Fusion [4] et [1, 3] → [1, 3, 4]
Fusion [2, 8] et [1, 3, 4] → [1, 2, 3, 4, 8]
```

✅ Résultat final : `[1, 2, 3, 4, 8]`

#### 💡 Visualisation

```
         [8, 2, 4, 1, 3]
        /              \
   [8, 2]             [4, 1, 3]
   /   \              /      \
[8]   [2]          [4]     [1, 3]
                     \      /
                   [1, 3, 4]
→ Fusion finale → [1, 2, 3, 4, 8]
```


### ⚡ 2. **Tri rapide (Quick Sort)**

#### 🔹 Étapes

1️⃣ Choisir un **pivot** (dernier élément, ici `3`)
→ Partitionner : éléments < 3 à gauche, > 3 à droite

```
[8, 2, 4, 1, 3] → [2, 1] [3] [8, 4]
```

2️⃣ Appliquer récursivement :

* `[2, 1]` pivot `1` → `[1] [2]`
* `[8, 4]` pivot `4` → `[4] [8]`

3️⃣ Combiner :

```
[1, 2] + [3] + [4, 8] = [1, 2, 3, 4, 8]
```

✅ Résultat final : `[1, 2, 3, 4, 8]`

#### 💡 Visualisation

```
Pivot = 3
[8, 2, 4, 1, 3] → [2, 1] [3] [8, 4]
[2, 1] → [1, 2]
[8, 4] → [4, 8]
Résultat : [1, 2, 3, 4, 8]
```

### 🔢 3. **Tri par comptage (Counting Sort)**

#### 🔹 Étapes

1️⃣ Trouver la valeur max → `8`
2️⃣ Créer un tableau de comptage de 0 à 8 :

```
compte = [0,0,0,0,0,0,0,0,0]
```

3️⃣ Compter les occurrences :

```
[8, 2, 4, 1, 3]
→ compte = [0,1,1,1,1,0,0,0,1]
```

4️⃣ Reconstruire le tableau trié :

```
→ [1, 2, 3, 4, 8]
```

✅ Résultat final : `[1, 2, 3, 4, 8]`

#### 💡 Visualisation

```
Valeur :      0 1 2 3 4 5 6 7 8
Occurrences : 0 1 1 1 1 0 0 0 1
Résultat :    [1, 2, 3, 4, 8]
```


### 🪣 4. **Tri par paquets (Bucket Sort)**

*(exemple simplifié avec 5 seaux pour des entiers entre 1 et 8)*

#### 🔹 Étapes

1️⃣ Créer des seaux (buckets) :

```
[8, 2, 4, 1, 3] → 5 seaux : [ ] [ ] [ ] [ ] [ ]
```

2️⃣ Distribuer selon la valeur :

* `1` → seau 0
* `2` → seau 0
* `3` → seau 1
* `4` → seau 2
* `8` → seau 4

Buckets :

```
[1,2] [3] [4] [] [8]
```

3️⃣ Trier chaque seau (déjà petit, donc insertion sort ou rien)

4️⃣ Fusionner :

```
[1, 2] + [3] + [4] + [] + [8] = [1, 2, 3, 4, 8]
```

✅ Résultat final : `[1, 2, 3, 4, 8]`

#### 💡 Visualisation

```
Seau 0 : [1, 2]
Seau 1 : [3]
Seau 2 : [4]
Seau 3 : []
Seau 4 : [8]
→ Fusion : [1, 2, 3, 4, 8]
```

---

## Résumé du fonctionnement global

| Algorithme       | Méthode                 | Étapes clés                         | Résultat final  |
| ---------------- | ----------------------- | ----------------------------------- | --------------- |
| **MergeSort**    | Diviser + Fusionner     | Découper et recombiner trié         | [1, 2, 3, 4, 8] |
| **QuickSort**    | Pivot + Partition       | Trier récursivement autour du pivot | [1, 2, 3, 4, 8] |
| **CountingSort** | Compter les occurrences | Tableau de comptage                 | [1, 2, 3, 4, 8] |
| **BucketSort**   | Classer dans des seaux  | Distribution + tri local            | [1, 2, 3, 4, 8] |


---
## Tableau récapitulatif et Conclusion

### Synthèse des algorithmes

Le tableau ci-dessous résume les caractéristiques clés des algorithmes de tri abordés.

| Algorithme | Complexité Temporelle (Pire Cas) | Complexité Temporelle (Meilleur Cas) | Complexité spatiale | Stabilité |
| --- | --- | --- | --- | --- |
| **Tri à Bulles** | O(n²) | O(n) | En place (O(1)) |  |
| **Tri par Sélection** | O(n²) | O(n²) | En place (O(1)) | Instable |
| **Tri par Insertion** | O(n²) | O(n) | En place (O(1)) | Stable |
| **Tri par Fusion** | O(n log n) | O(n log n) | O(n) |  |
| **Tri Rapide** | O(n log n) | O(n log n) | O(log n) | Instable |
| **Tri par Comptage** | O(n + k) | O(n + k) | O(k) |  |
| **Tri par Paquets** | O(n²) | O(n) | O(n + k) |  |

### Conclusion

Comprendre les différents algorithmes de tri est une compétence essentielle pour tout informaticien. Comme nous l'avons vu, il n'existe pas d'algorithme "parfait" pour toutes les situations. Le choix optimal dépend des contraintes spécifiques du problème. Ce guide a mis en lumière le **compromis fondamental entre le temps et la mémoire** : des algorithmes comme le tri par fusion ou le tri par comptage garantissent une grande vitesse au prix d'une consommation mémoire plus élevée, tandis que le tri rapide offre une excellente performance moyenne tout en opérant en place. De même, le choix dépend des garanties de performance requises. Le tri par fusion offre une complexité prévisible de O(n log n), tandis que la performance du tri rapide et du tri par paquets peut se dégrader considérablement dans le pire des cas, en fonction des données d'entrée. Maîtriser ces nuances permet de concevoir des solutions logicielles non seulement correctes, mais aussi véritablement efficaces et adaptées au contexte d'exécution.

