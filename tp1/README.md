## TP 1 - Hello World

**Objectifs:**

* Apprendre à compiler du code Java
* Apprendre à executer une application Java


### Compiler l'application `Hello World`

Utilise la commande `javac` pour compiler un ou plusieurs fichiers Java en même temps.
Par défaut, la commande génère un fichier `*.class` par classe Java dans le même répertoire.
Il est conseillé de générer les fichiers compilés (`*.class`) dans un autre répertoire (ex: `classes`) via l'option `-d` ou `--directory`.

```
javac -d classes App.java
```

### Excuter l'application `Hello World`

Pour lancer une application Java, il faut utiliser la commande `java`. Si les classes ont été généré dans un répertoire dédié alors il faudra utiliser l'option `-cp` (class path) pour indiquer à Java ou se trouve les fichiers compilés.

```
java -cp classes App
```

