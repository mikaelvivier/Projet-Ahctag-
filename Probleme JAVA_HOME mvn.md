```PS
C:\projets\imt\Projet-Ahctag-\demo\docker-dev-env-imt> $env:JAVA_HOME = "C:\javatools\java\openlogic-openjdk-17.0.13+11-windows-x64"
PS C:\projets\imt\Projet-Ahctag-\demo\docker-dev-env-imt> $env:Path = "$env:JAVA_HOME\bin;" + $env:Path  
PS C:\projets\imt\Projet-Ahctag-\demo> mvn clean install
```