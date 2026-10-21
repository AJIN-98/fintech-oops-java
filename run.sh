#!/bin/bash
# Usage: ./run.sh            -> list all demos
#        ./run.sh <name>     -> compile and run one demo (e.g. ./run.sh encapsulation)
#        ./run.sh all        -> run every demo one after another
cd "$(dirname "$0")"
mkdir -p out
javac -d out $(find src -name "*.java") || exit 1

declare -A DEMOS=(
  [classesobjects]=ClassesObjectsDemo   [encapsulation]=EncapsulationDemo
  [constructors]=ConstructorsDemo       [inheritance]=InheritanceDemo
  [polymorphism]=PolymorphismDemo       [abstraction]=AbstractionDemo
  [interfaces]=InterfacesDemo           [association]=AssociationDemo
  [staticfinal]=StaticFinalDemo         [enums]=EnumsDemo
  [exceptionhandling]=ExceptionHandlingDemo
)

run_one() { echo; echo "===== $1 ====="; java -cp out com.fintech.oops.$1.${DEMOS[$1]}; }

if [ -z "$1" ]; then
  echo "Available demos:"; for k in "${!DEMOS[@]}"; do echo "  $k"; done | sort
  echo "Run one with: ./run.sh <name>   or all with: ./run.sh all"
elif [ "$1" = "all" ]; then
  for k in classesobjects encapsulation constructors inheritance polymorphism abstraction interfaces association staticfinal enums exceptionhandling; do run_one $k; done
elif [ -n "${DEMOS[$1]}" ]; then
  run_one "$1"
else
  echo "Unknown demo: $1"; exit 1
fi
