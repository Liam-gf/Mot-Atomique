@echo off

REM Pour compiler :
javac -d class @source/compile.list

REM Pour executer :
java -cp class atomique.Controleur
pause