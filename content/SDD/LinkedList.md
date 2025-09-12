+++
draft = false
title = 'Algorithmes codage de la liste doublement chaînée'
weight = 23
+++

🌼 Pour coder une liste doublement chaînée en orientée objet, on doit coder :

## La classe Lien ou Nœud
* Nous n’allons pas utiliser la notion de générique. 
* La classe Lien ou nœud possède les champs suivants :
    * Suivant de type Lien ou Nœud;
    * Précédent de type Lien ou Nœud;
    * Valeur de type entier.
* La classe Lien ou nœud possède les méthodes suivantes:
    * Constructeur avec un paramètre qui sera la valeur;
    * Getter/Setter pour les champs;
    * Méthode d’affichage de la valeur.
## La classe ListeDoublementChainee
* Les champs de la classe :
    * Premier de type Lien ou Nœud;
    * Dernier de type Lien ou Nœud.
Les méthodes:
* Un constructeur sans paramètres : ou il faut mettre Premier et Dernier à NULL;
* Une méthode booléenne estVide () : qui teste si Premier est NULL;
```java
Une méthode : public void insererEnDebutListe (int valeur) {
    Déclarer un nouveau Lien et lui passer la valeur en paramètres de la méthode;
    Si la liste estVide (){
        Dernier = nouveauLien;
    }
    Sinon {
        Premier.Precedent = nouveauLien;
        nouveauLien.suivant = Premier;
    }
    Premier = nouveauLien;
}

```

```java
Une méthode : public void insererEnFinDeListe (int valeur) {
    Déclarer un nouveauLien et lui passer la valeur en paramètres de la méthode;
    Si la liste estVide (){
        Premier = nouveauLien;
    }
    Sinon {
        Dernier.suivant = nouveauLien;
        nouveauLien.precedent = Dernier;
    }
    Dernier = nouveauLien;
}
```

```java
public boolean insererApresValeur (int valeurPosition, int valeurAInserer) {
    Lien courant = premier;
    Tant que (courant.valeur n’est pas égale à valeurPosition){
        courant = courant.suivant;
        si (courant est NULL) {
            retourner FALSE;
        }
        Déclarer un nouveauLien et lui passer la valeurAInserer en paramètres de la méthode;
        Si (courant = Dernier){
            nouveauLien.suivant = null;
            dernier = nouveauLien;
        }
        Sinon {
            nouveauLien.suivant = courant.suivant;
            courant.suivant.precedent = nouveauLien;
        }
        nouveauLien.precedent = courant;
        courant.suivant = nouveauLien;
        retourner true; // on a trouvé, on insére "valeurAInserer"
    }
}
```