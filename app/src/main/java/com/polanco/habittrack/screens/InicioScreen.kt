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
import androidx.compose.material3.ExperimentalMaterial3Api
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun InicioScreen(
    onVerHabitos: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("HabitTrack")
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

            Text(
                text = "¡Bienvenido a HabitTrack!",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Organiza y realiza seguimiento a tus hábitos diarios.",
                modifier = Modifier.padding(top = 16.dp)
            )

            Button(
                onClick = onVerHabitos,
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Ver mis hábitos")
            }
        }
    }
}