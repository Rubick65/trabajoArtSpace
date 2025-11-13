package com.example.p1_artspace_rubenmartinandrade_hugodepablolopez_davidlopeztapia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p1_artspace_rubenmartinandrade_hugodepablolopez_davidlopeztapia.ui.theme.P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  //
                }
            }
        }
    }
}

@Composable
fun crearTitulo(@StringRes titulo: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = modifier.padding(top = 30.dp)
        ) {
            Text(
                text = stringResource(titulo),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun crearImagen(@DrawableRes imagen: Int) {
    Image(
        painter = painterResource(imagen),
        contentDescription = null
    )
}

@Composable
fun crearInterfaz() {
    var titulo by remember { mutableStateOf((R.string.holiwi)) }
    var imagen by remember { mutableStateOf(R.drawable.gunter)}
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        crearTitulo(titulo)
        Spacer(modifier = Modifier.height(40.dp))
        crearImagen(imagen)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
        crearInterfaz()
    }
}