Matias Garcia Silva, 202373599-k

realizado en visual studio code
para compilar el codigo fue usado javac 21.0.4
openjdk version "21.0.4" 2024-07-16
OpenJDK Runtime Environment (build 21.0.4+7-Ubuntu-1ubuntu222.04)
OpenJDK 64-Bit Server VM (build 21.0.4+7-Ubuntu-1ubuntu222.04, mixed mode, sharing)

consideraciones:
    -Se realizo la generacion de recursos segun el radio pero el numero al ser tan grande y 
    estar limitado a usar float da muchas veces da el mismo valor 2147483647 unidades.

    -se generan 10 planetas aleatorios inicialmente, si el jugador tiene (n) planetas  en el mapa
    puede viajar al (n+1) y este se desbloqueara y se agregara al mapa. El jugador no puede saltar planetas,
    es decir, no puede desbloquear directamente el planeta n+2 o superior sin pasar por el n+1.
    Sin embargo, una vez que un planeta está desbloqueado, el jugador puede viajar libremente entre
    los planetas ya descubiertos en cualquier orden.

    -El juego finaliza en cuanto se llegue al centro galactico.




Para ejecutar el codigo escribir en consola:
1. make
2. make clean

o tambien como:
1. javac -d clases NoJavaSky.java
2. java -cp clases NoJavaSky