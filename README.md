# HabitTrack

Aplicación Android para el seguimiento de hábitos diarios, desarrollada como proyecto final de la asignatura **IDS-368 - Desarrollo Android con Kotlin**.

## Descripción

HabitTrack permite visualizar una lista de hábitos diarios, marcar los hábitos completados y consultar información detallada sobre cada uno.

La aplicación fue desarrollada utilizando Kotlin y Jetpack Compose, aplicando conceptos de navegación, manejo de estado y componentes de Material 3.

## Funcionalidades

- Pantalla de bienvenida.
- Lista de hábitos diarios.
- Visualización mediante LazyColumn.
- Hábitos de ejemplo.
- Checkbox para marcar hábitos como completados.
- Contador de progreso.
- Navegación entre pantallas.
- Pantalla de detalle para cada hábito.
- Botón para regresar a la pantalla anterior.
- Tema personalizado utilizando Material 3.

## Pantallas

### 1. Inicio

Pantalla de bienvenida de la aplicación. Permite al usuario acceder a sus hábitos.

### 2. Lista de hábitos

Muestra los hábitos diarios y permite marcar cada uno como completado.

También muestra el progreso actual del usuario.

### 3. Detalle del hábito

Muestra información detallada sobre el hábito seleccionado.

## Tecnologías utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Navigation Compose
- LazyColumn
- Manejo de estado con `remember`

## Estructura del proyecto

```text
com.polanco.habittrack
│
├── MainActivity.kt
│
├── data
│   └── Habito.kt
│
├── screens
│   ├── InicioScreen.kt
│   ├── ListaScreen.kt
│   └── DetalleScreen.kt
│
└── ui
    ├── navigation
    │   └── AppNavigation.kt
    │
    └── theme
        ├── Color.kt
        ├── Theme.kt
        └── Type.kt

Navegación

Inicio
   ↓
Lista de hábitos
   ↓
Detalle del hábito
   ↓
Lista de hábitos

Autor

Daniel Polanco

Estudiante de Ingeniería de Software.

Proyecto académico

Proyecto final desarrollado para la asignatura:

IDS-368 - Desarrollo Android con Kotlin — UNICDA 2026