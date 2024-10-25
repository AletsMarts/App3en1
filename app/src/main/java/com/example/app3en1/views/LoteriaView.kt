package com.example.app3en1.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app3en1.navigation.AppScreens
import com.example.tresenuno.components.MainIconButton
import com.example.tresenuno.components.TitleBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoteriaViewNav(viewModel: LoteriaViewModel, navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Lotería") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.navigate(route = AppScreens.Home.route)
                    }
                }
            )
        }
    ){
        LoteriaView(viewModel, navController)
    }
}

@Composable
fun LoteriaView(viewModel: LoteriaViewModel, navController: NavController){
    val lottonNumbers = viewModel.lotoNumbers.value
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.padding(top = 80.dp))
        if (lottonNumbers.isEmpty()){
            Text(text = "Lotería",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        }else{
            LotteryNumbers(lottonNumbers,navController)
        }
        Button(
            onClick = { viewModel.generateLotoNumbers() },
            modifier = Modifier.padding(top = 25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue))
        {
            Text(text = "Generar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Button(onClick = { navController.navigate(route = AppScreens.ProyectoPerruno.route)},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.White)
            )
        {
            Text(text = "Siguiente app", style = TextStyle(fontFamily = FontFamily.Default), fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.padding(0.dp))
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

@Composable
fun LotteryNumbers(lottonNumbers: List<Int>, navController: NavController){
    LazyRow (contentPadding = PaddingValues(
        horizontal = 16.dp,
        vertical = 8.dp
            ))
    {
        items(lottonNumbers){ number ->
            Box (contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
                    .background(Color.Red, CircleShape))
            {
                Text(text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }

    }
}