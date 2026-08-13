package com.polanco.habittrack.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.polanco.habittrack.data.Habito
import androidx.compose.material3.ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleScreen(
    habitoId: Int,
    onVolver: () -> Unit
) {

    val habitos = listOf(

        Habito(
            id = 1,
            nombre = "Beber agua",
            descripcion = "Tomar al menos 8 vasos de agua durante el día para mantener una buena hidratación.",
            categoria = "Salud"
        ),

        Habito(
            id = 2,
            nombre = "Hacer ejercicio",
            descripcion = "Realizar al menos 30 minutos de actividad física.",
            categoria = "Ejercicio"
        ),

        Habito(
            id = 3,
            nombre = "Estudiar Kotlin",
            descripcion = "Practicar programación Android durante al menos una hora.",
            categoria = "Estudio"
        ),

        Habito(
            id = 4,
            nombre = "Leer",
            descripcion = "Leer al menos 20 páginas de un libro.",
            categoria = "Personal"
        )
    )

    val habito = habitos.find { it.id == habitoId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Detalle del hábito")
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (habito != null) {

                Text(
                    text = habito.nombre,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Categoría: ${habito.categoria}",
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    text = habito.descripcion,
                    modifier = Modifier.padding(top = 16.dp)
                )

            } else {

                Text(
                    text = "Hábito no encontrado"
                )
            }

            Button(
                onClick = onVolver,
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text("Volver")
            }
        }
    }
}