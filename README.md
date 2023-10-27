# Juego de Cartas - Nombre del Proyecto

Bienvenido a [Nombre del Proyecto], un juego de cartas que te permite [breve descripción de lo que hace el juego].

## Tabla de Contenidos
1. [Acerca del Proyecto](#acerca-del-proyecto)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Estructura de la Base de Datos](#estructura-de-la-base-de-datos)
4. [Características](#características)
5. [Selección de Personajes](#selección-de-personajes)

## Acerca del Proyecto

[Nombre del Proyecto] es un emocionante juego de cartas que permite a los jugadores [breve descripción de lo que se puede hacer en el juego].

### Tecnologías Utilizadas

El proyecto ha sido desarrollado utilizando las siguientes tecnologías:

- Spring Web
- Spring Data JPA
- MySQL

## Estructura de la Base de Datos

[![game-diagram-drawio.png](https://i.postimg.cc/LhdkQswh/game-diagram-drawio.png)](https://postimg.cc/30BDd3KH)

1. `characters`: Tabla para los personajes del juego, contiene el nombre, apellido, puntos de vida e id de la categoria.
2. `categories`: Roles de los personajes, "mago", "caballero" etc.
3. `elements`: Tabla para los elementos de los personajes, "agua", "fuego", "tierra", "aire".
4. `abilities`: Almacena las habilidades de los personajes.
5. `character_element`: Tabla intermedia que relaciona personajes con elementos.

## Características

- CRUD completo de todas las tablas
- Mapeo de datos para todas las tablas
- Busqueda por id y nombre
- Control de excepciones

## Selección de Personajes

Los jugadores pueden seleccionar hasta mínimo de 3 personajes personajes para jugar.

