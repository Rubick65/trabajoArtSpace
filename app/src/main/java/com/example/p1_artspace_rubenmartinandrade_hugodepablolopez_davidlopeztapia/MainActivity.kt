//Creado por Hugo de Pabló, Ruben Martín, David López

package com.example.p1_artspace_rubenmartinandrade_hugodepablolopez_davidlopeztapia

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p1_artspace_rubenmartinandrade_hugodepablolopez_davidlopeztapia.ui.theme.P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme


//Modelo para cada obra
data class Obra(
    @StringRes val titulo: Int, @StringRes val artista: Int, @DrawableRes val imagen: Int
)

//Lista de obras
val obras = listOf(
    Obra(R.string.gunter_titulo, R.string.gunter_artista, R.drawable.gunter),
    Obra(R.string.guardian_titulo, R.string.guardian_artista, R.drawable.guardian),
    Obra(R.string.justicia_titulo, R.string.justicia_artista, R.drawable.justicia),
    Obra(R.string.reyhielo_titulo, R.string.reyhielo_artista, R.drawable.reyhielo)
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CrearInterfaz(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


// Parámetros de la imagen
data class ImagenParams(
    val boxWidth: Int, val boxHeight: Int, val imageSize: Int, val imagePadding: Int
)

// Parámetros de la información de la obra
data class InfoParams(
    val columnWidth: Int,
    val columnHeight: Int,
    val textSize1: Int,
    val textSize2: Int,
    val buttonWidth: Int,
    val buttonHeight: Int
)

/**
 * Creacion de titulo
 */
@Composable
fun CrearTitulo(@StringRes titulo: Int, modifier: Modifier = Modifier, textSize: Int) {
    Text(
        text = stringResource(titulo),
        fontSize = textSize.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black.copy(alpha = 1f),
        fontFamily = FontFamily.Cursive,
        modifier = modifier
    )
}

/**
 * Creacion de imagen
 */
@Composable
fun CrearImagen(
    @DrawableRes imagen: Int,
    modifier: Modifier = Modifier,
    boxWidth: Int,
    boxHeight: Int,
    imageSize: Int,
    imagePadding: Int
) {
    Surface(
        modifier = modifier
            .padding(bottom = imagePadding.dp)
            .border(width = 1.dp, color = Color.Gray)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(bottomEnd = 16.dp), clip = false),
    ) {
        Box(
            modifier = Modifier.size(width = boxWidth.dp, height = boxHeight.dp)
        ) {
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                modifier = Modifier
                    .size(imageSize.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

/**
 * Creacion de la interfaz
 */
@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CrearInterfaz(modifier: Modifier = Modifier) {

    var index by remember { mutableStateOf(0) }
    val obraActual = obras[index]

    BoxWithConstraints (
        modifier = Modifier.fillMaxSize(),
    ) {
        val ancho = maxWidth
        // En función del ancho de la pantalla cambiamos el tamaño de los textos
        val textSizeTitulo = when {
            ancho < 600.dp -> 40
            ancho < 840.dp -> 50
            else -> 40
        }

        // Parámetros de la imagen
        val imagenParams = when {
            ancho < 400.dp -> ImagenParams(350, 500, 400, 100)
            ancho < 600.dp -> ImagenParams(350, 500, 400, 100)
            ancho < 840.dp -> ImagenParams(620, 800, 700, 200)
            else -> ImagenParams(300, 450, 350, 100)
        }

        // Parámetros de la información de la obra
        val infoParams = when {
            ancho < 600.dp -> InfoParams(280, 110, 20, 22, 150, 40)
            ancho < 840.dp -> InfoParams(380, 180, 30, 32, 200, 60)
            else -> InfoParams(280, 110, 20, 22, 150, 45)
        }

        CrearTitulo(
            obraActual.titulo,
            Modifier
                .align(Alignment.TopCenter)
                .padding(top = 40.dp),
            textSize = textSizeTitulo
        )

        CrearImagen(
            obraActual.imagen,
            Modifier.align(Alignment.Center),
            boxWidth = imagenParams.boxWidth,
            boxHeight = imagenParams.boxHeight,
            imageSize = imagenParams.imageSize,
            imagePadding = imagenParams.imagePadding
        )

        InfoObra(
            obra = obraActual,
            index = index,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            columnWith = infoParams.columnWidth,
            columnHeight = infoParams.columnHeight,
            texSize1 = infoParams.textSize1,
            textSize2 = infoParams.textSize2,
            buttonWidth = infoParams.buttonWidth,
            buttonHeight = infoParams.buttonHeight,
            onClickNext = {
                index = if (index < 3) index + 1 else 0
            },
            onClickPrevious = {
                index = if (index > 0) index - 1 else 3
            }
        )
    }
}


/**
 * Creacion de la informacion de la obra actual
 */
@Composable
fun InfoObra(
    obra: Obra,
    index: Int,
    modifier: Modifier = Modifier,
    columnWith: Int,
    columnHeight: Int,
    texSize1: Int,
    textSize2: Int,
    buttonWidth: Int,
    buttonHeight: Int,
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit
) {

    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = Color(0xFFF5F5F5), // gris clarito casi blanco
            shape = RoundedCornerShape(12.dp),
            shadowElevation = 4.dp,
            modifier = Modifier
                .width(columnWith.dp)
                .height(columnHeight.dp)
                .padding(horizontal = 16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = stringResource(obra.artista),
                    fontSize = texSize1.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Cursive
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Imagen ${index + 1}/${obras.size}",
                    fontSize = textSize2.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        //Creacion de los botones con sus funciones
        CrearBotones(
            texSize = texSize1,
            buttonHeight = buttonHeight,
            buttonWidth = buttonWidth,
            onClickNext = onClickNext,
            onClickPrevious = onClickPrevious
        )
    }
}

/**
 * Creacion de los botones con sus funciones
 */
@Composable
fun CrearBotones(
    modifier: Modifier = Modifier,
    buttonWidth: Int,
    buttonHeight: Int,
    texSize: Int,
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit
) {

    Box(modifier = modifier.fillMaxWidth()) {
        Button(
            modifier = Modifier
                .padding(start = 30.dp)
                .width(buttonWidth.dp)
                .height(buttonHeight.dp)
                .align(Alignment.CenterStart), onClick = onClickPrevious
        ) {
            Text(
                text = stringResource(R.string.previouse), fontSize = texSize.sp
            )
        }
        Button(
            modifier = Modifier
                .padding(end = 30.dp)
                .width(buttonWidth.dp)
                .height(buttonHeight.dp)
                .align(Alignment.BottomEnd), onClick = onClickNext
        ) {
            Text(
                text = stringResource(R.string.next), fontSize = texSize.sp

            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    P1_ArtSpace_RubenMartinAndrade_HugodePabloLopez_DavidLopezTapiaTheme {
        CrearInterfaz()
    }
}
