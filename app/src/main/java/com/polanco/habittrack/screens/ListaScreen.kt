package com.polanco.habittrack.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.polanco.habittrack.data.Habito

@Composable
fun ListaScreen(
    onHabitoClick: (Int) -> Unit
) {

    val habitos = listOf(
        Habito(
            id = 1,
            nombre = "Beber agua",
            descripcion = "Tomar al menos 8 vasos de agua.",
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
            descripcion = "Practicar programación Android durante 1 hora.",
            categoria = "Estudio"
        ),
        Habito(
            id = 4,
            nombre = "Leer",
            descripcion = "Leer al menos 20 páginas de un libro.",
            categoria = "Personal"
        )
    )

    val habitosCompletados = remember {
        mutableStateMapOf<Int, Boolean>()
    }

    val completados = habitos.count {
        habitosCompletados[it.id] == true
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("HabitTrack")
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item {
                Column(
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = "¡Buenos días!",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text(
                        text = "Mantén el ritmo y completa tus hábitos de hoy.",
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = "$completados de ${habitos.size} hábitos completados",
                        modifier = Modifier.padding(top = 16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Mis hábitos de hoy",
                        modifier = Modifier.padding(top = 20.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            items(
                items = habitos,
                key = { it.id }
            ) { habito ->

                val completado =
                    habitosCompletados[habito.id] ?: false

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onHabitoClick(habito.id)
                        }
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = habito.nombre,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = habito.categoria,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Checkbox(
                            checked = completado,
                            onCheckedChange = { nuevoEstado ->
                                habitosCompletados[habito.id] = nuevoEstado
                            }
                        )
                    }
                }
            }
        }
    }
}