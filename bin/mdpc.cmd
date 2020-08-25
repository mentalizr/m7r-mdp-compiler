@echo %off

java -cp "%~dp0/../build/libs/mdp-compiler-0.0.8-SNAPSHOT.jar;%~dp0/libs/*" org.mentalizr.mdpCompiler.MDPCompilerCLI %*
