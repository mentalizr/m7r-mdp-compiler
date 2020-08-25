@echo %off

java -cp "%~dp0/../build/libs/mdp-compiler-1.0-SNAPSHOT.jar;%~dp0/libs/*" org.mentalizr.mdpCompiler.MDPCompilerCLI %*
