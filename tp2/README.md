## TP 2 - Modélisation des classes

Traduire en langage Java le diagramme des classes ci-dessous.

![Swagger Open API](diagramme-classes.png)

**Objectifs:**

* Apprendre à concevoir des classes
* Apprendre à créer des constructeurs, données membres, typer les données, ...
* Apprendre à générer des getter/setter des données membres de d'une classe
* Apprendre à surcharger (override) la méthode `toString()` de la super classe `Object`


### Compiler l'application

Utilise la commande `javac` pour compiler un ou plusieurs fichiers Java en même temps.
Par défaut, la commande génère un fichier `*.class` par classe Java dans le même répertoire.
Il est conseillé de générer les fichiers compilés (`*.class`) dans un autre répertoire (ex: `classes`) via l'option `-d` ou `--directory`.

```
javac -d classes src/App.java src/Voiture.java src/Moteur.java src/Roue.java
```

### Excuter l'application

Pour lancer une application Java, il faut utiliser la commande `java`. Si les classes ont été généré dans un répertoire dédié alors il faudra utiliser l'option `-cp` (class path) pour indiquer à Java ou se trouve les fichiers compilés.

```
java -cp classes App
```

