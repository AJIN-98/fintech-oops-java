@echo off
REM Usage: run.bat <name>   e.g. run.bat encapsulation
REM Names: classesobjects encapsulation constructors inheritance polymorphism
REM        abstraction interfaces association staticfinal enums exceptionhandling
if "%1"=="" (
  echo Usage: run.bat ^<name^>
  echo Names: classesobjects encapsulation constructors inheritance polymorphism abstraction interfaces association staticfinal enums exceptionhandling
  exit /b
)
if not exist out mkdir out
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt
del sources.txt

set CLASS=
if "%1"=="classesobjects" set CLASS=ClassesObjectsDemo
if "%1"=="encapsulation" set CLASS=EncapsulationDemo
if "%1"=="constructors" set CLASS=ConstructorsDemo
if "%1"=="inheritance" set CLASS=InheritanceDemo
if "%1"=="polymorphism" set CLASS=PolymorphismDemo
if "%1"=="abstraction" set CLASS=AbstractionDemo
if "%1"=="interfaces" set CLASS=InterfacesDemo
if "%1"=="association" set CLASS=AssociationDemo
if "%1"=="staticfinal" set CLASS=StaticFinalDemo
if "%1"=="enums" set CLASS=EnumsDemo
if "%1"=="exceptionhandling" set CLASS=ExceptionHandlingDemo
if "%CLASS%"=="" (echo Unknown demo: %1 & exit /b)
java -cp out com.fintech.oops.%1.%CLASS%
