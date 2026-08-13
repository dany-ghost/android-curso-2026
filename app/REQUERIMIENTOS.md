# HabitTrack

## 1. Descripción

HabitTrack es una aplicación Android que permite al usuario realizar un seguimiento básico de sus hábitos diarios. La aplicación muestra una lista de hábitos, permite marcarlos como completados y consultar información detallada sobre cada uno.

Su objetivo es ayudar al usuario a mantener una mejor organización de actividades relacionadas con la salud, el ejercicio, el estudio y el desarrollo personal.

## 2. Problema que resuelve

Muchas personas tienen dificultades para mantener una rutina y recordar los hábitos que desean cumplir diariamente. HabitTrack permite reunir estos hábitos en una sola aplicación y llevar un seguimiento visual de cuáles han sido completados.

La aplicación resulta útil porque ofrece una interfaz sencilla para visualizar actividades diarias y controlar el progreso realizado.

## 3. Pantallas

| # | Nombre de pantalla | Descripción breve                                                                                                             |
| - | ------------------ | ----------------------------------------------------------------------------------------------------------------------------- |
| 1 | InicioScreen       | Pantalla de bienvenida que presenta la aplicación y permite acceder a los hábitos.                                            |
| 2 | ListaScreen        | Pantalla principal que muestra los hábitos mediante una LazyColumn, permite marcarlos como completados y muestra el progreso. |
| 3 | DetalleScreen      | Muestra la información detallada del hábito seleccionado y permite regresar a la pantalla anterior.                           |

## 4. Tecnologías usadas

* Kotlin
* Jetpack Compose
* Material 3
* Navigation Compose
* LazyColumn
* Manejo de estado con `remember`
* Android Studio

## 5. Diagrama de navegación

```text
InicioScreen
     |
     | Botón "Ver mis hábitos"
     v
ListaScreen
     |
     | Seleccionar un hábito
     v
DetalleScreen
     |
     | Botón "Volver"
     v
ListaScreen
```

## 6. Requerimientos funcionales

* El sistema debe mostrar una pantalla de bienvenida.
* El usuario debe poder navegar a la lista de hábitos.
* El sistema debe mostrar una lista de hábitos de ejemplo.
* El usuario debe poder marcar y desmarcar un hábito como completado.
* El sistema debe actualizar el contador de hábitos completados.
* El usuario debe poder seleccionar un hábito para visualizar su información detallada.
* El usuario debe poder regresar desde la pantalla de detalle a la lista de hábitos.

## 7. Capturas de pantalla

Las capturas de pantalla de HabitTrack serán agregadas al finalizar el desarrollo del proyecto.
