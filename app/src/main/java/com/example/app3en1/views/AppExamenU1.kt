package com.example.app3en1.views


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
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
fun VistaAPPComponents(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Home") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.KeyboardArrowLeft) {
                        navController.navigate(route = AppScreens.Home.route)

                    }
                }
            )
        }
    ){
        VistaAPP(navController/*, id, opcional*/)
    }
}


@Composable
fun VistaAPP(navController: NavController, /*id: Int, opcional: String?*/) {
    Image(
        painter = painterResource(id = R.drawable.como_calcular_un_porcentaje_7571_600),
        contentDescription = null,
        modifier = Modifier
            .alpha(0.2f)
            .fillMaxSize()
    )
    Column(modifier = Modifier
        .fillMaxSize()
    )
    {
        Surface (shape = MaterialTheme.shapes.large,
            shadowElevation = 5.dp){
            Text(text = "CALCULADORA DE DESCUENTOS",
                modifier = Modifier
                    .padding(top = 140.dp, bottom = 40.dp)
                    .fillMaxWidth(),
                style = TextStyle(fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )

            )

        }


        var numero by remember { mutableStateOf("") }
        var porcentaje by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }

        val num = numero.toDoubleOrNull() ?:0.0
        val porc = porcentaje.toDoubleOrNull() ?:0.0
        val result = calcularPorcentaje(num, porc)

        val desc = num- calcularPorcentaje(num,porc)

        descuento = desc.toString()
        resultado = result.toString()


        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            value = numero, onValueChange = { numero = it },
            label = { Text("Precio", style = TextStyle(fontStyle = FontStyle.Italic))}
        )

        Spacer(modifier = Modifier.padding(1.dp))
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            value = porcentaje, onValueChange = { porcentaje = it},
            label = { Text("% descuento", style = TextStyle(fontStyle = FontStyle.Italic)) }
        )

        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { calcularPorcentaje(num,porc) },
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(
                    "CALCULAR",
                    style = TextStyle(fontWeight = FontWeight.Bold, color = Color.White, fontSize = 15.sp)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = { numero = ""
                porcentaje=""},
                colors = ButtonDefaults.buttonColors(Color.Gray)) {
                Text(
                    "LIMPIAR",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 15.sp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(
            value = resultado,
            onValueChange = { resultado = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            readOnly = true,
            label = {
                Text(
                    "Descuento",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
            })


        OutlinedTextField(value = descuento,
            onValueChange = {  descuento= it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            readOnly = true,
            label = {
                Text("Total", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold))
            })

        Spacer(modifier = Modifier.padding(10.dp))
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
/*
fun Calcular() {
    val num = numero.toDoubleOrNull() ?: 0.0
    val porc = porcentaje.toDoubleOrNull() ?: 0.0
    val result = calcularPorcentaje(num, porc)
    resultado = result.toString()

*/

fun calcularPorcentaje(numero: Double, porcentaje: Double): Double {
    return (numero * porcentaje) / 100
}
