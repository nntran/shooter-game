#!/bin/bash -eux

echo "Start Game..."

export CLASSES_DIR=classes

java -cp $CLASSES_DIR fr/ntdt/game/shooter/App
