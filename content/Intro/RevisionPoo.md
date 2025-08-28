+++
title = "Révision"
weight = 11
draft = false
+++


# Rappel : 

## Concepts de base

* **Classe** : Modèle définissant les attributs (variables) et comportements (méthodes).
* **Objet** : Instance concrète d’une classe.
* **Encapsulation** : Protéger les données via des **modificateurs d’accès** (`private`, `public`, `protected`) et exposer des méthodes d’accès (getters/setters).
* **Abstraction** : Masquer les détails d’implémentation et ne montrer que les fonctionnalités essentielles (via classes abstraites et interfaces).
* **Héritage** : Une classe peut hériter des attributs et méthodes d’une autre (mot-clé `extends`).
* **Polymorphisme** :

  * **Surcharge (overloading)** : même nom de méthode, signatures différentes.
  * **Redéfinition (overriding)** : une sous-classe redéfinit le comportement d’une méthode héritée.
* **Constructeur** : Méthode spéciale exécutée lors de la création d’un objet (`new`).


## Modificateurs d’accès

| Modificateur | Même classe | Même package | Sous-classe | Partout |
| ------------ | ----------- | ------------ | ----------- | ------- |
| `public`     | ✅           | ✅            | ✅           | ✅       |
| `protected`  | ✅           | ✅            | ✅           | ❌       |
| *(default)*  | ✅           | ✅            | ❌           | ❌       |
| `private`    | ✅           | ❌            | ❌           | ❌       |

## Syntaxe essentielle

### Définir une classe

```java
public class Voiture {
    private String marque;
    private int annee;

    public Voiture(String marque, int annee) {
        this.marque = marque;
        this.annee = annee;
    }

    public void demarrer() {
        System.out.println(marque + " démarre !");
    }
}
```

### Créer un objet

```java
Voiture v1 = new Voiture("Toyota", 2022);
v1.demarrer();
```

## Héritage et polymorphisme

```java
class Animal {
    public void parler() { System.out.println("??"); }
}

class Chien extends Animal {
    @Override
    public void parler() { System.out.println("Woof"); }
}

Animal a = new Chien(); // polymorphisme
a.parler(); // "Woof"
```

## Abstraction et interfaces

```java
abstract class Forme {
    abstract double aire();
}

class Cercle extends Forme {
    private double r;
    Cercle(double r) { this.r = r; }
    @Override double aire() { return Math.PI * r * r; }
}

interface Volant {
    void voler();
}

class Avion implements Volant {
    public void voler() { System.out.println("En vol ✈️"); }
}
```

## Classes utiles

* **`Object`** : classe racine de toutes les classes Java. Méthodes importantes :
  `toString()`, `equals()`, `hashCode()`, `clone()`.
* **`final`** :

  * `final class` : non-héritée.
  * `final method` : non-redéfinissable.
  * `final variable` : constante.

## Gestion mémoire

* Les objets sont créés sur le **tas (heap)** via `new`.
* Le **garbage collector** libère automatiquement la mémoire des objets non référencés.

## Bonnes pratiques

- Utiliser `private` pour protéger les données.
- Toujours redéfinir `toString()` pour représenter un objet.
- Respecter la cohérence `equals()` / `hashCode()`.
- Favoriser la composition plutôt que l’héritage trop profond.
- Documenter avec **JavaDoc** (`/** … */`).

## Exemple :
```java
package s01;

class Etudiant {
    private String nom;
    private int age;

    public Etudiant(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public void afficherInfos() {
        System.out.println("Nom : " + nom + ", Âge : " + age);
    }
}

class EtudiantRegulier extends Etudiant {
    private String programme;

    public EtudiantRegulier(String nom, int age, String programme) {
        super(nom, age);
        this.programme = programme;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Programme : " + programme);
    }
}

public class RappelPOO {
    public static void main(String[] args) {
        EtudiantRegulier e = new EtudiantRegulier("Alice", 20, "Informatique");
        e.afficherInfos();
    }
}

```

---

# 📘 Résumé de révision – POO

## 🔹 1. Classes

* Une **classe `public`** est accessible depuis n’importe quel package.
* Une **classe `abstract`** sert de modèle, ne peut pas être instanciée et peut contenir des méthodes abstraites.
* Une **classe `final`** ne peut pas être héritée.
* Une **classe `private`** n’est possible qu’en **classe interne** (nested class).
* Toute classe hérite implicitement de `Object` → possède donc les méthodes `toString()`, `equals()`, `hashCode()`, etc.


## 🔹 2. Constructeurs

* Si aucune déclaration → le compilateur génère un **constructeur par défaut** (sans paramètres).
* Un **constructeur peut être `private`** (utilisé dans le pattern Singleton ou classes utilitaires).


## 🔹 3. Méthodes

* Les méthodes peuvent être **surchargées (overloading)** → même nom, paramètres différents.
* Les méthodes peuvent être **surdéfinies (overriding)** → même signature, dans une sous-classe.
* Une méthode **`final`** ne peut pas être redéfinie dans une sous-classe.
* Une méthode **`abstract`** est déclarée sans corps et doit être implémentée dans une sous-classe.
* `abstract` et `final` sont **incompatibles** (contradiction).


## 🔹 4. Attributs

* Un attribut **`final`** est une **constante** : doit être initialisé une seule fois (déclaration ou constructeur).



## 🔹 5. Interfaces

* Une **interface** ne peut pas être instanciée.
* Une interface n’est pas un objet, c’est un **contrat**.
* Une interface **n’hérite pas d’`Object`**, mais les classes qui l’implémentent héritent d’`Object`.
* Une interface peut **hériter d’une ou plusieurs autres interfaces** avec `extends`.
* Une interface ne peut pas hériter d’une **classe**.
* Méthodes dans une interface :

  * Avant Java 8 → uniquement `public abstract`.
  * Depuis Java 8 → méthodes `default` et `static` avec implémentation.
  * Depuis Java 9 → méthodes `private` pour factoriser du code interne.



## 🔹 6. Comparable vs Comparator

* **Comparable** : définit l’ordre naturel d’une classe (méthode `compareTo`).
* **Comparator** : définit un ordre externe, peut être multiple et personnalisé (méthode `compare`).



## 🔹 7. Mots-clés spéciaux

* `null` → **valeur littérale spéciale**, pas un mot-clé.
* `this` → référence à l’instance courante.
* `super` → référence à la classe parente.



## Résumé

| Élément            | Description                            | Exemple                                            |
| ------------------ | -------------------------------------- | -------------------------------------------------- |
| Classe `abstract`  | Non instanciable, modèle pour héritage | `abstract class Forme { abstract double aire(); }` |
| Classe `final`     | Ne peut pas être héritée               | `final class Utilitaire {}`                        |
| Méthode `final`    | Ne peut pas être redéfinie             | `public final void calcul() {}`                    |
| Méthode `abstract` | Sans corps, à implémenter              | `abstract void afficher();`                        |
| Attribut `final`   | Constante, valeur fixée une seule fois | `final double PI = 3.14;`                          |
| Interface          | Contrat, non instanciable              | `interface Vehicule { void rouler(); }`            |
| Comparable         | Ordre naturel, `compareTo`             | `class Etudiant implements Comparable<Etudiant>`   |
| Comparator         | Ordre externe, `compare`               | `Comparator<Etudiant> parNom = ...;`               |



