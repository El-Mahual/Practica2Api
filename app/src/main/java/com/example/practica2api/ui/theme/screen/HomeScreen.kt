package com.example.practica2api.ui.theme.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practica2api.R
import com.example.practica2api.network.Student
import com.example.practica2api.viewmodel.GriffyndorViewModel
import com.example.practica2api.viewmodel.StudentUiState

@Composable
fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(
            text = photos,
            color = Color.Yellow,  // Texto en amarillo
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center  // Centra el contenido en la pantalla
    ) {
        // Imagen de carga
        Image(
            painter = painterResource(id = R.drawable.loader),  // Asegúrate de tener esta imagen en tu carpeta "drawable"
            contentDescription = "Loading",
            modifier = Modifier.size(100.dp)  // Tamaño de la imagen
        )
        Text(
            text = "Cargando...",
            color = Color.Red,  // Texto en rojo
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center  // Centra el contenido en la pantalla
    ) {
        // Imagen de carga
        Image(
            painter = painterResource(id = R.drawable.error_load),  // Asegúrate de tener esta imagen en tu carpeta "drawable"
            contentDescription = "Error",
            modifier = Modifier.size(100.dp)  // Tamaño de la imagen
        )
        Text(
            text = "Error al cargar los datos",
            color = Color.Red,  // Texto en rojo para indicar error
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Obtén el ViewModel
    val studentViewModel: GriffyndorViewModel = viewModel()  // O hiltViewModel() si estás usando Hilt
    val studentUiState = studentViewModel.studentUiState  // Accede al estado del ViewModel

    Column(modifier = modifier.fillMaxSize()) {
        // Barra superior
        TopAppBar(
            title = {
                Text(
                    "GriffindorApp",
                    color = Color.Red,  // Color del texto en rojo
                    modifier = Modifier.fillMaxWidth(),  // Expande el texto a lo largo de la barra
                    textAlign = TextAlign.Center,  // Centra el texto
                    fontFamily = FontFamily.Serif,  // Cambia la fuente (puede ser Sans, Serif, Monospace)
                    fontWeight = FontWeight.Bold,  // Cambia el peso de la fuente a negrita
                    fontStyle = FontStyle.Italic  // Cambia el estilo a cursiva
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Yellow)  // Fondo de la barra en amarillo
        )

        // Pantalla según el estado de la UI
        when (studentUiState) {
            is StudentUiState.Loading -> {
                // Pantalla de carga cuando el estado es "Loading"
                LoadingScreen(modifier = modifier.fillMaxSize())
            }
            is StudentUiState.Success -> {
                // Pantalla de resultados cuando el estado es "Success"
                CardList(info = studentUiState.students, modifier = modifier.fillMaxSize())  // Muestra la lista de estudiantes
            }
            is StudentUiState.Error -> {
                // Pantalla de error cuando el estado es "Error"
                ErrorScreen(modifier = modifier.fillMaxSize())
            }
        }
    }
}


@Composable
fun ImageItem(url: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Red)  // Fondo rojo para cada ítem de imagen
            .padding(8.dp)
    ) {
        Text(
            text = "Image URL: $url",
            color = Color.Yellow,  // Texto en amarillo
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
