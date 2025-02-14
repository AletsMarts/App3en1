package com.example.app3en1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.app3en1.ui.theme.App3en1Theme
import com.example.app3en1.navigation.NavManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App3en1Theme {
                NavManager()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App3en1Theme {
        NavManager()
    }
}