+++
draft = false
title = 'Questions et exercices'
weight = 12
+++

##  Questions théoriques

### Question 1 :

Quel est le résultat du code suivant:
```java
public class Question1 {
	public static int methode1() {
		int i = 0;
		i++;
		return i;
	}

	public static void main(String[] args) {
		methode1();
		int j = 12;
		j = methode1();
		System.out.println(j);
	}
}
```

### Question 2 :
Quel est le résultat du code suivant:
```java
public class Question2 {
    public static void main (String[] args) {
		try {
                int i, sum;
                sum = 10;
                for (i = -1; i < 3 ;++i) {
                    sum = (sum / i);
                    System.out.println(i);
                }
		} catch(Exception e) {     	
			System.out.print("Erreur!");
		}	
	}
}
```

### Question 3 :
Quel est le résultat du code suivant:
```java
public class Question3 {

    public static void main(String[]args) {
        int val1 = 9;          
        int val2 = 9;         
        String str = "9";          
        System.out.println(val1 + val2 + str);	
    }
}
```
### Question 4 :
Quel est le résultat du code suivant:
```java
public class Question4 {

    public static void main(String[]args) {
        try {
            int a, b;
            b = 0;
            a = 5 / b;
            System.out.print("A");
        } catch (Exception e) {
            System.out.print("B");
        } finally {
            System.out.print("C");
        }	
    }
}
```

### Question 5 :
Quel est le résultat du code suivant:
```java
public class Question5 {
	public static void main(String[]args) {
		String obj = "Bonjour";
		String obj1 = "Bonsoir";   
		String obj2 = "Bonjour";
		System.out.println(obj.equals(obj1) + " " + obj.equals(obj2));
	}
}
```

### Question 6 :
Quel est le résultat du code suivant:
```java
public class ClasseA {

    public int i;
    public int j;
}

public class ClasseB extends ClasseA {

    public int j;
    public void afficheToi() {
        super.j = 3;
        System.out.println(i + " " + j);
    }
}

public class Question6 {

    public static void main(String[] args) {
	   
		ClasseB obj = new ClasseB();
		obj.i = 1;
		obj.j = 2;
		obj.afficheToi();
	}
}
```



### Question 7 :
Quel est le résultat du code suivant:
```java
public class ClasseA {

    public int i;
}

public class ClasseB extends ClasseA {

    public int j;
    public void afficheToi() {
        super.i = j + 1;
        System.out.println ( j + " " + i);
    }
}
public class Main {

    public static void main(String[] args) {
	
		ClasseB obj = new ClasseB();
		obj.i = 1;
		obj.j = 2;
		obj.afficheToi();
	}
}
```

### Question 8 :
Quel est le résultat du code suivant:
```java
public class Question8{
	public static void main(String[] args) {
        String s = "Hello World";
        int A = s.indexOf('o');
        int B = s.lastIndexOf('l');
        System.out.println(A + " " + B);
	}
}
```

### Question 9 :
Quel est le résultat du code suivant:
```java
public class Question9{
	public static void main(String[] args) {
        char ch;
        ch = "hello".charAt(1);
        System.out.println(ch);     
	}
}
```

### Question 10 :
Quel est le résultat du code suivant:
```java
public class Question10{
	public static void main(String[] args) {
        String chars[] = {"a", "b", "c", "a", "c"};
        for (int i = 0; i < chars.length; ++i)
        for (int j = i + 1; j < chars.length; ++j)
        if(chars[i].compareTo(chars[j]) == 0)
            System.out.print(chars[j]); 
     
	}
}
```

### Question 11 :
Quel est le résultat du code suivant:
```java
public class Question11{
	public static void main(String[] args) {
        int a1[] = new int[10];
		int a2[] = { 1, 2, 3, 4, 5 };
		System.out.println(a1.length + " " + a2.length);
	}
}
```

### Question 12 :
Quel est le résultat du code suivant:
```java
public class Question12{
	public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < arr.length - 2; ++i)
	    System.out.print(arr[i] + " ");      
	}
}
```

