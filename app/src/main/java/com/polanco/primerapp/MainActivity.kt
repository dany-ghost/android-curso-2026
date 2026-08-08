package com.polanco.primerapp



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TarjetaContacto(
                nombre = "Daniel Alfonso Polanco Peguero",
                cargo = "Estudiante — Ingeniería de Software",
                email = "danyalpolanco@gmail.com",
                telefono = "+1 (849) 653-3686",
                github = "github.com/dany-ghost"
            )
        }
    }
}

@Composable
fun TarjetaContacto(
    nombre: String,
    cargo: String,
    email: String,
    telefono: String,
    github: String,
) { var mostrarInfo by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {

        // Sección superior: foto y nombre
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                // Círculo con las iniciales
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = nombre
                            .split(' ')
                            .map { it.first() }
                            .take(2)
                            .joinToString(""),
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(Modifier.height(16.dp))

                Text(
                    text = nombre,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = cargo,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // Sección de contacto
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                FilaContacto(Icons.Default.Email, "Email", email)
                FilaContacto(Icons.Default.Phone, "Teléfono", telefono)
                FilaContacto(Icons.Default.Code, "GitHub", github)
            }


            Spacer(Modifier.height(24.dp))

            // Botón para mostrar u ocultar información
            Button(
                onClick = {
                    mostrarInfo = !mostrarInfo
                }
            ) {
                Text(
                    if (mostrarInfo) "Ocultar info" else "Más información"
                )
            }

            // Información adicional
            if (mostrarInfo) {
                Spacer(Modifier.height(16.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Carrera:",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Ingeniería de Software"
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "Universidad:",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Universidad Dominico-Americano"
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "Semestre:",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "9.º cuatrimestre"
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "Año de ingreso:",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "2023"
                        )
                    }
                }
            }


        }
    }
}



@Composable
fun FilaContacto(
    icono: androidx.compose.ui.graphics.vector.ImageVector,
    etiqueta: String,
    valor: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Icon(
            imageVector = icono,
            contentDescription = etiqueta,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp),
        )

        Spacer(Modifier.width(16.dp))

        Column {
            Text(
                text = etiqueta,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Text(
                text = valor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

