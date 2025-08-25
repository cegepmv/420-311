+++
draft = true
title = 'ExoSupp'
+++


### Exercice 7 :
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

### Exercice 8 :
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

### Exercice 9 :
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

### Exercice 10 :
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

### Exercice 11 :
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

### Exercice 12 :
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

### Exercice 13 :
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

### Exercice 14 :
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

### Exercice 15 :
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
### Exercice 16 :
Quel est le résultat du code suivant:
```java

```

### Exercice 17 :
Quel est le résultat du code suivant:
```java

```

### Exercice 18 :
Quel est le résultat du code suivant:
```java

```

### Exercice 19 :
Quel est le résultat du code suivant:
```java

```

### Exercice 20 :
Quel est le résultat du code suivant:
```java

```

### Exercice 21 :
Quel est le résultat du code suivant:
```java

```

---

### Exercice 22 :
|Question Vrai/Faux|OUI ✔ |NON ❌|NSP ❗|
|:---|:---:|:---:|:---:|
|1-  Est-ce que je peux instancier une Interface? ❄️|  |  |  |
|2-  Est-ce qu'une interface est un objet? ⛄| |  |  |
|3-  Est-ce qu’une interface hérite de la classe Object? ⚡| |  |  |
|4-  Est-ce qu’une interface peut hériter d'une autre interface? ☁️ | |  |  |
|5-  Est-ce qu’une interface peut hériter d'une classe? ☔| |  |  |
|6-  Est-ce qu'une classe peut-être « private »? 🌊| |  |  |
|7-  Est-ce que chaque classe Java possède la méthode « toString() »? ❄️| |  |  |
|8-  Est-ce que le constructeur d’une classe peut être « private »? ⛄| |  |  |
|9-  Est-ce que chaque classe Java possède un constructeur ⚡| |  |  |
|10-  Dans une classe Java, est-ce que 02 méthodes peuvent avoir le même nom? ☁️| |  |  |
|11-  Est-ce qu’une interface peut hériter d'une autre interface? ☔ | |  |  |
|12-  Est-ce qu’une interface peut avoir des méthodes « private » avec du code? 🌊 | |  |  |
|13-  Est-ce qu’une interface peut avoir des méthodes « public» avec du code? ❄️ | |  |  |
|14-  Est-ce qu’une interface peut avoir des méthodes « private » avec du code? ⛄ | |  |  |
|15-  Est-ce qu’une interface peut être instanciée? ⚡ | |  |  |

# ✅ Quiz sur les méthodes et interfaces en Java

| #  | Questions                                                                 | Réponses |
|----|---------------------------------------------------------------------------|-----------|
| 1  | Est-ce qu’une méthode abstraite peut être appelée à partir d'une méthode non abstraite ? | Oui ☐ &nbsp; Non ☐ |
| 2  | Est-ce que chaque méthode dans une classe doit avoir un nom unique ?      | Oui ☐ &nbsp; Non ☐ |
| 3  | Est-ce qu’une méthode déclarée « final static » peut être redéfinie dans une classe enfant ? | Oui ☐ &nbsp; Non ☐ |
| 4  | Est-ce qu’une déclaration de méthode doit toujours avoir une visibilité ? | Oui ☐ &nbsp; Non ☐ |
| 5  | Est-ce que toutes les méthodes d’une interface doivent être obligatoirement « public » ? | Oui ☐ &nbsp; Non ☐ |
| 6  | `static public void main(String argsss[])` : est-ce que cette méthode « main » est correcte ? | Oui ☐ &nbsp; Non ☐ |
| 7  | Est-ce que l’on peut utiliser « abstract » et « final » dans la même signature de méthode ? | Oui ☐ &nbsp; Non ☐ |
| 8  | Est-ce que je peux déclarer une méthode « protected » dans une interface ? | Oui ☐ &nbsp; Non ☐ |
| 9  | Est-ce que « null » est un mot clé Java ?                                 | Oui ☐ &nbsp; Non ☐ |
| 10 | Est-ce qu’une interface peut hériter d’une autre interface ?              | Oui ☐ &nbsp; Non ☐ |


THÉORIQUE 18
Quelle est la différence entre une classe « public » et une classe « abstract »?
THÉORIQUE 19
Quelle est la différence entre l’interface « Comparable » et l’interface « Comparator »?
THÉORIQUE 20
Quelle est la différence entre une classe « final », une méthode « final » et un attribut « final »? 
THÉORIQUE 21
Quel est le point commun entre une classe « abstract » et une classe « public » ayant des constructeurs « private »?

