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
