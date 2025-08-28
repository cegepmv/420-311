+++
date = '2025-08-26T07:42:37-04:00'
draft = true
title = 'CorrectionExos'
+++

## Question 1
Réponse : 
```
1
```
## Question 2
Réponse : 
```
-1
```
## Question 3
Réponse : 
```
189
```
Le type est chaîne de caractère.
## Question 4
Réponse : 
```
BC
```
## Question 5
Réponse : 
```
false true
```
## Question 6
Réponse : 
```
12
```
## Question 7
Réponse : 
```
23
```
## Question 8
Réponse : 
```
49
```
## Question 9
Réponse : 
```
e
```
## Question 10
Réponse : 
```
ac
```
## Question 11
Réponse : 
```
10 5
```
## Question 12
Réponse : 
```

```
## Question 13
Réponse : 
```
7 9
```
## Question 14
Réponse : 
```
12345
```
## Question 15
Réponse : 
```
2 2 
```
## Question 16
Réponse : 
```
12345
```
## Question 17
Réponse : 
```
Exception
```
A est final. On ne peut pas hériter d'une classe final
## Question 18
Réponse : 
```
2
```
## Question 19
Réponse : 
```
6
7
```
## Question 20
Réponse : 
```
[1, 2, 3, 4, 5]
```
## Question 21
Réponse : 
```

```

## Quiz 1 : corrigé
| Question Vrai/Faux | OUI ✔ | NON ❌ | NSP ❗ | Explication |
|:---|:---:|:---:|:---:|:---|
|1-  Est-ce que je peux instancier une Interface? ❄️|   | ✔ |   | Une interface ne peut pas être instanciée directement, seulement implémentée par une classe. |
|2-  Est-ce qu'une interface est un objet? ⛄|   | ✔ |   | Une interface est un type, pas un objet ; seules les classes créent des objets. |
|3-  Est-ce qu’une interface hérite de la classe Object? ⚡|   | ✔ |   | Une interface ne dérive pas d’`Object`, mais toute classe qui l’implémente hérite d’`Object`. |
|4-  Est-ce qu’une interface peut hériter d'une autre interface? ☁️ | ✔ |   |   | Oui, une interface peut étendre une ou plusieurs interfaces avec `extends`. |
|5-  Est-ce qu’une interface peut hériter d'une classe? ☔|   | ✔ |   | Non, une interface ne peut hériter que d’autres interfaces, pas de classes. |
|6-  Est-ce qu'une classe peut-être « private »? 🌊|   | ✔ |   | Une classe ne peut pas être `private` au niveau top-level, seulement à l’intérieur d’une autre classe (classe interne). |
|7-  Est-ce que chaque classe Java possède la méthode « toString() »? ❄️| ✔ |   |   | Oui, car toutes les classes héritent implicitement de `Object` qui définit `toString()`. |
|8-  Est-ce que le constructeur d’une classe peut être « private »? ⛄| ✔ |   |   | Oui, utile pour restreindre l’instanciation (ex. classes utilitaires ou pattern Singleton). |
|9-  Est-ce que chaque classe Java possède un constructeur ⚡| ✔ |   |   | Oui, si aucun n’est défini, le compilateur fournit un constructeur par défaut. |
|10-  Dans une classe Java, est-ce que 2 méthodes peuvent avoir le même nom? ☁️| ✔ |   |   | Oui, grâce à la **surcharge** (méthodes avec paramètres différents). |
|11-  Est-ce qu’une interface peut hériter d'une autre interface? ☔ | ✔ |   |   | Oui, c’est un des principes d’extension d’interfaces en Java. |
|12-  Est-ce qu’une interface peut avoir des méthodes « private » avec du code? 🌊 | ✔ |   |   | Depuis Java 9, les interfaces peuvent avoir des méthodes `private` pour factoriser du code interne. |
|13-  Est-ce qu’une interface peut avoir des méthodes « public» avec du code? ❄️ | ✔ |   |   | Oui, depuis Java 8, les interfaces peuvent avoir des méthodes `default` ou `static` avec implémentation. |
|14-  Est-ce qu’une interface peut avoir des méthodes « private » avec du code? ⛄ | ✔ |   |   | Oui, confirmé : à partir de Java 9, les `private` methods dans une interface sont autorisées. |
|15-  Est-ce qu’une interface peut être instanciée? ⚡ |   | ✔ |   | Non, une interface ne peut pas être instanciée directement (mais peut être utilisée via une classe anonyme). |

---
## Quiz 2 : corrigé

