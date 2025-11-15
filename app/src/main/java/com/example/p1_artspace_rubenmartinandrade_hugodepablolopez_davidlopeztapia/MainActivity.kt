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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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


//INICIO (David)
//Modelo para cada obra
data class Obra(
    @StringRes val titulo: Int,
    @StringRes val artista: Int,
    @DrawableRes val imagen: Int
)

//Lista de obras
val obras = listOf(
    Obra(R.string.gunter_titulo, R.string.gunter_artista, R.drawable.gunter),
    Obra(R.string.guardian_titulo, R.string.guardian_artista, R.drawable.guardian),
    Obra(R.string.justicia_titulo, R.string.justicia_artista, R.drawable.justicia),
    Obra(R.string.reyhielo_titulo, R.string.reyhielo_artista, R.drawable.reyhielo)
)
//FIN (David)


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
        color = Color.Black.copy(alpha = 1f),
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
    ) {
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 500.dp)
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

    //INICIO (David)
    var index by remember { mutableStateOf(0) }
    val obraActual = obras[index]
    //FIN (David)

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Título
        crearTitulo(
            obraActual.titulo,
            Modifier
                .align(Alignment.TopCenter)
                .padding(top = 40.dp)
        )

        // Imagen
        crearImagen(
            obraActual.imagen,
            Modifier.align(Alignment.Center)
        )

        //INICIO_2 (David)
        info_obra(
            obra = obraActual,
            index = index,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp) // separación del borde inferior
        )
        //FIN_2 (David)
    }
}

//INICIO_2 (David)
@Composable
fun info_obra(obra: Obra, index: Int, modifier: Modifier = Modifier) {
    Surface(
        color = Color(0xFFF5F5F5), // gris clarito casi blanco
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 4.dp,
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(
                text = stringResource(obra.artista),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Imagen ${index + 1}/${obras.size}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )
        }
    }
}
//FIN_2 (David)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
        crearInterfaz()
    }
}
