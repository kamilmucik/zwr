@echo off
REM GRADLE 8
REM 1. Pobranie aktualnej ścieżki do aktualnego katalogu
set CURRENT_DIR=%cd%
echo Aktualny katalog: %CURRENT_DIR%

REM 2. Uruchomienie akcji mvn clean
echo Uruchamianie mvn clean...
mvn clean
@REM if %errorlevel% neq 0 (
@REM     echo Wystąpił błąd podczas uruchamiania mvn clean.
@REM     exit /b %errorlevel%
@REM )

npm install

cd %CURRENT_DIR%\android

gradle clean

@REM REM 3. Usunięcie katalogu rekursywnie
@REM echo Usuwanie katalogu...
@REM rd /s /q "%CURRENT_DIR%\android\app\src\main\res\drawable-*"
@REM rd /s /q "%CURRENT_DIR%\android\app\src\main\res\raw"
@REM if %errorlevel% neq 0 (
@REM     echo Wystąpił błąd podczas usuwania katalogu.
@REM     exit /b %errorlevel%
@REM )

@REM REM 4. Uruchomienie akcji gradle clean
@REM echo Uruchamianie gradle clean...
@REM gradle clean
@REM if %errorlevel% neq 0 (
@REM     echo Wystąpił błąd podczas uruchamiania gradle clean.
@REM     exit /b %errorlevel%
@REM )

@REM gradle assembleRelease
@REM gradle bundleRelease

cd %CURRENT_DIR%
echo Gotowe!
