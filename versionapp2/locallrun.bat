@echo off
REM GRADLE 9
REM 1. Pobranie aktualnej ścieżki do aktualnego katalogu
set CURRENT_DIR=%cd%
echo Aktualny katalog: %CURRENT_DIR%

REM 2. Uruchomienie akcji mvn clean
echo Uruchamianie mvn clean...
mvn clean
if %errorlevel% neq 0 (
    echo Wystąpił błąd podczas uruchamiania mvn clean.
    exit /b %errorlevel%
)

cd ./android/
gradle clean
cd ..

npm install

npx react-native start