package com.polanco.practica10.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.polanco.practica10.afirmaciones

@Composable
fun PantallaLista(
    navController: NavController
) {

    Column {

        afirmaciones.forEach { afirmacion ->

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {

                        navController.navigate(
                            "detalle/${afirmacion.id}"
                        )
                    }

            ) {

                Column(
                    modifier =
                        Modifier.padding(16.dp)
                ) {

                    Text(
                        text = afirmacion.categoria,

                        style =
                            MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = afirmacion.texto
                    )
                }
            }
        }
    }
}