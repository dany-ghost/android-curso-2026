package com.polanco.holaandroid

fun clasificarNota(nota: Int): String = when {
    nota < 0 || nota > 100 -> "Nota inválida"
    nota >= 90 -> "Sobresaliente (A)"
    nota >= 80 -> "Muy Bueno (B)"
    nota >= 70 -> "Bueno (C)"
    nota >= 60 -> "Aprobado (D)"
    else -> "Reprobado (F)"
}

fun fizzBuzz() {
    for (i in 1..30) {
        val resultado = when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> "$i"
        }

        print("$resultado ")

        if (i % 10 == 0) {
            println()
        }
    }
}

fun tablaMultiplicar(n: Int) {
    println("\n=== Tabla del $n ===")

    for (i in 1..10) {
        println("$n x $i = ${n * i}")
    }
}

fun main() {

    val nombreCurso = "Programación Móvil I"
    val añoInicio = 2026

    var calificacion = 95.5
    calificacion = 88.0

    println("Curso: $nombreCurso, Año: $añoInicio")
    println("Calificación actual: ${calificacion * 0.3} (30%)")

    val nombreCompleto = "Daniel Polanco"
    val edad = 19

    println("Me llamo $nombreCompleto y tengo $edad años")

    println("\n=== CLASIFICACIÓN DE NOTAS ===")

    val notas = listOf(100, 92, 85, 73, 61, 45, -5)

    for (nota in notas) {
        println("Nota $nota -> ${clasificarNota(nota)}")
    }

    println("\n=== FIZZBUZZ ===")
    fizzBuzz()

    println("\n")

    val num = readLine()?.toIntOrNull() ?: 1
    tablaMultiplicar(num)
}