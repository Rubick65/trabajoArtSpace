package com.example.p1_artspace_rubenmartinandrade_hugodepablolopez_davidlopeztapia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.p1_artspace_rubenmartinandrade_hugodepablolopez_davidlopeztapia.ui.theme.P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
        Greeting("Android")
    }
}