### Question 13 :
Quel est le résultat du code suivant:
```java
public class Question13{
	public static int param1;
	public static int param2;

	public void add(int a, int b) {
		param1 = a + b;
		param2 = param1 + b;
	}

	public static void main(String args[]) {
		Question13 obj1 = new Question13();
		Question13 obj2 = new Question13();
		int a = 2;
		obj1.add(a, a + 1);
		obj2.add(5, a);
		System.out.println(obj1.param1 + " " + obj2.param2);
	}
}
```

### Question 14 :
Quel est le résultat du code suivant:
```java
import java.util.Arrays;

public class Question14{
	public static void main(String[] args) {
        int tab[] = new int[5];
		for (int i = 5; i > 0; i--) {
			tab[5 - i] = i;
		}
		Arrays.sort(tab);
		for (int i = 0; i < 5; ++i) {
			System.out.print(tab[i]);
	    }     
	}
}
```

### Question 15 :
Quel est le résultat du code suivant:
```java
public class Question15{
	public static int param1;

	public void increment() {
		param1++;
	}

	public static void main(String args[]) {

		Question15 obj1 = new Question15();
		Question15 obj2 = new Question15();
		obj1.param1 = 0;
		obj1.increment();
		obj2.increment();
		System.out.println(obj1.param1 + " " + obj2.param1);
	}
}
```
### Question 16 :
Quel est le résultat du code suivant:
```java
import java.util.Arrays;

public class Question16 {
    public static void main(String args[]) {
		int tab[] = new int[5];
		for (int i = 5; i > 0; i--) {
			tab[5 - i] = i;
		}
		Arrays.sort(tab);
		for (int i = 0; i < 5; ++i) {
			System.out.print(tab[i]);
	     }
           }

}
```

### Question 17 :
Quel est le résultat du code suivant:
```java
public class Question17 {
    public static void main(String[] args) {
        ClasseB classeB = new ClasseB();
            
        System.out.println("Valeur = " + classeB.calculer(3, 6));
    }
}

class ClassA {
            
    final public int calculer(int a, int b) {
        return 0;
    }
}

class ClasseB extends ClasseA {

	public int calculer(int a, int b) {
		return 1;
	}
}
```

### Question 18 :
Quel est le résultat du code suivant:
```java
public class Question18 {
    public static void main (String args[]) {
        int param1, param2= 1;
       param1= 10;
       if (param1!= 10 && param1/ 0 == 0) {
           System.out.println(param2);
       }
       else {
          System.out.println(++param2);
       }
            }

}
```

### Question 19 :
Quel est le résultat du code suivant:
```java
public class Question19 {
    public static int param1;
    public static int param2;
  
    public void add(int val1, int val2) {
      param1 = val1 + val2;
      param2 = param1 + val2;
    }
    
    public static void main(String[] args) {
        Question19 instance1 = new Question19 ();
        Question19 instance2 = new Question19 ();
        Question19 instance3 = new Question19 ();
        int abc = 2;		
        instance1.add(abc, abc-1);
        instance3.add(6, 6/abc);
        instance2.add(5, abc/2);
        System.out.println(instance1.param1);
        System.out.println(instance2.param2);
    }
}
```

### Question 20 :
Quel est le résultat du code suivant:
```java
import java.util.Arrays;

public class Question20 {
    public static void main(String args[]) {
        int array[] = new int [5];
        for (int i = 5; i > 0; i--) {
            array[5 - i] = i;
        }
        Arrays.sort(array);
        System.out.print(Arrays.toString(array));
    }
}
```

### Question 21 :
Quel est le résultat du code suivant:
```java
public class Question21 {
    public static void main(String [] args) {
        Question21 instance = new Question21();
                 instance.myMethod();
    }

    public void myMethod(){
        long [] tab1 = {6,8,9};
        long []tab2 = affectation(tab1);
        System.out.print(tab1[0] + tab1[1] + tab1[2] + " ");
        System.out.println(tab2[0] + tab2[1] + tab2[2]);
    }

    public long[] affectation(long[] tab3){
        tab3[1] = 7;
        return tab3;
    }
}
```
---
## Exercices pratiques
---
### Exercice 1 :
Soit la String suivante: __A-b-C-d-E-f-1234-***///->__ , écrire un programme en Java qui:
- 👍 convertit chaque caractère alphabétique majuscule de la String en un caractère minuscule;
- 👍 Convertis chaque caractère alphabétique minuscule de la String en un caractère majuscule;
- 👍 Supprime tous les caractères spéciaux de la String;


