@echo off
javac -cp src/main/java src/main/java/runner/*.java src/main/java/model/*.java src/main/java/view/*.java src/main/java/controller/*.java
java -cp src/main/java runner.CivilizationGame
