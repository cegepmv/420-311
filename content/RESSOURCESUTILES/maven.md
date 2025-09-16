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
