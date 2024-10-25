package com.example.app3en1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app3en1.views.Home
import com.example.app3en1.views.LoteriaViewModel
import com.example.app3en1.views.LoteriaViewNav
import com.example.app3en1.views.ProyectoPerrunoNav
import com.example.app3en1.views.VistaAPPComponents

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Home.route){
        composable(route = AppScreens.Home.route){
            Home(navController)
        }
        composable(route = AppScreens.AppExamenU1.route){
            VistaAPPComponents(navController)
        }
        composable(route = AppScreens.ProyectoPerruno.route){
            ProyectoPerrunoNav(navController)
        }
        composable(route = AppScreens.Loteria.route){
            LoteriaViewNav(LoteriaViewModel(), navController)
        }
        }

}