| #  | Question                                                | Réponse                            |
| -- | ------------------------------------------------------- | ---------------------------------- |
| 1  | Méthode abstraite appelée depuis une non-abstraite ?    | ✔ Oui                              |
| 2  | Chaque méthode doit avoir un nom unique ?               | ❌ Non (overloading possible)       |
| 3  | Méthode `final static` redéfinissable ?                 | ❌ Non                              |
| 4  | Une méthode doit toujours avoir une visibilité ?        | ❌ Non (package-private par défaut) |
| 5  | Méthodes d’une interface = `public` obligatoirement ?   | ✔ Oui                              |
| 6  | `static public void main(String argsss[])` est valide ? | ✔ Oui                              |
| 7  | `abstract` et `final` ensemble ?                        | ❌ Non                              |
| 8  | Méthode `protected` dans une interface ?                | ❌ Non                              |
| 9  | `null` est un mot clé ?                                 | ❌ Non (c’est une valeur littérale) |
| 10 | Une interface peut hériter d’une autre ?                | ✔ Oui                              |

---

### ✅ Explications aux réponses aux questions

**1) Est-ce qu’une méthode abstraite peut être appelée à partir d'une méthode non abstraite ?**
✔ **Oui.**
Une méthode abstraite ne peut pas être appelée directement (car elle n’a pas de corps), mais si elle est implémentée dans une classe concrète, une méthode non abstraite peut l’appeler via le polymorphisme.


**2) Est-ce que chaque méthode dans une classe doit avoir un nom unique ?**
❌ **Non.**
On peut avoir plusieurs méthodes avec le **même nom** si elles ont des signatures différentes → c’est la **surcharge (overloading)**.


**3) Est-ce qu’une méthode déclarée « final static » peut être redéfinie dans une classe enfant ?**
❌ **Non.**

* `static` → pas d’héritage polymorphique (on peut seulement la masquer).
* `final` → empêche toute redéfinition.


**4) Est-ce qu’une déclaration de méthode doit toujours avoir une visibilité ?**
❌ **Non.**
Si aucune visibilité n’est spécifiée, la méthode a la **visibilité par défaut** (*package-private*).


**5) Est-ce que toutes les méthodes d’une interface doivent être obligatoirement « public » ?**
✔ **Oui.**
Par défaut, toutes les méthodes dans une interface sont `public abstract` (même si ce n’est pas écrit).


**6) `static public void main (String argsss[])` : est-ce que cette méthode «main » est correcte ?**
✔ **Oui.**
L’ordre des modificateurs (`static public` ou `public static`) n’a pas d’importance. Ce qui compte :

* `public static void main(String[] args)` (ou équivalent).


**7) Est-ce que l’on peut utiliser « abstract » et « final » dans la même signature de méthode ?**
❌ **Non.**

* `abstract` → la méthode doit être redéfinie.
* `final` → la méthode ne peut pas être redéfinie.
  ⚠️ Contradiction → interdit.


**8) Est-ce que je peux déclarer une méthode « protected » dans une interface ?**
❌ **Non.**
Les méthodes d’une interface sont forcément `public`. On ne peut pas les restreindre.


**9) Est-ce que « null » est un mot clé Java ?**
❌ **Non.**
`null` est une **valeur littérale**, pas un mot clé.


**10) Est-ce qu’une interface peut hériter d’une autre interface ?**
✔ **Oui.**
Une interface peut en **étendre une ou plusieurs autres** interfaces avec `extends`.

Exemple :

```java
interface A {
   void methodeA();
}

interface B extends A {
   void methodeB();
}
```

---
## Correction Quiz 2
| Question Vrai/Faux | OUI ✔ | NON ❌ | NSP ❗ |
|:---|:---:|:---:|:---:|
|1-  Est-ce que je peux instancier une Interface? ❄️|   | ✔ |   |
|2-  Est-ce qu'une interface est un objet? ⛄|   | ✔ |   |
|3-  Est-ce qu’une interface hérite de la classe Object? ⚡|   | ✔ |   |
|4-  Est-ce qu’une interface peut hériter d'une autre interface? ☁️ | ✔ |   |   |
|5-  Est-ce qu’une interface peut hériter d'une classe? ☔|   | ✔ |   |
|6-  Est-ce qu'une classe peut-être « private »? 🌊|   | ✔ |   |
|7-  Est-ce que chaque classe Java possède la méthode « toString() »? ❄️| ✔ |   |   |
|8-  Est-ce que le constructeur d’une classe peut être « private »? ⛄| ✔ |   |   |
|9-  Est-ce que chaque classe Java possède un constructeur ⚡| ✔ |   |   |
|10-  Dans une classe Java, est-ce que 2 méthodes peuvent avoir le même nom? ☁️| ✔ |   |   |
|11-  Est-ce qu’une interface peut hériter d'une autre interface? ☔ | ✔ |   |   |
|12-  Est-ce qu’une interface peut avoir des méthodes « private » avec du code? 🌊 | ✔ |   |   |
|13-  Est-ce qu’une interface peut avoir des méthodes « public» avec du code? ❄️ | ✔ |   |   |
|14-  Est-ce qu’une interface peut avoir des méthodes « private » avec du code? ⛄ | ✔ |   |   |
|15-  Est-ce qu’une interface peut être instanciée? ⚡ |   | ✔ |   |


