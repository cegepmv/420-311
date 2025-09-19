+++
draft = false
title = 'La généricité en Java'
+++

## 🔹 Introduction 
🌼 Le terme générique est un concept introduit dans Java depuis la version 5.

La **généricité** (ou *generics*) en Java permet de créer des **classes, interfaces et méthodes paramétrées par des types**.

👉 Cela signifie qu’on peut écrire du code réutilisable et **indépendant du type exact** des objets manipulés.

🌼 L'ensemble de la famille Collection est basé sur les génériques pour la sécurité de type.

🌼 Les génériques permettent aux types (classes et interfaces) d'être des paramètres lors de la définition de classes, d'interfaces et de méthodes.

* **Sans généricité** : on manipule souvent des `Object` et on doit faire du *casting*.

* **Avec généricité** : on précise le type attendu, et le compilateur assure la sécurité des types.

🌼 Les paramètres de type générique vous permettent de réutiliser le même code avec des entrées différentes.


## 🔹 Type générique 
🌼 Un type générique est une classe ou une interface paramétrée sur des types.

🌼 Nous utilisons des crochets angulaires (<>) pour spécifier le paramètre type. Nous pouvons définir nos propres classes avec le type générique.

```java
class NomClasse<T1, T2, T3, ... , Tn> {
    /* ... */
}
```
🌼 La section de paramètre type, délimitée par des crochets (<>), suit le nom de la classe. Cela spécifie les paramètres de type (également appelés variables de type) T1, T2, ... et Tn.

## 🔹 Exemple simple : une boîte (Box)

### Sans généricité

```java
class Box {
    private Object contenu;

    public void setContenu(Object contenu) {
        this.contenu = contenu;
    }

    public Object getContenu() {
        return contenu;
    }
}

// Utilisation
Box b = new Box();
b.setContenu("Bonjour");
String texte = (String) b.getContenu(); // ⚠️ Il faut caster
```

>⚠️ Problème : si on met un `Integer` mais qu’on cast en `String`, cela provoque une **ClassCastException**.


### Avec généricité

```java
class Box<T> {
    private T contenu;

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }

    public T getContenu() {
        return contenu;
    }
}

// Utilisation
Box<String> b = new Box<>();
b.setContenu("Bonjour");
String texte = b.getContenu(); // ✅ Pas de cast nécessaire
```

Dans cete exemple, `T` est un **paramètre de type**.
Lors de l’utilisation, on précise `Box<String>`, donc `T = String`.

## 🔹 Conventions de nommage des paramètres de type 

🌼 Par convention, les noms de paramètre de type sont des lettres simples majuscules.

🌼 Les conventions de dénomination des paramètres de type sont importantes pour apprendre les génériques de manière approfondie.

🌼 Les noms de paramètre de type les plus couramment utilisés sont :
* `E` : Element ( largement utilisé par les collections Java)
* `K`: Key
* `N`: Number
* `T`: Type
* `V` : Value
* `S`, `U`, `V` etc. 2nd, 3rd, 4th types


## 🔹 Les collections et la généricité

En Java, toutes les collections (`List`, `Set`, `Map`, etc.) utilisent la généricité.

```java
List<String> noms = new ArrayList<>();
noms.add("Alice");
noms.add("Bob");

String premier = noms.get(0); // ✅ pas besoin de cast
```

Sans généricité, `List` stockait des `Object` et obligeait au cast.
Avec généricité, on gagne en **sécurité** et en **lisibilité**.


## 🔹 Méthodes génériques

🌼 Les méthodes génériques sont des méthodes qui introduisent leurs propres paramètres de type.

🌼 Ceci est similaire à la déclaration d'un type générique, mais la portée du paramètre type est limitée à la méthode où il est déclaré.

🌼 Les méthodes génériques statiques et non statiques sont autorisées, ainsi que les constructeurs de classes génériques.


```java
public class Util {
    public static <T> void afficher(T element) {
        System.out.println(element);
    }
}

// Utilisation
Util.afficher("Hello");   // String
Util.afficher(123);       // Integer
Util.afficher(3.14);      // Double
```

Dans cet exemple, `<T>` indique que la méthode est générique et peut recevoir n’importe quel type.


## 🔹 Les bornes (extends / super)

On peut **restreindre** les types autorisés.

### Exemple : `extends`

```java
class BoiteNombre<T extends Number> {
    private T valeur;

    public BoiteNombre(T valeur) {
        this.valeur = valeur;
    }

    public double doubleValue() {
        return valeur.doubleValue();
    }
}

// Utilisation
BoiteNombre<Integer> b1 = new BoiteNombre<>(5);
BoiteNombre<Double> b2 = new BoiteNombre<>(3.14);
// BoiteNombre<String> b3 = new BoiteNombre<>("texte"); ❌ Erreur
```

### Exemple : `super`

Permet de travailler avec des super-types.
Utile dans les méthodes avec collections (principe **PECS** : *Producer Extends, Consumer Super*) : Si la collection produit des éléments → on utilise extends.
Si la collection consomme des éléments → on utilise super.


```java
import java.util.*;

public class DemoPECS {
    public static void afficherNombres(List<? extends Number> nombres) {
        for (Number n : nombres) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        List<Integer> entiers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(3.14, 2.71);

        afficherNombres(entiers);   // OK
        afficherNombres(doubles);   // OK
    }
}
```
Dans cet exemple, List<? extends Number> accepte une liste de Integer, Double, etc.
Mais ⚠️ on ne peut pas ajouter d’éléments dans la liste (sauf null) car on ne connaît pas le type exact.


