package com.polanco.habittrack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.polanco.habittrack.screens.DetalleScreen
import com.polanco.habittrack.screens.InicioScreen
import com.polanco.habittrack.screens.ListaScreen
sealed class Pantalla(val ruta: String) {

    object Inicio : Pantalla("inicio")

    object Lista : Pantalla("lista")

    object Detalle : Pantalla("detalle/{itemId}") {

        fun crearRuta(id: Int): String {
            return "detalle/$id"
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Pantalla.Inicio.ruta
    ) {

        composable(Pantalla.Inicio.ruta) {

            InicioScreen(
                onVerHabitos = {
                    navController.navigate(Pantalla.Lista.ruta)
                }
            )
        }

        composable(Pantalla.Lista.ruta) {

            ListaScreen(
                onHabitoClick = { id ->
                    navController.navigate(
                        Pantalla.Detalle.crearRuta(id)
                    )
                }
            )
        }

        composable(
            route = Pantalla.Detalle.ruta,
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id =
                backStackEntry.arguments?.getInt("itemId") ?: 0

            DetalleScreen(
                habitoId = id,
                onVolver = {
                    navController.popBackStack()
                }
            )
        }
    }
}