+++
date = '2025-09-16T09:34:50-04:00'
draft = false
title = 'Maven'
+++

# Maven (Project Managment Tool)

## Creation d'un projet maven:
Pour créer un projet maven on suit les étape suivantes :
- Dans IntelliJ cliquer sur create new project.
- Cette fois-ci ne pas choisir java mais __maven__.

![Créer projet maven step 1](/420-311/images/Maven_new_project_create_step_1.png)

- Vous pouvez cocher la case _Create from archetype_.
- Vous pouvez choisir maven-archetype-quickstart (dans notre cas pas besoin on va configurer notre projet par nous même).
- cliquez sur _next_.

![Créer projet maven step 2](/420-311/images/Maven_new_project_create_step_2.png)

- Vous pouvez spécifier le nom de votre projet, ça location. Vous pouves cliquer sur la flèche vers le bas pour afficher les champs qui permettent d'identifier notre programme de façon unique (comme un UID). Il est conseiller de les garder comme suggèrer sauf si vous voulez un nom différent pour votre application.

![Créer projet maven step 3](/420-311/images/Maven_quick_start_create_project.png)

- Cliquez sur _next_. 

![Créer projet maven final step](/420-311/images/Maven_new_project_create_final_step.png)

- cliquez sur _finish_. Un projet avec la structure suivante sera créé. Il faut respecter cette structure pour vos prochains projets avec maven.

![Structure projet maven](/420-311/images/Structure_de_base_projet_maven.png)

## Affichier la fenêtre maven 

![afficher fenetre maven](/420-311/images/Fenetre_maven_intelliJ.png)

Ici vous pouvez observer les .jar (dépendances télechargés) dans la section dependencies (une fois que vous avez ajouter au moins une dépendance, la section apparait).

Vous pouvez forcer le téléchargement des dépendances comme suit :
![Forcer téléchargement des dépendances](/420-311/images/Telechargement_dependencies_sources.png)


## Configurer l'exécution avec maven
- Dans __edit configuration__ ajouter une configuration et choisir au lieu application cette fois-ci __maven__.