### Exercice 2 :
Soit le tableau suivant: `String [] days = { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};`
Écrire un programme en Java qui:
- 👍 choisi aléatoirement une journée du tableau et l'affiche;
- 👍 Tri le tableau;


### Exercice 3 :
Soit le code Java suivant: 

```java
String str1 = "Bonjour";
String str2 = new String ("Bonjour");
str1 == str2;  //3
str1.equals(str2); //4
```

Expliquez la différence entre les 02 lignes de code (ligne 3 et ligne 4)?

### Exercice 4 :
Soit la classe Compte bancaire avec les attributs suivants:
- idCpte (numéro unique: donc 2 comptes ne peuvent pas avoir le même ID);
- firstName;
- lastName;
- solde;

En utilisant les collections Java (List, Set et Map) et en vous utilisant l'API Java, vous devez coder les méthodes suivantes:

	👍 addCompteToCollection (List | Set | Map)
	👍 serachCompteInCollection (List | Set | Map)
	👍 sortCollection (List | Set | Map)
	👍 removeCompteFromCollection (List | Set | Map)
	👍 emptyCollectionComptes (List | Set | Map)


### Exercice 5 :
- Écrire un code Java qui convertit un tableau d'entiers (tableau à crochets) en une collection de type List.

- Écrire un code Java qui convertit une collection de type List en un tableau à crochets.

- Écrire un code Java qui convertit une collection de type List en une collection de Type Set.

- Écrire un code Java qui convertit une collection de type Set en une collection de Type List.

- Écrire un code Java qui convertit une collection de type List en une collection de Type Map.

- Écrire un code Java qui convertit une collection de type Map en une collection de Type List.


### Exercice 6 :

Soit le tableau de conversion des devises suivant :

| De                     | Vers                   | Taux                  |
|-------------------------|------------------------|-----------------------|
| Dollar canadien (CAD)   | Euro                   | 1 CAD = 0.74 EURO     |
| Dollar canadien (CAD)   | Dollar américain (USD) | 1 CAD = 0.69 USD      |
| Euro                    | Dollar canadien (CAD)  | 1 EURO = 1.45 CAD     |
| Dollar américain (USD)  | Dollar canadien (CAD)  | 1 USD = 1.36 CAD      |


Écrire un programme Java qui demande à un utilisateur de choisir un type conversion et saisir un montant à convertir. Le programme traitera la conversion et affichera le montant converti.

Condition:
- Le programme n’acceptera que les montants entre 90 et 6500, cela dans chaque sorte de devises.
- Le programme ne doit pas s’arrêter tant que l’utilisateur n’aura pas choisi de quitter.


### Exercice 7 :
Soit le système de notation universitaire : 

| Note numérique | Note littérale |
|----------------|----------------|
| 90 et +        | A              |
| De 80 à 89     | B              |
| De 70 à 79     | C              |
| De 60 à 69     | D              |
| De 50 à 59     | E              |
| < 50           | F              |


Écrire un programme Java qui demande à un utilisateur de saisir 4 notes numériques. Ensuite le programme calculera la moyenne et affichera la note littérale correspondante.

**Condition**:

Le programme n’acceptera que les notes entre 0 et 100.

**Exemple**

Le programme demande les notes à l’utilisateur : Veuillez saisir vos notes Svp :
L’utilisateur saisit les notes suivantes : `59, 72.5, 83.73, 45.5`

Le programme calculera la moyenne et affichera :

**`Votre moyenne numérique est : 65,18 ce qui donnera en littérale la note de D.`**



### Exercice 8 :
Soit la liste des villes suivantes : Ottawa, Paris, Berne, Washington, Berlin, Madrid, Mexico.

