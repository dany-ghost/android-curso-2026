package com.polanco.practica10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.polanco.practica10.ui.theme.Practica10Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Practica10Theme {
                AppPrincipal()
            }
        }
    }
}