![Configurer l'exécution de votre projet maven](/420-311/images/Configurer_run.png)

- L'onglet runner vous permet de spécifier la version SDK au runtime, vous pouvez la changer si ce n'est pas celle à laquelle que vous avez besoin.  

- Assuerz vous que votre version de compilateur dans pom.xml est compatible avec votre version au runtime.

## Visualisation des dépendences (graphique)

[Visulaliser le dépendances de votre projet maven](/420-311/images/Telechargement_dependencies_sources.png)


## Les liens Maven

### 1. Modèle du projet Maven pour la recherche dans Eclipse ou IntelliJ
       
```
maven-archetype-quickstart

org.apache.maven.archetypes:maven-archetype-quickstart

```

### 2. [Lien vers maven repository](https://mvnrepository.com/)

### 3. [Comment créer un projet Maven dans Eclipse](https://www.simplilearn.com/tutorials/maven-tutorial/maven-project-in-eclipse)

---
### <ins> 4. Les dépendances utiles

🌼 <u>Dépendance FasterXml pour les Jsons</u>
```
 <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-core</artifactId>
        <version>2.15.2</version>
      </dependency>

      <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.15.2</version>
      </dependency>
```
* **`jackson-core`** : gère la lecture et l’écriture de flux JSON (bas niveau).
* **`jackson-databind`** : permet de convertir automatiquement un objet Java en JSON (*sérialisation*) et un JSON en objet Java (*désérialisation*).
👉 Exemple :

    ```java
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(monObjet);  // Objet → JSON
    MonObjet obj = mapper.readValue(json, MonObjet.class);  // JSON → Objet
    ```
---

🌼 <u>Dépendance JUNIT 5  – Tests unitaires</u>
```
   <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
      </dependency>

      <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-params</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
      </dependency>
```
* **`junit-jupiter-api`** : fournit les annotations et l’API pour écrire des tests (`@Test`, `@BeforeEach`, etc.).
* **`junit-jupiter-params`** : permet de créer des tests paramétrés (tester plusieurs valeurs d’entrée avec un seul test).
    👉 Exemple :

    ```java
    @Test
    void additionTest() {
        assertEquals(4, 2 + 2);
    }
    ```
---

🌼 <u>Dépendance Apache Commons Lang </u>

```
   <dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.17.0</version>
</dependency>
```
* Ajoute des utilitaires pour manipuler **les chaînes de caractères, nombres, dates et objets**.
* Facilite des opérations répétitives comme `StringUtils.isEmpty()` ou `RandomStringUtils.randomAlphanumeric()`.

    👉 Exemple :

    ```java
    if (StringUtils.isBlank(nom)) {
        throw new IllegalArgumentException("Le nom ne peut pas être vide");
    }
    ```
---

🌼 <u>Dépendance Apache Commons IO</u>
```
  <dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.16.1</version>
</dependency>
```
* Fournit des utilitaires pour travailler avec **les fichiers, flux et chemins**.
* Simplifie les lectures/écritures et la copie de fichiers.

    👉 Exemple :

    ```java
    String contenu = FileUtils.readFileToString(new File("data.txt"), StandardCharsets.UTF_8);
    ```
---

🌼 <u>Dépendance Project Lombok</u>

```
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.34</version>
    <scope>provided</scope>
</dependency>
```

* Génére automatiquement du code répétitif (**getters, setters, constructeurs, `toString`…**) grâce à des annotations.
* Réduit la verbosité dans les classes Java.
    👉 Exemple :

    ```java
    @Data  // génère getters, setters, equals, hashCode, toString
    @AllArgsConstructor
    public class Etudiant {
        private int id;
        private String nom;
    }
    ```
---

🌼 <u>Dépendance Driver MariaDB</u>
```
  <dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <version>3.4.1</version>
</dependency>
```
* Permet de connecter une application Java à une base **MariaDB/MySQL** via JDBC.

    👉 Exemple :

    ```java
    Connection conn = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/maBase", "user", "password"
    );
    ```
---

🌼 <u>Dépendance Itext pdf</u>
```
   <dependency>
      <groupId>com.itextpdf</groupId>
      <artifactId>itextpdf</artifactId>
      <version>5.5.13.3</version>
    </dependency>

   <dependency>
      <groupId>com.lowagie</groupId>
      <artifactId>itext</artifactId>
      <version>2.1.7</version>
   </dependency>
```

* **`itextpdf`** : créer et manipuler des fichiers PDF.
* **`com.lowagie:itext`** : ancienne version, encore utilisée dans certains projets pour la compatibilité.

    👉 Exemple :

    ```java
    Document doc = new Document();
    PdfWriter.getInstance(doc, new FileOutputStream("fichier.pdf"));
    doc.open();
    doc.add(new Paragraph("Bonjour PDF !"));
    doc.close();
    ```
---

🌼 <u>Dépendance Java MAIL</u>
```
   <dependency>
      <groupId>com.sun.mail</groupId>
      <artifactId>javax.mail</artifactId>
      <version>1.6.0</version>
   </dependency>

    <dependency>
      <groupId>javax.activation</groupId>
      <artifactId>activation</artifactId>
      <version>1.1.1</version>
    </dependency>
```
* **`javax.mail`** : envoi et réception de mails via SMTP, POP3, IMAP.
* **`activation`** : permet de gérer les pièces jointes (MIME types).

    👉 Exemple :

    ```java
    MimeMessage message = new MimeMessage(session);
    message.setSubject("Bonjour");
    message.setText("Ceci est un test !");
    Transport.send(message);
    ```

---

🌼 <u>Dépendance Google ZXing – Code-barres / QR codes</u>
```
   <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>core</artifactId>
        <version>3.5.2</version>
    </dependency>

     <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>javase</artifactId>
        <version>3.5.2</version>
     </dependency>
```

* **`core`** : librairie principale pour générer et lire des codes-barres/QR codes.
* **`javase`** : intégration avec Java standard (Image I/O, BufferedImage).

    👉 Exemple :

    ```java
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix matrix = qrCodeWriter.encode("Hello", BarcodeFormat.QR_CODE, 200, 200);
    MatrixToImageWriter.writeToPath(matrix, "PNG", Path.of("qr.png"));
    ```

---

🌼 <u>Fix to slf4j (Simple Logger)</u>

```
     <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.21</version>
     </dependency>
```
* **`slf4j-simple`** : fournit une implémentation simple de SLF4J (Simple Logging Facade for Java).
* Sert à afficher des logs dans la console sans config lourde (utile en dev).

    👉 Exemple :

    ```java
    private static final Logger logger = LoggerFactory.getLogger(MaClasse.class);

    logger.info("Application démarrée");
    logger.error("Une erreur est survenue");
    ```