---

## **THÉORIQUE 18**

👉 *Quelle est la différence entre une classe « public » et une classe « abstract » ?*

* **Classe `public`** :

  * Accessible depuis **n’importe quel autre package**.
  * Peut être instanciée si elle n’est pas `abstract`.
  * Ex. :

    ```java
    public class Etudiant {}
    ```

* **Classe `abstract`** :

  * Ne peut **pas être instanciée** directement.
  * Sert de **modèle** pour être héritée par d’autres classes.
  * Peut contenir des méthodes **abstraites** (sans corps).
  * Ex. :

    ```java
    public abstract class Forme {
        abstract double aire();
    }
    ```

✅ Différence : `public` → concerne la **visibilité** ; `abstract` → concerne la **capacité d’instanciation et d’héritage**.

---

## **THÉORIQUE 19**

👉 *Quelle est la différence entre l’interface `Comparable` et l’interface `Comparator` ?*

* **`Comparable<T>`** :

  * Définit un **ordre naturel** pour une classe donnée.
  * Méthode à implémenter : `compareTo(T o)`.
  * La classe elle-même définit son ordre.
  * Ex. :

    ```java
    public class Etudiant implements Comparable<Etudiant> {
        private int age;
        public int compareTo(Etudiant autre) {
            return this.age - autre.age;
        }
    }
    ```

* **`Comparator<T>`** :

  * Définit un ordre **extérieur** à la classe (plus flexible).
  * Méthode à implémenter : `compare(T o1, T o2)`.
  * Utile quand on veut plusieurs façons de trier une même classe.
  * Ex. :

    ```java
    Comparator<Etudiant> compareNom = (e1, e2) -> e1.nom.compareTo(e2.nom);
    ```

✅ Différence :

* `Comparable` → ordre **naturel**, défini dans la classe.
* `Comparator` → ordre **personnalisé**, défini à l’extérieur.

---

## **THÉORIQUE 20**

👉 *Quelle est la différence entre une classe `final`, une méthode `final` et un attribut `final` ?*

* **Classe `final`** :

  * Ne peut **pas être héritée**.
  * Ex. : `final class Math {}`

* **Méthode `final`** :

  * Ne peut **pas être redéfinie** (overridden) dans une sous-classe.
  * Ex. :

    ```java
    class A {
        public final void calcul() {}
    }
    ```

* **Attribut `final`** :

  * Doit être **initialisé une seule fois** (dans sa déclaration ou dans le constructeur).
  * Sa valeur ne peut pas être changée.
  * Ex. :

    ```java
    final double PI = 3.1416;
    ```

✅ Résumé :

* Classe `final` → pas d’héritage.
* Méthode `final` → pas de redéfinition.
* Attribut `final` → valeur constante.

---

## **THÉORIQUE 21**

👉 *Quel est le point commun entre une classe `abstract` et une classe `public` ayant des constructeurs `private` ?*

* **Classe `abstract`** :

  * Ne peut pas être instanciée directement.
  * Sert uniquement de **base** pour d’autres classes.

* **Classe `public` avec constructeur `private`** :

  * Ne peut pas être instanciée directement de l’extérieur non plus.
  * Exemple typique : classes utilitaires (`java.lang.Math`) ou **pattern Singleton**.

✅ **Point commun** :
Dans les deux cas, **on ne peut pas créer d’instance directement avec `new`**.
👉 Mais pour des raisons différentes :

* `abstract` → liée au concept d’héritage.
* `private constructor` → liée au contrôle d’instanciation.

---

# 📘 Fiche de révision – Questions théoriques Java

| # | Question | Réponse synthétique |
|---|----------|----------------------|
| 18 | Différence entre une classe `public` et une classe `abstract` ? | `public` = visibilité (accessible partout, instanciable). <br> `abstract` = modèle, non instanciable, sert à l’héritage. |
| 19 | Différence entre `Comparable` et `Comparator` ? | `Comparable` = ordre naturel défini **dans la classe** via `compareTo()`. <br> `Comparator` = ordre externe et **personnalisé** via `compare(o1, o2)`. |
| 20 | Différence entre classe `final`, méthode `final`, attribut `final` ? | Classe `final` = pas d’héritage. <br> Méthode `final` = pas de redéfinition. <br> Attribut `final` = valeur constante (assignée une seule fois). |
| 21 | Point commun entre une classe `abstract` et une classe `public` avec constructeurs `private` ? | Dans les deux cas, on **ne peut pas instancier** directement avec `new`. <br> `abstract` → héritage obligatoire. <br> `private constructor` → contrôle d’instanciation (ex. Singleton, classe utilitaire). |
