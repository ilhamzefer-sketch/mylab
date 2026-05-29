@echo off
set "JAVA_HOME=C:\Users\Dell\.jdks\temurin-25.0.3"
set "PATH=%JAVA_HOME%\bin;%PATH%"
call gradlew.bat bootRun
