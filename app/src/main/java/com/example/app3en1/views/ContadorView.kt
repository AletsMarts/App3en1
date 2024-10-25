package com.example.app3en1.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Contador(viewModel: ContadorViewModel){
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize())
    {
        Text(text = viewModel.contador.value.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
        FloatingActionButton(
            onClick = {viewModel.add()},
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(15.dp)
        )
        {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = androidx.compose.ui.graphics.Color.Blue
            )
        }
    }
}