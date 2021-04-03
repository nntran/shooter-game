echo "Start build project..."

SET OUT_CLASSES_DIR=classes
SET SRC_DIR=src/java
SET RESSOURCES_DIR=src/ressources

RMDIR %OUT_CLASSES_DIR% /s /q

REM Classes de bases des objets
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/Point.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/Objet.java

REM Armes 
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/Balle.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/Arme.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/Bomb.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/BombPlasma.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/Laser.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/BlasterAlphaX3.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/LanceMissiles.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/arme/Speciale.java

REM Avions
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/avion/Avion.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/objet/avion/RafaleF3R.java

REM Application
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/Scene.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/Controlleur.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%/fr/ntdt/game/shooter/App.java

echo "Finish!"