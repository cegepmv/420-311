+++
draft = false
title = '📖 Le hachage'
weight = 24
+++

## Définition

Le **hachage** est une technique qui consiste à transformer une donnée (clé) en un **nombre entier** appelé *code de hachage* (*hash code*).
➡️ Ce nombre sert d’**adresse** pour placer ou retrouver rapidement la donnée dans une table.

👉 Exemple simple :

* Clé = `"Alice"`
* Fonction de hachage → produit un entier `12345`
* Cet entier est utilisé comme position pour stocker la valeur associée.


## La méthode `hashCode()` en Java

* Dans Java, chaque objet hérite de la méthode :

  ```java
  public int hashCode()
  ```
* Cette méthode retourne un entier qui représente l’objet.
* Pour que le hachage fonctionne correctement, il faut respecter le **contrat** :

  1. Si deux objets sont égaux (`equals`), ils doivent avoir le même `hashCode`.
  2. Si deux objets ont des `hashCode` différents → ils sont forcément différents.
  3. Si deux objets ont le même `hashCode` → ils peuvent être égaux ou différents (c’est une **collision**).

## Exemple avec `HashMap`

```java
import java.util.HashMap;

public class ExempleHashage {
    public static void main(String[] args) {
        HashMap<String, Integer> notes = new HashMap<>();

        notes.put("Alice", 85);
        notes.put("Bob", 90);

        System.out.println("Note de Bob : " + notes.get("Bob"));
    }
}
```

➡️ Ici :

* `"Bob"` est passé à une fonction de hachage (`hashCode()`).
* Le résultat détermine **dans quel compartiment** de la HashMap l’élément est stocké.
* Lorsqu’on fait `notes.get("Bob")`, Java recalcule le hash et retrouve la valeur.


## Gestion des collisions

Une **collision** arrive quand deux clés différentes produisent le **même hashCode**.
👉 Exemple :

* `"AB"` → `hashCode = 123`
* `"BA"` → `hashCode = 123`

Java doit alors stocker les deux valeurs dans le même compartiment et vérifier avec `equals()` pour distinguer les objets.


## Efficacité

* Recherche, insertion, suppression dans une `HashMap` ou `HashSet` : **O(1)** en moyenne.
* Mais en cas de nombreuses collisions, cela peut devenir **O(n)** (rare si la fonction de hachage est bien conçue).


## Exemple personnalisé : redéfinir `hashCode()` et `equals()`

```java
class Etudiant {
    String nom;
    int id;

    Etudiant(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id; // simplification
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Etudiant)) return false;
        Etudiant autre = (Etudiant) obj;
        return this.id == autre.id && this.nom.equals(autre.nom);
    }
}

public class TestHash {
    public static void main(String[] args) {
        HashSet<Etudiant> set = new HashSet<>();
        set.add(new Etudiant("Alice", 1));
        set.add(new Etudiant("Alice", 1)); // considéré comme identique

        System.out.println(set.size()); // 1
    }
}
```


## Comment éviter (ou limiter) les collisions en Java

### 1. Bien redéfinir `hashCode()` et `equals()`

Quand on crée ses propres classes (ex. `Etudiant`, `Livre`...), il faut s’assurer que :

* `hashCode()` distribue les objets de manière **uniforme** dans l’espace des entiers.
* `equals()` est cohérent avec `hashCode()`.

👉 Mauvais exemple (cause de collisions fréquentes) :

```java
@Override
public int hashCode() {
    return 1; // tous les objets ont le même hash !
}
```

👉 Bon exemple :

```java
@Override
public int hashCode() {
    return Objects.hash(nom, id);
}
```

Dans cet exemple, `Objects.hash()` combine les champs en générant un hash plus équilibré.


### 2. Choisir des champs pertinents

Un `hashCode()` doit utiliser les **attributs discriminants** de l’objet :

* Exemple : pour un étudiant → `id` et `nom`.
* Ne pas se baser sur des valeurs qui changent souvent (risque d’incohérence).


### 3. Utiliser des nombres premiers

Dans l’implémentation manuelle, on recommande souvent de :

* Multiplier par un nombre premier (souvent `31`) pour générer un hash plus varié.

👉 Exemple classique :

```java
@Override
public int hashCode() {
    int result = 17;          // nombre premier
    result = 31 * result + id;
    result = 31 * result + (nom == null ? 0 : nom.hashCode());
    return result;
}
```

### 4. Maintenir une bonne taille de table

Dans une `HashMap`, la **taille du tableau interne** influe sur les collisions :

* Trop petite → collisions fréquentes.
* Trop grande → gaspillage de mémoire.
* Java redimensionne automatiquement la `HashMap` quand elle dépasse un seuil (*load factor*, par défaut 0.75).

> Si on compte stocker beaucoup d’éléments, il serait mieux d'initialiser la `HashMap` avec une capacité suffisante :

```java
HashMap<String, Integer> map = new HashMap<>(10_000);
```

### 5. Utiliser `TreeMap` ou `TreeSet` si l’ordre est utile

Si l’égalité entre les éléments peut être testée efficacement avec un **ordre** (`compareTo`), un `TreeSet` ou un `TreeMap` réduit le risque de collisions car ils s’appuient sur des arbres équilibrés (O(log n)) au lieu d’un hash.


## Comment Java gère les collisions

* Avant Java 8 : collisions stockées dans une **liste chaînée** dans chaque compartiment → O(n) dans le pire cas.
* Depuis Java 8 : quand une case contient beaucoup d’éléments, la liste devient un **arbre rouge-noir** → O(log n) dans le pire cas.


## Résumé (à retenir)

* Le hachage transforme une clé en un entier (`hashCode`).
* Utilisé par **HashMap**, **HashSet**, **Hashtable**.
* Doit être couplé avec `equals()` pour distinguer les objets.
* Très efficace → **O(1)** en moyenne pour les opérations de recherche et d’insertion.
* Les collisions sont gérées par des structures internes (listes chaînées, puis arbres rouges-noirs depuis Java 8).
    * Avec le mauvais hashCode, toutes les données vont dans le même compartiment → le HashSet devient une liste chaînée → temps d’insertion beaucoup plus long.

    * Avec le bon hashCode, les données sont bien réparties → temps d’insertion rapide (O(1) en moyenne).
* Pour éviter les collisions :
    1. Toujours redéfinir **`hashCode()` et `equals()`** correctement.
    2. Utiliser des champs discriminants et stables.
    3. Combiner les champs avec des **nombres premiers**.
    4. Ajuster la capacité initiale de la `HashMap` si besoin.
    5. S’appuyer sur les **collections triées (TreeSet, TreeMap)** si un ordre est préférable.