+++
draft = false
title = 'Comparable Vs Comparator'
weight = 23
+++


🌼 Différence entre L'interface Comparator et Comparable

🌼 Comparator et comparable sont deux interfaces de l'API Java.

🌼 Il est souvent nécessaire de trier les objets stockés dans des collections ou tableaux (Array). En utilisant ces 02 interfaces, objets Java peuvent être triés dans un ordre prédéfini .

* Comparator est défini dans le package java.util
* Comparable est défini dans le paquet java.lang 


## _Comparable_

🧭 Un objet implémentant Comparable est capable de se comparer avec un autre objet . La classe elle-même doit implémente l'interface java.lang.Comparable afin de comparer ses instances.

❓ Quand utiliser l'interface Comparable?

🧭 Si vous voulez trier une collection d'objets par une propriété particulière par défaut - par exemple: Vous avez une liste d'objets Employé et que vous voulez trier les objets par EmpID par défaut, vous pouvez utiliser comparable .

* java.lang.Comparable: int compareTo(Object obj1)

🥥 Cette méthode compare l'objet en cours à obj1 et retour un entier.

- Positive: l'objet courant est supérieur à obj1
- Zéro: l'objet courant est égal à obj1
- Négative: l'objet courant est inférieur à obj1


## Comparator

🍸 Un objet implémentant l'interface Comparator est capable de comparer deux objets différents. La classe ne compare pas ses instances, mais les instances d'autres classes.

❓ Quand utiliser interface Comparator?

🍸 Si vous voulez trier un objet suivant une propriété autre que celle par défaut, vous pouvez utiliser comparateur.

- java.util.Comparator: int compare(Object o1, Object o2)

🥥 Cette méthode compare o1 à o2 et retour un entier.

- Positive: o1 est supérieur à o2
- Zéro: o1 est égal à o2
- Négative: o1 est inférieur à o2

