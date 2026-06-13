package com.example.myapplication

fun generarRecibo(
    nombreCliente: String,
    monto: Double,
    descuento: Double = 0.0,
    impuesto: Double = 0.18,
    moneda: String = "DOP"
): String {

    val subtotal = monto - (monto * descuento)
    val impuestoVal = subtotal * impuesto
    val total = subtotal + impuestoVal

    return """
===========================
RECIBO — $moneda
Cliente   : $nombreCliente
Subtotal  : ${"%.2f".format(subtotal)}
Descuento : ${(descuento * 100).toInt()}%
Impuesto  : ${"%.2f".format(impuestoVal)}
Total     : ${"%.2f".format(total)}
===========================
""".trimIndent()
}

// ── Extensiones de String ─────────────────────────

fun String.esEmail(): Boolean =
    contains('@') && contains('.')

fun String.aTitulo(): String =
    split(' ').joinToString(" ") {
        it.replaceFirstChar { c -> c.uppercase() }
    }

fun String.mascararTarjeta(): String {
    return if (length >= 16) {
        "*".repeat(12) + takeLast(4)
    } else {
        "Tarjeta inválida"
    }
}

// ── Extensiones de List<Int> ──────────────────────

fun List<Int>.promedio(): Double =
    if (isEmpty()) 0.0 else sum().toDouble() / size

fun List<Int>.aprobados(): List<Int> =
    filter { it >= 70 }

fun List<Int>.estadisticas() {
    println("Mínimo: ${minOrNull()}")
    println("Máximo: ${maxOrNull()}")
    println("Promedio: ${promedio()}")
}

data class Pedido(
    val id: Int,
    var producto: String,
    var precio: Double,
    var activo: Boolean = true
)

// Función de orden superior
fun filtrarPedidos(
    pedidos: List<Pedido>,
    criterio: (Pedido) -> Boolean
): List<Pedido> {
    return pedidos.filter(criterio)
}

fun main() {

    println(
        generarRecibo(
            nombreCliente = "Ana López",
            monto = 1500.0,
            descuento = 0.10
        )
    )

    println(
        generarRecibo(
            "Pedro Ruiz",
            2800.0
        )
    )

    println(
        generarRecibo(
            monto = 500.0,
            nombreCliente = "Empresa ABC",
            moneda = "USD",
            impuesto = 0.0
        )
    )

    println("\n=== EXTENSIONES ===")

    println("test@mail.com".esEmail())
    println("noesmail".esEmail())

    println("programacion movil".aTitulo())

    println("1234567890123456".mascararTarjeta())

    val notas = listOf(85, 92, 61, 78, 45, 90)

    println("Promedio: ${notas.promedio()}")

    println("Aprobados: ${notas.aprobados()}")

    notas.estadisticas()

    println("\n=== PEDIDOS ===")

// apply
    val p1 = Pedido(1, "", 0.0).apply {
        producto = "Smartphone"
        precio = 25000.0
    }

    val pedidos = listOf(
        p1,
        Pedido(2, "Audífonos", 1800.0),
        Pedido(3, "Tablet", 18000.0, activo = false),
        Pedido(4, "Cargador", 850.0)
    )

// Lambdas
    val activos = filtrarPedidos(pedidos) { it.activo }

    val caros = filtrarPedidos(pedidos) {
        it.precio > 5000.0 && it.activo
    }

    val economicos = filtrarPedidos(pedidos) {
        it.precio <= 2000.0
    }

    println("Pedidos activos: ${activos.size}")

    println("Pedidos caros: ${caros.map { it.producto }}")

    println("Pedidos económicos: ${economicos.map { it.producto }}")

// also
    val resumen = pedidos
        .filter { it.activo }
        .map { it.precio }
        .also {
            println("Precios activos: $it")
        }
        .sum()

    println("Total activos: $${"%.2f".format(resumen)}")

// let
    pedidos.maxByOrNull { it.precio }?.let {
        println(
            "Producto más caro: ${it.producto} - $${it.precio}"
        )
    }


}