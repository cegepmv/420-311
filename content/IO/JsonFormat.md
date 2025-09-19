+++
date = '2025-09-19T11:51:10-04:00'
draft = false
title = 'Format JSON'
+++

# 📖 Le format JSON

## 1. Définition

* **JSON** est un format de texte standardisé pour représenter et échanger des données.
* Inspiré de JavaScript, mais **indépendant du langage** : tous les langages modernes (Java, Python, C#, PHP, etc.) peuvent le lire et l’écrire.
* Lisible par les humains, facile à traiter par les machines.

---

## 2. Structure du JSON

Le JSON est composé de deux structures principales :

1. **Objet (Object)** → une collection de paires **clé–valeur**

   ```json
   {
     "nom": "Alice",
     "age": 23,
     "etudiant": true
   }
   ```

2. **Tableau (Array)** → une liste ordonnée de valeurs

   ```json
   ["Java", "Python", "C++"]
   ```

---

## 3. Types de valeurs autorisés

* **String** : chaîne de caractères
* **Number** : entier ou décimal
* **Boolean** : `true` ou `false`
* **Null** : valeur nulle
* **Object** : `{ ... }`
* **Array** : `[ ... ]`

Exemple combinant plusieurs types :

```json
{
  "nom": "Bob",
  "age": 25,
  "competences": ["Java", "SQL", "Git"],
  "actif": true,
  "adresse": {
    "ville": "Montréal",
    "codePostal": "H2X 1Y4"
  }
}
```

---

## Exemple avec Jackson

En Java, on peut manipuler JSON avec des bibliothèques comme **Jackson** ou **Gson**.

### Exemple Objet Java → JSON et JSON → Objet Java

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExempleJackson1 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Client client = new Client(12345, "Dupont", "Alice", 2500.75);

        // Conversion Objet → JSON
        String json = mapper.writeValueAsString(client);
        System.out.println("Objet vers JSON : " + json);
    }
}
```
Résultat attendu : 
```json
{"numCompte":12345,"nom":"Dupont","prenom":"Alice","solde":2500.75}
```

```java
        String donnees = "{\"numCompte\":98765,\"nom\":\"Martin\",\"prenom\":\"Bob\",\"solde\":1500.0}";

        // Conversion JSON → Objet
        Client client1 = mapper.readValue(donnees, client1.class);
        System.out.println("Client : " + client1.getNom() + " " + client1.getPrenom() +
                           ", Compte : " + client1.getNumCompte() +
                           ", Solde : " + client1.getSolde());
```

Résultat attendu : 
```
Client : Martin Bob, Compte : 98765, Solde : 1500.0
```

### Lecture/écriture de fichier JSON

```java
// Écriture dans un fichier
mapper.writeValue(new FileInputStream("client.json"), client);

// Lecture depuis un fichier
Client client2 = mapper.readValue(new FileInputStream("client.json"), Client.class);
System.out.println("Nom lu depuis fichier : " + client2.getNom());
```

### tableau JSON

```java
String jsonArray = "[{\"numCompte\":111,\"nom\":\"Durand\",\"prenom\":\"Paul\",\"solde\":3000.0},"
                 + "{\"numCompte\":222,\"nom\":\"Moreau\",\"prenom\":\"Sophie\",\"solde\":4500.5}]";

Client[] clients = mapper.readValue(jsonArray, Client[].class);

for (Client c : clients) {
    System.out.println(c.getNumCompte() + " - " + c.getNom() + " " + c.getPrenom() + " : " + c.getSolde());
}

// créer un fichier json avec liste de clients
List<Client> listeClients = Arrays.asList(clients);
Client client = new Client(12345, "Dupont", "Alice", 2500.75);
listeClients.add(client)
mapper.writeValue(new FileInputStream("clients.json"), listeClients);

List<Client> clientsLus = mapper.readValue(new FileInputStream("clients.json"), new TypeReference<List<Client>>() {});
```

Résultat attendu : 
```
111 - Durand Paul : 3000.0
222 - Moreau Sophie : 4500.5
```

## 5. Avantages du JSON

* ✅ Lisible et léger
* ✅ Standard universel (API, configuration, échanges de données)
* ✅ Facile à convertir en objet dans la plupart des langages
* ✅ Support natif dans JavaScript (et simple en Java avec des bibliothèques)


## 6. Comparaison JSON vs XML

| Aspect       | JSON                          | XML                             |
| ------------ | ----------------------------- | ------------------------------- |
| Lisibilité   | Plus simple, léger            | Verbeux, balises lourdes        |
| Types natifs | String, Number, Boolean, etc. | Tout est texte                  |
| Usage        | APIs REST, stockage léger     | Données hiérarchiques complexes |

## 7. Cas d’utilisation typiques

* Communication entre client (front-end) et serveur (back-end) → **APIs REST**
* Stockage léger de configurations (`config.json`, `package.json`)
* Bases de données NoSQL (MongoDB utilise JSON comme format natif → BSON)


## Résumé

* JSON = format texte universel pour représenter des objets et des tableaux.
* Clés toujours entre guillemets (`"clé"`).
* Valeurs : string, number, boolean, null, object, array.
* Très utilisé dans les **APIs web** et les **bases NoSQL**.
* En Java → bibliothèques populaires : **Gson**, **Jackson**.

