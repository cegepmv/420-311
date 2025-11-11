+++
date = '2025-11-07T20:15:43-05:00'
draft = false
title = 'Introduction à JUnit'
weight = 71
+++


## Pourquoi des tests unitaires ?

* **Fiabilité** : on détecte les régressions dès qu’on modifie le code.
* **Confiance** : on peut refactorer sans crainte si la suite de tests reste verte.
* **Conception** : écrire un test oblige à clarifier l’API (entrées/sorties, cas limites).
* **Documentation vivante** : les tests montrent comment utiliser la classe.


## Qu’est-ce que JUnit 5 ?

JUnit 5 = **Plateforme + API de tests modernes** pour Java.

* **JUnit Platform** : lanceur, intégration IDE/CI.
* **JUnit Jupiter** : *API et moteur* de tests (ce qu’on utilise au quotidien).
* **JUnit Vintage** : compatibilité JUnit 3/4 (optionnel).

Vocabulaire utile :

* **Test** : méthode annotée `@Test`.
* **Fixture** : état/configuration nécessaire avant un test (ex. objets créés dans `@BeforeEach`).
* **Assertions** : vérifications (`assertEquals`, `assertThrows`, etc.).
* **Cycle de vie** : `@BeforeAll`, `@BeforeEach`, `@AfterEach`, `@AfterAll`.
* **Tags** : étiquettes pour filtrer des tests (`@Tag("integration")`).
* **Paramétrés** : un même test avec plusieurs jeux de données (`@ParameterizedTest`).

---

## Installer JUnit 5 dans un projet Maven (minimum viable)

```xml
<!-- pom.xml (extrait minimal) -->
<properties>
  <maven.compiler.release>17</maven.compiler.release>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <junit.jupiter.version>5.11.0</junit.jupiter.version>
  <surefire.version>3.5.0</surefire.version>
</properties>

<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>${junit.jupiter.version}</version>
    <scope>test</scope>
  </dependency>
</dependencies>

<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>${surefire.version}</version>
      <configuration>
        <useModulePath>false</useModulePath>
      </configuration>
    </plugin>
  </plugins>
</build>
```

Arborescence standard :

```
src
 ├─ main/java/...   (code applicatif)
 └─ test/java/...   (tests unitaires)
```


## Écrire son premier test

### Classe à tester (très simple)

```java
// src/main/java/com/exemple/Calculator.java
package com.exemple;

public class Calculator {
  public int add(int a, int b) { return a + b; }

  public int div(int a, int b) {
    if (b == 0) throw new ArithmeticException("division by zero");
    return a / b;
  }
}
```



### Test JUnit 5

```java
// src/test/java/com/example/CalculatorTest.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void addReturnsSum() {
    Calculator calculator = new Calculator();
    assertEquals(5, calculator.add(2, 3));
  }

  @Test
  void divideThrowsWhenDividingByZero() {
    Calculator calculator = new Calculator();
    ArithmeticException ex = assertThrows(
        ArithmeticException.class, () -> calculator.divide(1, 0));
    assertEquals("division by zero", ex.getMessage());
  }
}

```

Exécuter :

```bash
mvn test
```


## Cycle de vie (fixtures)

```java
// src/test/java/com/exemple/LifecycleIntroTest.java
package com.exemple;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LifecycleIntroTest {

  Calculator calc;

  @BeforeAll
  static void beforeAllSuite() {
    // Exécuté une fois avant tous les tests de la classe (static par défaut)
  }

  @BeforeEach
  void setUp() {
    calc = new Calculator(); // fixture : état prêt avant chaque test
  }

  @Test
  void addition() { assertEquals(7, calc.add(3, 4)); }

  @AfterEach
  void tearDown() {
    // Nettoyage après chaque test si nécessaire
  }

  @AfterAll
  static void afterAllSuite() {
    // Exécuté une fois après tous les tests de la classe
  }
}
```

Points clés :

* `@BeforeEach` prépare un **contexte propre par test** (pas de fuite d’état).
* `@BeforeAll/@AfterAll` conviennent pour des ressources globales (ex. démarrer un serveur embarqué).

---

## Assertions de base

```java
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

@Test
void assertionsBase() {
  assertEquals(42, 40 + 2, "Somme incorrecte");
  assertTrue("abc".startsWith("a"));
  assertNotNull(new Object());

  // Groupées (exécute tout, reporte toutes les erreurs)
  assertAll("utilisateur",
    () -> assertEquals("Ada", "Ada"),
    () -> assertTrue(3 > 1),
    () -> assertThrows(IllegalArgumentException.class, () -> { throw new IllegalArgumentException(); })
  );

  // Timeout (détecter une dérive de performance)
  assertTimeout(Duration.ofMillis(200), () -> {
    // opération censée être rapide
  });
}
```


