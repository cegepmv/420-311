+++
draft = false
title = '📝 Exercices : Collections en Java'
weight = 25
+++




## Étude de cas 1
Étude de cas 
Soit les classes suivantes avec leurs attributs successives : 

Classe Compagnie assurance :
-	numéro de la compagnie (unique), 
-	nom de compagnie, 
-	liste assurances : une collection d’assurances de type List.

Classe Assurance :
-	code d’assurance (unique), 
-	nom de l’assurance, 
-	prix de l’assurance, 
-	type d’assurance (Habitation, Auto ou Vie). 

Écrire en Java un programme qui permet la gestion de la compagnie d’assurance. Dans ce programme vous devez coder les méthodes suivantes:
1.	Afficher le chiffre d’affaires total de la compagnie (somme totale des assurances). 
2.	Afficher l’inventaire (la liste des assurances) de la compagnie triée en ordre décroissant de prix d’assurance (du plus grand vers le plus petit). 
3.	Convertir la liste lue en une collection de type Map (Integer, Assurance).
4.	Trier la Map par clé (numéro d’assurance).
5.	Parcourir la liste des assurances et modifier les prix des assurances comme suit : 
* Augmenter le prix de l’assurance habitation de 10%
* Diminuer le prix d’assurance auto de 8%
* Diviser le prix de l’assurance vie par :
    * 3 si le code d’assurance est impair.
    * 4 si le code d’assurance est pair.

## Étude de cas 2

La classe `Compte` possède les attributs suivants :

* `numCompte`
* `nom`
* `solde`

---

### Objectif

Mettre en pratique les notions liées aux **collections Java** :

* `List`
* `Set`
* `Map`

Vous devez coder les méthodes suivantes :

---

### 🔹 List

| Nom de la méthode | Description                                                                                 |
| ----------------- | ------------------------------------------------------------------------------------------- |
| `addCompteToList` | Permet de rajouter une instance de la classe `Compte` dans une collection de type `List`.   |
| `findCompte`      | Permet de rechercher une instance de la classe `Compte` dans une collection de type `List`. |
| `deleteCompte`    | Permet de supprimer une instance de la classe `Compte` dans une collection de type `List`.  |
| `emptyList`       | Permet de vider complètement une collection de type `List`.                                 |
| `sortList`        | Permet de trier une collection de type `List`.                                              |

---

### 🔹 Set

| Nom de la méthode | Description                                                                                |
| ----------------- | ------------------------------------------------------------------------------------------ |
| `addCompteToSet`  | Permet de rajouter une instance de la classe `Compte` dans une collection de type `Set`.   |
| `findCompte`      | Permet de rechercher une instance de la classe `Compte` dans une collection de type `Set`. |
| `deleteCompte`    | Permet de supprimer une instance de la classe `Compte` dans une collection de type `Set`.  |
| `emptySet`        | Permet de vider complètement une collection de type `Set`.                                 |
| `sortSet`         | Permet de trier une collection de type `Set`.                                              |

---

### 🔹 Map

| Nom de la méthode | Description                                                                                |
| ----------------- | ------------------------------------------------------------------------------------------ |
| `addCompteToMap`  | Permet de rajouter une instance de la classe `Compte` dans une collection de type `Map`.   |
| `findCompte`      | Permet de rechercher une instance de la classe `Compte` dans une collection de type `Map`. |
| `deleteCompte`    | Permet de supprimer une instance de la classe `Compte` dans une collection de type `Map`.  |
| `emptyMap`        | Permet de vider complètement une collection de type `Map`.                                 |
| `sortMap`         | Permet de trier une collection de type `Map`.                                              |


### ✅ À faire

* Coder les méthodes précédentes.
* Utiliser **JUnit** pour tester toutes les méthodes.
