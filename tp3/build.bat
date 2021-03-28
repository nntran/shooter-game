echo "Start build project..."

SET OUT_CLASSES_DIR=classes
SET SRC_DIR=src\java
SET RESSOURCES_DIR=src\ressources

RMDIR %OUT_CLASSES_DIR% /s /q

REM Classes de bases des objets
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%\fr\ntdt\game\shooter\objet\Point.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%\fr\ntdt\game\shooter\objet\Objet.java

REM Armes 
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%\fr\ntdt\game\shooter\objet\arme\Arme.java

REM Avions
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%\fr\ntdt\game\shooter\objet\avion\Avion.java

REM Application
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%\fr\ntdt\game\shooter\Scene.java
javac -d %OUT_CLASSES_DIR% -cp %OUT_CLASSES_DIR% %SRC_DIR%\fr\ntdt\game\shooter\App.java

echo "Finish!"