## Noms, structure et style

* **Nommer clairement** : `ClasseTest` et méthodes `shouldDoXWhenY()` ou en français explicite.
* **1 idée = 1 test** : garder les tests courts et lisibles.
* **Cas limites** : penser `null`, collections vides, bornes min/max, division par zéro, etc.
* **Indépendance** : chaque test doit pouvoir s’exécuter seul, dans n’importe quel ordre.


## TDD (Tests Driven Development) : cycle rouge → vert → refactor

1. **Rouge** : écrire un test qui échoue (fonctionnalité absente).
2. **Vert** : implémenter le minimum pour le faire passer.
3. **Refactor** : améliorer le code en s’appuyant sur le filet de sécurité des tests.


## Mini-exercices

1. **Edge cases** : ajouter des tests pour `Calculator.add` avec des nombres négatifs et `Integer.MAX_VALUE`.
2. **Chaînes** : écrire un utilitaire `StringUtil.capitalize(String)` et tester `null`, vide, espaces, accents.
3. **Collections** : créer un `Directory` (Map) qui refuse les doublons et tester l’exception.



## Erreurs fréquentes (et solutions)

* *Les tests ne s’exécutent pas* : vérifier `maven-surefire-plugin` (≥ 2.22.0) et la dépendance `junit-jupiter`.
* *`@BeforeAll` non statique* : soit rendre la méthode `static`, soit annoter la classe avec `@TestInstance(PER_CLASS)`.
* *Flaky tests (aléatoires/temps)* : isoler l’heure/le hasard (injecter une `Clock`, fixer une seed).

## Tests avec différents types

### Types primitifs et chaînes

```java
// src/test/java/com/exemple/PrimitivesEtChainesTest.java
package com.exemple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimitivesEtChainesTest {

  @Test
  void entiersEtBooleens() {
    int a = 2, b = 3;
    assertEquals(5, a + b);
    assertTrue((a + b) > 0);
    assertFalse((a - b) > 0);
  }

  @Test
  void doublesEtDelta() {
    double x = 0.1 + 0.2; // précision binaire
    assertEquals(0.3, x, 1e-9); // tolérance
  }

  @Test
  void caracteres() {
    char c = 'A';
    assertEquals(65, (int) c);
    assertTrue(Character.isLetter(c));
  }

  @Test
  void chainesCaracteres() {
    String s = "  Bonjour  ";
    assertEquals("BONJOUR", s.trim().toUpperCase());
    assertTrue(s.contains("Bon"));
    assertEquals(10, s.trim().length());
  }
}
```


### Tableaux (arrays) et `Arrays`

```java
// src/test/java/com/exemple/ArraysTest.java
package com.exemple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class ArraysTest {

  @Test
  void comparaisonTableaux() {
    int[] a = {1, 2, 3};
    int[] b = {1, 2, 3};
    // Pour les tableaux, utiliser Arrays.equals
    assertTrue(Arrays.equals(a, b));
  }

  @Test
  void triEtRecherche() {
    int[] data = {5, 1, 4, 2};
    Arrays.sort(data);
    assertArrayEquals(new int[]{1, 2, 4, 5}, data);
    assertTrue(Arrays.binarySearch(data, 4) >= 0);
  }
}
```


### Collections de base : `List`, `Set`, `Map`

```java
// src/test/java/com/exemple/CollectionsTest.java
package com.exemple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CollectionsTest {

  @Test
  void listMutableEtLecture() {
    List<String> fruits = new ArrayList<>(List.of("pomme", "banane"));
    fruits.add("poire");
    assertEquals(3, fruits.size());
    assertEquals("banane", fruits.get(1));
    assertIterableEquals(List.of("pomme", "banane", "poire"), fruits);
  }

  @Test
  void setUniciteEtOrdre() {
    Set<String> tags = new HashSet<>();
    tags.add("java"); tags.add("java"); tags.add("junit");
    assertEquals(2, tags.size());         // unicité
    assertTrue(tags.contains("java"));
  }

  @Test
  void mapInsertionLectureValeurs() {
    Map<String, Integer> ages = new HashMap<>();
    ages.put("Alice", 30);
    ages.put("Bob", 25);
    assertEquals(2, ages.size());
    assertEquals(30, ages.get("Alice"));
    assertTrue(ages.containsKey("Bob"));
    assertTrue(ages.containsValue(25));
  }

  @Test
  void collectionsImmatEtVue() {
    var nonModifiable = List.of("a", "b");
    assertThrows(UnsupportedOperationException.class, () -> nonModifiable.add("c"));

    var vue = Arrays.asList("x", "y"); // taille fixe
    assertThrows(UnsupportedOperationException.class, () -> vue.add("z"));
    vue.set(0, "X");                   // mais remplaçable
    assertEquals(List.of("X", "y"), vue);
  }
}
```