🌼 Écrire un programme Java qui génère aléatoirement 2 villes parmi la liste des villes et demandera à un utilisateur de deviner les 2 villes au bout de 3 tentatives.
- Si l’utilisateur arrive à deviner les 2 villes aléatoires, le programme affichera un message et quittera.
- Si l’utilisateur n’arrive pas à deviner les 2 villes aléatoires au bout de 3 tentatives, le programme affichera le résultat et quittera. 

Clarification
- Modèle de message en cas de succès de devinette
	- Bravo! Vous avez deviné les 2 villes : Ottawa et Paris.
- Modèle de message en cas d’échec de devinette
	- Oups! En 3 tentatives, vous n’êtes pas arrivé à deviner les 2 villes : Ottawa et Paris.


### Exercice 9 :
On souhaite gérer une liste de prénoms d’étudiants dans un cours.
Réalise un programme Java qui :

- Crée une liste de type ArrayList<String>.
- Ajoute les prénoms suivants : "Alice", "Bob", "Charlie", "Diane".
- Affiche la taille de la liste et son contenu.
- Demande à l’utilisateur d’entrer un prénom, puis :
	- Vérifie s’il est présent dans la liste (affiche un message approprié).
	- Si présent, affiche sa position dans la liste.
- Supprime un prénom donné par l’utilisateur et réaffiche la liste.
- Trie la liste par ordre alphabétique et affiche le résultat.

### Exercice 10 :
Soit le diagramme de classes suivant :

![diagramme UML](/420-311/images/intro_exo_8_diagram.jpg)

1.	Créer les classes Java correspondant aux classes du diagramme. Il vous faudra respecter les attributs et les relations entre les différentes classes. 
2.	Écrire une méthode de service qui permet de calculer le prix réel d’un produit suivant la règle suivante : 
	- a.	Si le produit est biologique, « indiceBio » et le produit appartiennent à un fournisseur habitant la province du « Québec », alors le prix réel est :
	
			i.	Prix réel = prix du produit + prix du produit*tps + prix du produit * tvq. 

	- b.	  Si le produit est biologique, « indiceBio » et le produit appartiennent à un fournisseur habitant le Canada (sauf la province du Québec) alors le prix réel est :
	
			i.	Prix réel = prix du produit + prix du produit*tps. 

	- c.	  Si le produit est biologique « indiceBio » et le produit appartient à un fournisseur habitant les USA alors le prix réel est :
			
			i.	Prix réel = prix du produit + prix du produit*usTax. 
3.	Écrire une méthode de service qui permet de calculer le total prix (la somme totale) des produits de tous les fournisseurs américains. 

### Exercice 11 :
Soit la String suivante: String chaineDepart = "$_%4*1;-0er2bo%t?c(o(id>er7dn1ev"
écrire le programme qui traite l’algorithme suivant:
1.	Lire la String « chaineDepart »
2.	Parcourir la String et appliquer le traitement suivant:
* Mettre les 04 premiers caractères dans une Stack (appelée stack01);
* Mettre les 04 caractères suivants dans une liste (appelée liste01);
* Mettre les 04 caractères suivants dans un vecteur (appelée vecteur01);
* Mettre le reste de la chaine dans une Queue (appelée queue01);
* Déclarer un String vide appelé resultat01;
* Déclarer un String vide appelé resultat02;
* Dépilez le  premier élément de la stack01 et ajoutez-le à la String resultat01;
* Ajouter à la String resultat01, le 2e qui se trouve dans liste01;
* Parcourez le vecteur01, si l’élément est un chiffre, mettez-le dans la String resultat01, sinon mettez-le dans la String resultat02;
* Défiler la queue01, mettez seulement les lettres alphabétiques dans la String resultat02.
* Inversez les 02 Strings;
* Déclarer un String vide appelé resultatFinal;
* Copiez les 08 premiers caractères de la String resultat02 dans la String resultatFinal;
* Ajoutez un espace à la String resultatFinal;
* Copiez les 02 premiers éléments de la String resultat01 dans la String resultatFinal;
* Ajoutez un espace à la String resultatFinal;
* Copiez le reste des caractères de la String resultat02 dans la String resultatFinal;
* Ajoutez un espace à la String resultatFinal;
* Copiez le reste des caractères de la String resultat01 dans la String resultatFinal;
* Afficher le résultat;  
