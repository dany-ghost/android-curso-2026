package com.polanco.practica10

data class Afirmacion(
    val id: Int,
    val categoria: String,
    val texto: String
)

val afirmaciones = listOf(
    Afirmacion(
        1,
        "Motivación",
        "Cada día es una nueva oportunidad para aprender."
    ),
    Afirmacion(
        2,
        "Programación",
        "La práctica constante mejora nuestras habilidades."
    ),
    Afirmacion(
        3,
        "Éxito",
        "El éxito es la suma de pequeños esfuerzos diarios."
    ),
    Afirmacion(
        4,
        "Aprendizaje",
        "Nunca dejamos de aprender cosas nuevas."
    )
)