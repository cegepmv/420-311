+++
date = '2025-10-08T13:51:33-04:00'
draft = false
title = '📘 Chapitre : Les algorithmes de recherche'
weight = 61
+++


## 1. Notion de recherche dans un tableau

La **recherche** consiste à trouver la position d’un élément dans une collection de données (tableau, liste, etc.).
On peut la classer en deux grandes familles :

| Type de recherche           | Condition préalable       | Complexité moyenne | Exemple                          |
| --------------------------- | ------------------------- | ------------------ | -------------------------------- |
| **Linéaire (séquentielle)** | Aucune (tableau non trié) | O(n)               | Parcourir un tableau d’étudiants |
| **Binaire (dichotomique)**  | Tableau trié              | O(log n)           | Recherche dans un dictionnaire   |


## 🔹 2. Recherche linéaire

La recherche linéaire (séquentielle) compare les différents éléments d'un tableau à l’élément recherché. Cet algorithme fonctionne bien pour les petits tableaux ou pour les tableaux non triés. Cet algorithme retourne la position de l’élément.

### Principe

On parcourt le tableau du début à la fin jusqu’à trouver la valeur recherchée.
Si elle est trouvée → on retourne sa position.
Sinon → on retourne `-1`.

### Exemple visuel

```text
Tableau : [5, 12, 8, 21, 3]
Recherche : 8

→ Compare 5 ≠ 8
→ Compare 12 ≠ 8
→ Compare 8 = 8 ✅ trouvé à l’indice 2
```

### Exemple Java

```java
public class RechercheLineaire {
    public static int rechercheLineaire(int[] tableau, int valeur) {
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] == valeur) {
                return i; // trouvé
            }
        }
        return -1; // non trouvé
    }

    public static void main(String[] args) {
        int[] tab = {5, 12, 8, 21, 3};
        int resultat = rechercheLineaire(tab, 8);
        System.out.println(resultat >= 0 ? "Trouvé à la position " + resultat : "Non trouvé");
    }
}
```

### ⏱️ Complexité

* **Meilleur cas :** O(1) → si l’élément est au début.
* **Pire cas :** O(n) → si l’élément est absent.
* **Moyenne :** O(n/2) ≈ O(n).



## 🔹 3. Recherche binaire (ou dichotomique)

La recherche binaire ou recherche dichotomique n'est applicable que si le tableau a été trié auparavant. Cet algorithme commence par l'élément central et le compare à l’élément recherché.

* Si les deux valeurs sont égales alors la valeur de l'indice (la position) est retournée.
* Si l'élément recherché est inférieur, la recherche est poursuivie de manière analogue dans la première partie du tableau.
* Sinon elle est supérieure et la recherche se poursuit dans seconde partie du tableau.

La recherche continue jusqu'à ce que l’élément recherché soit égal à l'élément central d'un sous tableau ou jusqu'à ce que le sous-tableau comporte un élément dont la valeur diffère de celle de l’élément recherché c'est-à-dire que l’élément recherché n'a pas été trouvé. 
Cet algorithme retourne la position de l’élément.


### Principe

Applicable uniquement sur un **tableau trié**.
On divise le tableau en deux à chaque étape :

1. On compare l’élément central à la valeur recherchée.
2. Si égal → trouvé.
3. Si plus petit → on cherche dans la moitié droite.
4. Si plus grand → on cherche dans la moitié gauche.

### Exemple visuel

```text
Tableau trié : [3, 5, 8, 12, 21, 32]
Recherche : 12

→ Milieu = 8  → trop petit
→ Nouvelle zone : [12, 21, 32]
→ Milieu = 21 → trop grand
→ Nouvelle zone : [12]
→ Trouvé ✅
```
Pseudo-code :
```java
Procédure rechercheBinaire (tableau d’entiers, entier elementARechercher) {
    On déclare un entier premier = 0 ;
    On déclare un entier position = la taille du tableau passé en paramètre 

    Tant que (premier < position) {
        Entier milieu = (premier + taille) / 2
        Si (elementARechercher < (tableau [milieu])) {
            position = milieu ;
        }
        Sinon Si (elementARechercher > (tableau [milieu])) {
            premier = milieu + 1 ;
        } Sinon {
            Retourner milieu ;
        } 
    } 

    Retourner – (premier + 1) ; 
}
```


### Exemple Java

```java
public class RechercheBinaire {
    public static int rechercheBinaire(int[] tab, int valeur) {
        int debut = 0;
        int fin = tab.length - 1;

        while (debut <= fin) {
            int milieu = (debut + fin) / 2;

            if (tab[milieu] == valeur)
                return milieu;
            else if (tab[milieu] < valeur)
                debut = milieu + 1;
            else
                fin = milieu - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] tab = {3, 5, 8, 12, 21, 32};
        int resultat = rechercheBinaire(tab, 12);
        System.out.println(resultat >= 0 ? "Trouvé à la position " + resultat : "Non trouvé");
    }
}
```

### ⏱️ Complexité

* **Meilleur cas :** O(1)
* **Pire cas :** O(log₂ n)
* **Avantage :** beaucoup plus rapide pour les grands ensembles triés.



## 🔍 4. Comparaison entre les deux algorithmes

| Critère                             | Recherche linéaire | Recherche binaire |
| ----------------------------------- | ------------------ | ----------------- |
| Nécessite un tri préalable          | Non                | Oui               |
| Temps moyen                         | O(n)               | O(log n)          |
| Facilité d’implémentation           | Très simple        | Moyenne           |
| Efficace pour grands tableaux triés | ❌ Non              | ✅ Oui             |
| Fonctionne pour tableaux non triés  | ✅ Oui              | ❌ Non             |

