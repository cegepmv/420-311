+++ 
title = 'Structures de donnée' 
type = "home" 
+++

## Objectifs généraux du cours
Ce cours vous permettra de :
- Concevoir et programmer des applications en Java en utilisant les principales structures de données.

- Évaluer et comparer la complexité algorithmique des opérations (temps et mémoire).

- Utiliser des fils d’exécution (threads) pour exécuter plusieurs tâches en parallèle.

- Développer un esprit critique pour choisir la bonne structure et le bon paradigme selon le contexte.

## Pourquoi étudier les structures de données ?

- Parce qu’elles sont au cœur de la programmation : tout logiciel, du plus simple au plus complexe, repose sur des structures de données.

- Parce qu’elles permettent de réduire le temps d’exécution et économiser de la mémoire.

- Parce qu’elles développent la capacité à choisir la bonne approche selon un problème donné.

- Parce qu’elles forment une base solide pour les cours ultérieurs et pour travailler dans des projets d’envergure.

> Citation classique : « Un bon algorithme mal implanté dans une mauvaise structure de données sera inefficace.
Une bonne structure de données peut transformer un problème complexe en une solution élégante. »


## <ins>🌼 Notion de structure de données</ins>

Le principe de base d'une structure de données, c'est de stocker des éléments auxquels le programmeur veut pouvoir accéder plus tard. On appelle les différentes utilisations possibles de la structure de données des opérations.

## <ins>🌼 Les structures de données en Java</ins>

* Le langage Java a élargi et harmonisé la bibliothèque de classes utilitaires (java.util).
 
* On y trouve désormais des classes permettant de manipuler les principales structures de données, c’est-à-dire les vecteurs dynamiques, les ensembles, les listes chaînées, les queues et les tables associatives.

* Nous commencerons par examiner les concepts communs qu’elles (structures de données) exploitent ainsi : généricité, itérateur, ordonnancement et relation d’ordre. 

* Nous verrons également quelles sont les opérations qui leur sont communes : ajout ou suppression d’éléments, construction à partir des éléments d’une autre collection...

* Nous étudierons ensuite en détail chacune de ces structures, à savoir :

        🗝 Les listes, implémentées par la classe LinkedList;

        🗝 Les vecteurs dynamiques, implémentés par les classes ArrayList et Vector;

        🗝 Les ensembles, implémentés par les classes HashSet et TreeSet;

        🗝 Les queues avec priorité, implémentées par la classe PriorityQueue (introduite par le JDK 5.0) ;

        🗝 Les queues à double entrée, implémentées par la classe ArrayDeque (introduite par Java6).


![Java collection hierarchy](/420-311/images/Collection_Hierarchy.jpg)