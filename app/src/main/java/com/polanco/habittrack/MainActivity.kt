package com.polanco.habittrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.polanco.habittrack.ui.navigation.AppNavigation
import com.polanco.habittrack.ui.theme.HabitTrackTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            HabitTrackTheme {

                AppNavigation()
            }
        }
    }
}