package com.example.p1_artspace_rubenmartinandrade_hugodepablolopez_davidlopeztapia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
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
                    crearInterfaz(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun crearTitulo(@StringRes titulo: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(titulo),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black.copy(alpha = 1f), //100% de opacidad
        fontFamily = FontFamily.Cursive,
        modifier = modifier
    )
}


@Composable
fun crearImagen(@DrawableRes imagen: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .border(width = 1.dp, color = Color.Gray)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(bottomEnd = 16.dp), clip = false),
    )
    {
        Box(
            modifier = Modifier
                .height(500.dp)
                .width(350.dp)
        )
        {
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun crearInterfaz(modifier: Modifier = Modifier) {
    var titulo by remember { mutableStateOf(R.string.gunter_Titulo) }
    var imagen by remember { mutableStateOf(R.drawable.gunter) }
    Box(
        modifier = Modifier.fillMaxSize(),
    )
    {
        crearTitulo(
            titulo, Modifier
                .align(Alignment.TopCenter)
                .padding(top = 40.dp)
        )
        crearImagen(imagen, Modifier.align(Alignment.Center))
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
        crearInterfaz()
    }
}