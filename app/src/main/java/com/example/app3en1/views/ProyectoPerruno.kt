package com.example.app3en1.views


import android.annotation.SuppressLint
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app3en1.R
import com.example.app3en1.navigation.AppScreens
import com.example.tresenuno.components.MainIconButton
import com.example.tresenuno.components.TitleBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProyectoPerrunoNav(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Proyecto Perruno") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.navigate(route = AppScreens.Loteria.route)
                    }
                }
            )
        }
    ){
        VistaApp(navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun VistaApp(navController: NavController) {
        var edad by remember {mutableStateOf("")}
        var resultado by remember {mutableStateOf("")}

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            ) {

            Image(
                painter = painterResource(
                    id
                    = R.drawable.leonardo_phoenix_a_vibrant_and_playful_illustration_of_a_retro_3),
                contentDescription = "Imagen de ejemplo",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.padding(top = 120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    "AÑOS PERRUNOS",
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Calculadora de años humanos a perros",
                    style = TextStyle(fontStyle = FontStyle.Italic, textAlign = TextAlign.Center)
                )
            }

            OutlinedTextField(
                value = edad, onValueChange = { edad = it },
                label = {
                    Text(
                        "Edad humana",
                        style = TextStyle(Color.Red, fontSize = 15.sp)
                    ) }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                singleLine = true,
                textStyle = TextStyle(),
                colors = outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Red,
                    focusedBorderColor = Color.Red,
                    unfocusedTextColor = Color.Red,
                    focusedTextColor = Color.Red
                )
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                ElevatedButton(modifier = Modifier.padding(8.dp),
                    onClick = {
                        var res = 0
                        res = edad.toInt() * 7
                        resultado = res.toString() },
                    colors = ButtonDefaults.buttonColors(
                        Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "Calcular",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    )
                }
                ElevatedButton(modifier = Modifier.padding(8.dp),
                    onClick = { edad = ""
                        resultado = "" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Limpiar",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(value = resultado, onValueChange = {resultado = it},
                readOnly = true,
                label = { Text("Edad perruna", style = TextStyle(fontStyle = FontStyle.Italic,))},
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = { navController.navigate(route = AppScreens.AppExamenU1.route)},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.White)
            )
            {
                Text(text = "Siguiente app", style = TextStyle(fontFamily = FontFamily.Default), fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Row{
                Text("By AletsMarts",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 35.dp),
                    style = TextStyle(textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Cursive)
                )
            }


        }


    }

