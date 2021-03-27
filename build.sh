#!/bin/bash -eux

echo "Start build project..."

export OUT_CLASSES_DIR=classes
export SRC_DIR=src/java
export RESSOURCES_DIR=src/ressources

rm -rf $OUT_CLASSES_DIR

# Classes de bases des objets
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/Point.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/ObjetAnime.java

# Armes 
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/arme/Arme.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/arme/ArmeFactory.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/arme/impl/Bombe.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/arme/impl/Missile.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/arme/impl/Laser.java

# Avions
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/Avion.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/AvionFactory.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/impl/AvionChasse.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/impl/Rafale.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/impl/RafaleF3R.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/impl/Mirage.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/impl/Bombardier.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/impl/BombardierSpirit.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/impl/BombardierNighthawk.java

# Niveaux de jeu
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/niveau/Niveau.java

# Application
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/Scene.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/App.java

#cp -R $RESSOURCES_DIR 

echo "Finish!"