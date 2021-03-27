#!/bin/bash -eux

echo "Start build project..."

export OUT_CLASSES_DIR=classes
export SRC_DIR=src/java
export RESSOURCES_DIR=src/ressources

rm -rf $OUT_CLASSES_DIR

# Classes de bases des objets
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/Point.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/Objet.java

# Armes 
# javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/arme/Arme.java

# Avions
# javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/objet/avion/Avion.java

# Application
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/Scene.java
javac -d $OUT_CLASSES_DIR -cp $OUT_CLASSES_DIR $SRC_DIR/fr/ntdt/game/shooter/App.java

#cp -R $RESSOURCES_DIR 

echo "Finish!"