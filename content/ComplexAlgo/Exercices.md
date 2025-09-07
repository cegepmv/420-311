+++
date = '2025-09-06T17:51:48-04:00'
draft = false
title = '📝 Exercices sur complexité algorithmique'
+++


## 🔹 Exercice 1 : 

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

👉 Quelle est la complexité temporelle en fonction de `n` ?


## 🔹 Exercice 2 

```java
while (n > 1) {
    n = n / 2;
}
```

👉 Quelle est la complexité temporelle ?


## 🔹 Exercice 3

```java
public static boolean rechercheLineaire(int[] tab, int val) {
    for (int x : tab) {
        if (x == val) return true;
    }
    return false;
}
```

👉 Quelle est la complexité temporelle **dans le pire cas** ?


## 🔹Exercice 4 

```java
public static void insertionSort(int[] tab) {
    for (int i = 1; i < tab.length; i++) {
        int cle = tab[i];
        int j = i - 1;
        while (j >= 0 && tab[j] > cle) {
            tab[j+1] = tab[j];
            j--;
        }
        tab[j+1] = cle;
    }
}
```

👉 Quelle est la complexité **dans le meilleur cas** et **dans le pire cas** ?


## 🔹Exercice 5

Classez les algorithmes suivants du plus rapide au plus lent quand `n` devient très grand :

1. O(n²)
2. O(n log n)
3. O(n)
4. O(log n)


## 🔹Exercice 6

Vous avez ce code :

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j *= 2) {
        System.out.println(i + "," + j);
    }
}
```

👉 Quelle est la complexité de cet algorithme ? Expliquez.


## 🔹Exercice 7

```java
public static int somme(int[] tab) {
    int total = 0;
    for (int n : tab) {
        total += n;
    }
    return total;
}
```

👉 **Question** : Quelle est la complexité spatiale de cette méthode ? Justifiez votre réponse.


## 🔹Exercice 8

```java
public static int[] doubleTableau(int[] tab) {
    int[] resultat = new int[tab.length];
    for (int i = 0; i < tab.length; i++) {
        resultat[i] = tab[i] * 2;
    }
    return resultat;
}
```

👉 **Question** : Combien de mémoire supplémentaire est utilisée par rapport à la taille de l’entrée *n* ?


## 🔹Exercice 9

```java
int[][] matrice = new int[n][n];
```

👉 **Question** : Quelle est la complexité spatiale de cette structure ?


## 🔹Exercice 10

On veut calculer la suite de Fibonacci :

**Version récursive simple** :

```java
public static int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

**Version avec mémoïsation** :

```java
public static int fibMemo(int n, int[] memo) {
    if (memo[n] != 0) return memo[n];
    if (n <= 1) return n;
    memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    return memo[n];
}
```

👉 **Questions** :

1. Quelle est la complexité spatiale des deux versions ?
2. Pourquoi la version avec mémoïsation consomme plus de mémoire mais gagne en temps ?


## 🔹Exercice 11 : 

Écrivez un programme qui :

1. Créez un tableau de 1 million d’entiers.
2. Créez une `LinkedList` et un `ArrayList` chacun contenant 1 million d’entiers.
3. Comparez la mémoire consommée (avec `Runtime.getRuntime().totalMemory() - freeMemory()`) pour chaque structure.

Observer concrètement l’impact de la structure choisie sur la mémoire. Que remarquez vous ?