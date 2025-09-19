+++
date = '2025-09-19T09:47:47-04:00'
draft = false
title = '📖 L’API Java I/O (Input / Output)'
+++


## Définition

L’API **I/O (Input/Output)** de Java permet de gérer les **flux de données** (*streams*), c’est-à-dire la lecture (Input) et l’écriture (Output) de données vers :

* le clavier et l’écran (console),
* les fichiers (texte ou binaire),
* le réseau,
* la mémoire.

> Tout en Java I/O est basé sur la notion de **flux**.


## Les flux (Streams)

Un **flux** est une **séquence d’octets ou de caractères** qui circule entre une source (input) et une destination (output).

### Types de flux

1. **Flux de bytes (8 bits)** → pour les fichiers binaires (images, sons, etc.)

   * `InputStream` (lecture)
   * `OutputStream` (écriture)

2. **Flux de caractères (16 bits)** → pour les fichiers texte (compatibles Unicode)

   * `Reader` (lecture)
   * `Writer` (écriture)

## Les classes de lecture et d'écriture

### Hiérarchie principale

#### Pour les bytes :

* `FileInputStream` / `FileOutputStream`
* `BufferedInputStream` / `BufferedOutputStream`

#### Pour les caractères :

* `FileReader` / `FileWriter`
* `BufferedReader` / `BufferedWriter`
* `PrintWriter`

### Les classes de lecture : Reader, InputStreamReader, FileReader et BufferedReader 

**Reader** est la classe abstraite pour la lecture des flux de caractères.  
Elle met en œuvre les méthodes fondamentales suivantes :  

- `read()` : lit un caractère unique.  
- `read(char[])` : lit un tableau de caractères.  
- `skip(long)` : ignore certains caractères.  
- `close()` : ferme le flux.  

**InputStreamReader** est un pont entre les flux d'octets et les flux de caractères.  
Il convertit des octets en caractères à l'aide d'un jeu de caractères spécifié (**charset**).  

- Le jeu de caractères peut être celui par défaut du système d'exploitation,  
  ou être spécifié explicitement lors de la création d’un `InputStreamReader`.  

**FileReader** est une classe pratique pour lire des fichiers texte en utilisant  
le codage de caractères par défaut du système d'exploitation.  

**BufferedReader** lit le texte d'un flux de caractères **avec efficacité**  
(les caractères sont mis en mémoire tampon pour éviter de lire fréquemment le flux sous-jacent).  

- Fournit une méthode pratique pour lire une ligne de texte : `readLine()`.  

> *Le diagramme suivant montre la relation de ces classes de lecture dans le package `java.io`.*  

```
Reader
 |_ InputStreamReader
 |       |_ FileReader
 |_ BufferedReader           
```

### Les classes d’écriture : Writer, OutputStreamWriter, FileWriter et BufferedWriter  

**Writer** est la classe abstraite pour l'écriture de flux de caractères.  
Elle met en œuvre les méthodes fondamentales suivantes :  

- 👍 `write(int)` : écrit un seul caractère.  
- 👍 `write(char[])` : écrit un tableau de caractères.  
- 👍 `write(String)` : écrit une chaîne de caractères.  
- 👍 `close()` : ferme le flux.  

**OutputStreamWriter** est un pont entre les flux d'octets et les flux de caractères.  
Les caractères sont codés en octets à l’aide d’un jeu de caractères spécifié.  

- 👍 Le jeu de caractères peut être celui par défaut du système d'exploitation,  
  ou être spécifié explicitement lors de la création d’un `OutputStreamWriter`.  

**FileWriter** est une classe pratique pour écrire des fichiers texte  
en utilisant le codage de caractères par défaut du système d'exploitation.  

**BufferedWriter** écrit du texte dans un flux de caractères **avec efficacité**  
(les caractères, tableaux et chaînes sont mis en mémoire tampon pour éviter d'écrire trop souvent sur le flux sous-jacent).  

- 👍 Fournit une méthode pratique pour écrire un séparateur de ligne : `newLine()`.  

> *Le diagramme suivant montre la relation de ces classes d’écriture dans le package `java.io`.*  
```
Writer
 |_ OutputStreamWriter
 |       |_ FileWriter
 |_ BufferedWriter           
```

## Exemples

### Exepmle de lecture d’un fichier texte

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectureFichier {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Dans cet exemple, `BufferedReader` lit un fichier texte **ligne par ligne**.


### Exepmle d'écriture dans un fichier texte

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EcritureFichier {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("sortie.txt"))) {
            bw.write("Bonjour, monde !");
            bw.newLine();
            bw.write("Deuxième ligne.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Dans cet exemple, `BufferedWriter` permet d’écrire efficacement dans un fichier.

## 6. Exemple : copier un fichier binaire (image)

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopierFichier {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("image.png");
             FileOutputStream out = new FileOutputStream("copie.png")) {

            byte[] buffer = new byte[1024];
            int bytesLus;
            while ((bytesLus = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesLus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

➡️ Utilise un **buffer** pour optimiser la lecture/écriture d’un fichier binaire.


## 7. Entrées/sorties standard

* `System.in` → flux d’entrée standard (clavier).
* `System.out` → flux de sortie standard (console).
* `System.err` → flux d’erreurs.

Exemple :

```java
import java.util.Scanner;

public class ExempleIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre nom : ");
        String nom = sc.nextLine();
        System.out.println("Bonjour " + nom);
    }
}
```

## 8. Sérialisation d’objets

L’API I/O permet aussi de **sauvegarder des objets** avec `ObjectOutputStream` et `ObjectInputStream`.

```java
import java.io.*;
import java.util.ArrayList;

public class SauvegardeObjets {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            ArrayList<String> liste = new ArrayList<>();
            liste.add("Alice");
            liste.add("Bob");
            out.writeObject(liste);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 9. Résumé

* **Input/Output** = gestion des flux (bytes ou caractères).
* **Lecteurs/Écrivains (Reader/Writer)** → texte.
* **InputStream/OutputStream** → données binaires.
* Toujours utiliser des **buffers** pour optimiser les performances.
* Penser à **fermer les flux** (`close()` ou try-with-resources).
