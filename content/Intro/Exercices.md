+++
draft = false
title = 'Exercices'
weight = 12
+++

##  Exercices théoriques

### Exercice 1 :

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

### Exercice 2 :
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

### Exercice 3 :
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
### Exercice 4 :
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

### Exercice 5 :
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

### Exercice 6 :
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

### Exercice 19 :
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

