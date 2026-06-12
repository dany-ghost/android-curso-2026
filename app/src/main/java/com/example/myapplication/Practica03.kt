package com.example.myapplication

data class ResultadoValidacion(
    val esValido: Boolean,
    val mensaje: String
)

data class Estudiante(
    val nombre: String,
    val nota: Double
)

fun validarUsuario(nombre: String?, email: String?): ResultadoValidacion {

    val nombreLimpio = nombre?.trim()
    val longitudNombre = nombreLimpio?.length ?: 0

    if (longitudNombre < 3) {
        return ResultadoValidacion(
            false,
            "Nombre muy corto o vacío"
        )
    }

    val emailValido = email?.contains('@') ?: false

    if (!emailValido) {
        return ResultadoValidacion(
            false,
            "Email inválido"
        )
    }

    return ResultadoValidacion(
        true,
        "Usuario '$nombreLimpio' registrado correctamente"
    )
}

fun analizarNotas(estudiantes: List<Estudiante>) {

    println("=== REPORTE DE NOTAS ===")

    val promedio = estudiantes.map { it.nota }.average()
    println("Promedio: $promedio")

    val aprobados = estudiantes.filter { it.nota >= 70 }
    println("Aprobados: ${aprobados.size}")

    val mejorEstudiante = estudiantes.maxByOrNull { it.nota }

    println(
        "Mejor estudiante: ${mejorEstudiante?.nombre} (${mejorEstudiante?.nota})"
    )

    val reprobados = estudiantes
        .filter { it.nota < 70 }
        .sortedBy { it.nota }

    println("\nReprobados:")

    reprobados.forEach {
        println("${it.nombre}: ${it.nota}")
    }
}

// ===== Extension Functions =====

fun String.capitalizarPrimera(): String {
    return replaceFirstChar {
        it.uppercase()
    }
}

fun List<Int>.promedioSeguro(): Double {
    return if (isEmpty()) {
        0.0
    } else {
        average()
    }
}

fun Double.esAprobado(): Boolean {
    return this >= 70.0
}

// ===== Main =====

fun main() {

    println("=== VALIDACIÓN DE USUARIOS ===")

    val casos = listOf(
        Pair(null, "test@mail.com"),
        Pair("Ana", null),
        Pair("Bo", "noesmail"),
        Pair("Carlos Pérez", "carlos@ejemplo.com")
    )

    casos.forEach { (nombre, email) ->

        val resultado = validarUsuario(nombre, email)

        println(
            "[${if (resultado.esValido) "OK" else "ERROR"}] ${resultado.mensaje}"
        )
    }

    println("\n========================\n")

    val estudiantes = listOf(
        Estudiante("Ana", 95.0),
        Estudiante("Carlos", 82.5),
        Estudiante("María", 67.0),
        Estudiante("Pedro", 78.5),
        Estudiante("Laura", 100.0)
    )

    analizarNotas(estudiantes)

    println("\n=== EXTENSION FUNCTIONS ===")

    println("juan".capitalizarPrimera())
    println("maria".capitalizarPrimera())

    val numeros = listOf(10, 20, 30, 40)
    println("Promedio: ${numeros.promedioSeguro()}")

    val vacia = emptyList<Int>()
    println("Promedio lista vacía: ${vacia.promedioSeguro()}")

    println("\n=== APROBACIÓN ===")

    println("95.0 -> ${95.0.esAprobado()}")
    println("67.0 -> ${67.0.esAprobado()}")
    println("70.0 -> ${70.0.esAprobado()}")
}