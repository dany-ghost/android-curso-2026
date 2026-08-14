package com.polanco.practica10.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val EsquemaClaro = lightColorScheme(
    primary = Azul40,
    onPrimary = Color.White,
    primaryContainer = Azul80,
    secondary = Verde40,
    secondaryContainer = Verde80
)

@Composable
fun Practica10Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = EsquemaClaro,
        typography = Typography,
        content = content
    )
}