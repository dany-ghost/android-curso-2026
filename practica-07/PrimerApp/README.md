# Práctica 07 - PrimerApp

## Ejercicio 1 - Explorar y anotar la estructura

### 16. ¿Qué hace la función setContent {} en MainActivity.kt?

La función setContent {} establece el contenido visual de la actividad utilizando Jetpack Compose. Dentro de este bloque se colocan las funciones @Composable que forman la interfaz de usuario de la aplicación.

### 17. ¿Qué significan minSdk, targetSdk y compileSdk en build.gradle.kts?

- minSdk: indica la versión mínima de Android en la que puede ejecutarse la aplicación.
- targetSdk: indica la versión de Android para la cual la aplicación está diseñada y con la que espera comportarse correctamente.
- compileSdk: indica la versión del SDK de Android utilizada para compilar el proyecto.

### 18. ¿Para qué sirve el archivo libs.versions.toml?

El archivo libs.versions.toml permite centralizar y administrar las versiones de las dependencias utilizadas en el proyecto. Esto facilita mantener las versiones organizadas y actualizarlas desde un solo lugar.

### 19. ¿Qué anotación convierte una función en un componente de UI en Compose?

La anotación @Composable convierte una función en una función composable, permitiendo que pueda utilizarse para construir componentes de la interfaz de usuario con Jetpack Compose.