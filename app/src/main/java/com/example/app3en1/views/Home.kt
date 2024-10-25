package com.example.app3en1.views

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app3en1.R
import com.example.app3en1.navigation.AppScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController){
    Scaffold (){
        HomeCuerpo(navController)
    }
}

@Composable
fun HomeCuerpo(navController: NavController){
    Image(painter = painterResource(id = R.drawable.logotec22_transp2),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.1f))

    Column (modifier = Modifier
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){



        Text(text = "DESARROLLO DE APLICACIONES CON ANDROID",
            style = TextStyle(fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                fontStyle = FontStyle.Normal,
                                textAlign = TextAlign.Center),
            modifier = Modifier
                .padding(top = 400.dp)
        )

        Text(text = "by AletsMarts",
            style = TextStyle(fontFamily = FontFamily.Cursive, fontSize = 20.sp),
            modifier = Modifier.padding(top = 10.dp)
        )



        ElevatedButton(onClick = { navController.navigate(route = AppScreens.Loteria.route) },
            border = BorderStroke(1.dp, Color.Yellow),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.Yellow),
            modifier = Modifier.padding(top = 150.dp)
        ) {
            Text("INICIAR", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome(){

}

