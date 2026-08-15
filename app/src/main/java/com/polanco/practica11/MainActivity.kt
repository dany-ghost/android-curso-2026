package com.polanco.practica11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.polanco.practica11.ui.theme.Practica11Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Practica11Theme {
                Practica11App()
            }
        }
    }
}

@Composable
fun Practica11App() {

    var mostrarContador by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = {
                    mostrarContador = true
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Contador")
            }

            Button(
                onClick = {
                    mostrarContador = false
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Formulario")
            }
        }

        if (mostrarContador) {
            ContadorApp()
        } else {
            FormularioRegistro()
        }
    }
}

@Composable
fun ContadorApp() {

    var contador by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "$contador",
            style = MaterialTheme.typography.displayLarge,
            color = when {
                contador > 0 -> MaterialTheme.colorScheme.primary
                contador < 0 -> MaterialTheme.colorScheme.error
                else -> MaterialTheme.colorScheme.onBackground
            }
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            FilledTonalButton(
                onClick = {
                    contador--
                }
            ) {
                Text("-")
            }

            Button(
                onClick = {
                    contador = 0
                }
            ) {
                Text("Reiniciar")
            }

            FilledTonalButton(
                onClick = {
                    contador++
                }
            ) {
                Text("+")
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = when {
                contador < 0 -> "En números rojos"
                contador == 0 -> "En cero"
                else -> "En positivo"
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {
                contador *= 2
            }
        ) {
            Text("Duplicar")
        }
    }
}

@Composable
fun CampoNombre(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = "Nombre completo",
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun FormularioRegistro() {

    var nombre by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var aceptado by remember {
        mutableStateOf(false)
    }

    var mostrarDialogo by remember {
        mutableStateOf(false)
    }

    // Validaciones reactivas
    val nombreValido = nombre.trim().length >= 3

    val emailValido =
        email.contains("@") && email.contains(".")

    val puedeEnviar =
        nombreValido && emailValido && aceptado

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Registro de Usuario",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        CampoNombre(
            value = nombre,
            onValueChange = {
                nombre = it
            }
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(
                    text = "Email",
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            isError = !emailValido && email.isNotEmpty(),
            supportingText = {
                if (!emailValido && email.isNotEmpty()) {
                    Text("Email inválido")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = aceptado,
                onCheckedChange = {
                    aceptado = it
                }
            )

            Text(
                "Acepto los términos y condiciones"
            )
        }

        Button(
            onClick = {
                mostrarDialogo = true
            },
            enabled = puedeEnviar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }

        if (nombre.isNotEmpty()) {

            Text(
                text = if (nombreValido) {
                    "✓ Nombre válido"
                } else {
                    "✗ Mínimo 3 caracteres"
                },
                color = if (nombreValido) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.error
                },
                fontSize = 12.sp
            )
        }
    }

    if (mostrarDialogo) {

        AlertDialog(
            onDismissRequest = {
                mostrarDialogo = false
            },
            title = {
                Text("Registro exitoso")
            },
            text = {
                Text(
                    "¡$nombre se ha registrado correctamente!"
                )
            },
            confirmButton = {

                TextButton(
                    onClick = {
                        mostrarDialogo = false
                    }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }
}