# Eldoria: Treasures of the Fallen Kingdom

## Descripción

Eldoria es un videojuego de rol (RPG) por turnos desarrollado en Java para jugar desde la consola.

El jugador debe avanzar por diferentes salas de una mazmorra, enfrentándose a enemigos cada vez más fuertes y consiguiendo oro y experiencia.

El objetivo es sobrevivir y avanzar por tantas salas como sea posible, mejorando las estadísticas del personaje.

## Características del juego

- Combates por turnos contra distintos enemigos.
- Tres enemigos disponibles: Slime, Goblin y Esqueleto.
- Recompensas de oro al derrotar enemigos.
- Sistema de experiencia y subida de niveles.
- Aumento de dificultad según avanzas por las salas.
- Posibilidad de atacar, defenderse o huir de los combates.
- Consulta de las estadísticas del personaje.
- Colores en la consola para hacer los menús más claros.

## Requisitos

- JDK 21 o superior.
- Una terminal o consola.
- Visual Studio Code (opcional, para editar y ejecutar el proyecto).

## Cómo compilar y ejecutar

Desde la carpeta principal del proyecto, abre una terminal y ejecuta:

**Compilar:**

```bash
javac -d bin src/Eldoria.java
```

**Ejecutar:**

```bash
java -cp bin Eldoria
```

## Cómo jugar

Al iniciar el juego aparecerá un menú principal con tres opciones:

1. Batallar en la mazmorra.
2. Consultar las estadísticas del personaje.
3. Salir del programa.

Durante los combates podrás elegir entre tres acciones:

- **Atacar:** causa daño al enemigo.
- **Defenderse:** reduce a la mitad el daño recibido durante ese turno.
- **Huir:** permite abandonar el combate y volver al menú conservando las estadísticas y el oro.

Al derrotar a un enemigo, el personaje consigue oro y experiencia, recupera vida y puede subir de nivel.

Al avanzar por las salas, los enemigos aumentan su vida, daño y recompensa de oro.

La partida termina cuando el personaje se queda sin vida o cuando el jugador decide salir.

## Estructura del proyecto

```text
Eldoria/
├── src/
│   └── Eldoria.java
├── docs/
│   └── ELDORIA.pdf
├── README.md
└── .gitignore
```

## Tecnologías utilizadas

- Java 21.
- Visual Studio Code.
- Git y GitHub.

## Versión

Versión 1.1 - Primera evaluación.

## Autor

Sergio Arévalo