```java
import java.util.*;

public class DemoPECS {
    public static void ajouterEntiers(List<? super Integer> liste) {
        liste.add(10);
        liste.add(20);
        // liste.add(3.14); // ❌ impossible car pas sûr que ce soit accepté
    }

    public static void main(String[] args) {
        List<Integer> entiers = new ArrayList<>();
        List<Number> nombres = new ArrayList<>();
        List<Object> objets = new ArrayList<>();

        ajouterEntiers(entiers);  // OK
        ajouterEntiers(nombres);  // OK
        ajouterEntiers(objets);   // OK
    }
}
```
Dans cet exemple, List<? super Integer> accepte une List<Integer>, List<Number> ou List<Object>.
On peut donc y insérer des Integer en toute sécurité.

## 🔹 Avantages de la généricité

### 1. **Sécurité des types (Contrôles de type au moment de la compilation)**
▶️ Un compilateur Java applique une vérification de type stricte au code générique et génère des erreurs si le code viole la sécurité du type → plus de `ClassCastException` au runtime.
▶️ Il est plus facile de corriger les erreurs de compilation que de réparer les erreurs d'exécution, qui peuvent être difficiles à trouver.
### 2. **Réutilisabilité** 
▶️ On écrit une seule classe ou méthode pour plusieurs types.
### 3. **Lisibilité** 
▶️ on sait immédiatement quel type est attendu.


## 🔹 Inconvénients des génériques

### ◀️ Impossible d'instancier des types génériques avec des types primitifs
Les génériques ne fonctionnent qu’avec des types objets, pas avec les types primitifs (int, double, char, etc.) -> **Solution** : utiliser les classes enveloppes (Integer, Double, Character, etc.).

### ◀️ Impossible de créer des instances de paramètres de type
On ne peut pas écrire :
```java
class Box<T> {
    private T contenu;

    public Box() {
        contenu = new T(); // ❌ Erreur
    }
}
```
### ◀️ Impossible de déclarer des champs statiques dont les types sont des paramètres de type
Le paramètre générique T n’existe qu’au niveau instance, pas au niveau classe statique.

❌ Exemple invalide :
```java
class Box<T> {
    private static T contenu; // ❌ Erreur
}
```

### ◀️ Impossible d'utiliser des casts ou des instancesof avec des types paramétrés
Java utilise l’effacement de types (type erasure). Cela signifie que List<String> et List<Integer> deviennent la même chose à l’exécution : juste List.

❌ Exemple invalide :
```java
List<String> liste = new ArrayList<>();
if (liste instanceof List<String>) { // ❌ Erreur
    ...
}
```
On peut tester uniquement la forme brute (raw type).
```java
if (liste instanceof List) { // ✅
    System.out.println("C'est bien une liste !");
}
```

### ◀️ Impossible de créer des tableaux de types paramétrés

❌ Exemple invalide :
```java
List<String>[] tableau = new ArrayList<String>[10]; // ❌ Erreur
```
Car cela provoquerait des problèmes de compatibilité (ex. : insérer un List<Integer> par erreur) -> Solution : utiliser des collections (List<List<String>>) ou faire un cast avec précaution.
```java
List<List<String>> tableau = new ArrayList<>();
tableau.add(new ArrayList<>());
tableau.get(0).add("Bonjour");
```
Ici, au lieu d’un tableau, on utilise une collection de collections.

### ◀️ Impossible de créer, d'attraper ou de lancer des objets de types paramétrés
On ne peut pas utiliser un type paramétré dans une exception, car les exceptions doivent être déterminées au moment de la compilation.

❌ Exemple invalide :
```java
class MyException<T> extends Exception { } // ❌ Erreur
```
Et on ne peut pas non plus :
```java
try {
    // ...
} catch (T e) {   // ❌ Impossible
    ...
}
```

[Lien vers la documentation Oracle](https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html)


## 🎯 Exemple récapitulatif

```java
// Méthode générique qui retourne le plus grand élément d'une liste
public static <T extends Comparable<T>> T max(List<T> liste) {
    T max = liste.get(0);
    for (T elem : liste) {
        if (elem.compareTo(max) > 0) {
            max = elem;
        }
    }
    return max;
}

// Utilisation
List<Integer> entiers = Arrays.asList(3, 7, 2, 9, 5);
System.out.println(max(entiers)); // 9
```



## Réflexions sur les génériques

🌼 Le code générique nous permet de créer du code polyvalent et réutilisable qui peut fonctionner avec n'importe quel type en fonction de nos contraintes spécifiées. Cela minimise la duplication de code et transmet son objectif de manière plus abstraite.

🌼 Cependant, les génériques ne sont pas sans défauts. En Java, les génériques sont définitivement une fonctionnalité essentielle. Mais pour être honnête, leur mise en œuvre peut parfois sembler alambiquée et insuffisante, surtout par rapport à d’autres langages.

🌼 Pour les développeurs utilisant des API génériques, celles-ci sont généralement simples à utiliser et offrent des fonctionnalités substantielles. 

🌼 En revanche, l’écriture d’API génériques peut s’avérer plus difficile. Personnellement, j'apprécie l'idée de créer des outils puissants, mais complexes pour écrire du code sans imposer le même niveau de complexité à ceux qui utilisent le code.

🌼 Les concepteurs de langage doivent toujours faire des compromis et décider de leur priorité absolue. Et dans la bonne tradition Java, la rétrocompatibilité était une priorité absolue.

<hr>

[Lien vers statistiques langages de programmation 2024](https://spectrum.ieee.org/top-programming-languages-2024)