### Dates & temps (API java.time)

```java
// src/test/java/com/exemple/DateTimeTest.java
package com.exemple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;

class DateTimeTest {

  @Test
  void localdateOperations() {
    LocalDate d = LocalDate.of(2025, 1, 15);
    assertEquals(DayOfWeek.WEDNESDAY, d.getDayOfWeek());
    assertEquals(LocalDate.of(2025,1,22), d.plusWeeks(1));
  }

  @Test
  void durationEtInstant() {
    Instant start = Instant.now();
    Instant end = start.plusSeconds(2);
    Duration dur = Duration.between(start, end);
    assertEquals(2, dur.getSeconds());
  }
}
```

### Objets : `equals`, `hashCode`, getters simples

#### Code de production

```java
// src/main/java/com/exemple/Person.java
package com.exemple;

import java.util.Objects;

public class Person {
  private final String firstName;
  private final String lastName;
  private final int age;

  public Person(String firstName, String lastName, int age) {
    if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("firstName");
    if (lastName == null || lastName.isBlank())   throw new IllegalArgumentException("lastName");
    if (age < 0)                                   throw new IllegalArgumentException("age");
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName(){ return firstName; }
  public String getLastName(){ return lastName; }
  public int getAge(){ return age; }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person p)) return false;
    return age == p.age &&
           Objects.equals(firstName, p.firstName) &&
           Objects.equals(lastName, p.lastName);
  }

  @Override public int hashCode() {
    return Objects.hash(firstName, lastName, age);
  }

  @Override public String toString() {
    return "%s %s (%d)".formatted(firstName, lastName, age);
  }
}
```

#### Tests unitaires simples sur l’objet

```java
// src/test/java/com/example/PersonTest.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  @Test
  void gettersReturnExpectedValues() {
    Person person = new Person("Ada", "Lovelace", 36);
    assertEquals("Ada", person.getFirstName());
    assertEquals("Lovelace", person.getLastName());
    assertEquals(36, person.getAge());
    assertTrue(person.toString().contains("Ada"));
  }

  @Test
  void equalsAndHashCodeAreConsistent() {
    Person p1 = new Person("Alan", "Turing", 41);
    Person p2 = new Person("Alan", "Turing", 41);
    Person p3 = new Person("Grace", "Hopper", 40);

    assertEquals(p1, p2);
    assertEquals(p1.hashCode(), p2.hashCode());
    assertNotEquals(p1, p3);
  }

  @Test
  void constructorValidatesArguments() {
    assertThrows(IllegalArgumentException.class, () -> new Person(null, "X", 1));
    assertThrows(IllegalArgumentException.class, () -> new Person("X", " ", 1));
    assertThrows(IllegalArgumentException.class, () -> new Person("X", "Y", -1));
  }
}

```

### Mini-service + test simple

#### Code de production

```java
// src/main/java/com/exemple/Directory.java
package com.exemple;

import java.util.*;

public class Directory {
  private final Map<String, Person> people = new HashMap<>();

  public void add(Person p) {
    if (p == null) throw new IllegalArgumentException("person null");
    people.put(p.getFirstName() + ":" + p.getLastName(), p);
  }

  public Optional<Person> find(String firstName, String lastName) {
    return Optional.ofNullable(people.get(firstName + ":" + lastName));
  }

  public int size() { return people.size(); }
}
```
[Optional ](https://www.baeldung.com/java-optional)

#### Test unitaire

```java
// src/test/java/com/exemple/DirectoryTest.java
package com.exemple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

  @Test
  void ajoutEtRecherche() {
    var d = new Directory();
    d.add(new Person("Alan", "Turing", 41));
    d.add(new Person("Grace", "Hopper", 40));

    assertEquals(2, d.size());
    assertTrue(d.find("Grace", "Hopper").isPresent());
    assertTrue(d.find("Alan", "Turing").isPresent());
    assertTrue(d.find("Ada", "Lovelace").isEmpty());
  }
}
```


### Commandes utiles

```bash
# Lancer tous les tests de la Partie 1
mvn test

# Lancer un test spécifique
mvn -Dtest=PersonTest test

# Lancer une méthode spécifique
mvn -Dtest=PersonTest#equalsHashCodeCoherents test
```

## Ressources 
[Documentation JUnit 5](https://docs.junit.org/current/user-guide/)

[Tutoriel JUnit 5](https://www.vogella.com/tutorials/JUnit/article.html)