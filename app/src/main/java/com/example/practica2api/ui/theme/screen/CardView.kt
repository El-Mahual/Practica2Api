package com.example.practica2api.ui.theme.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.example.practica2api.network.Student
import com.example.practica2api.network.Wand

@Composable
fun CharacterCard(estudiante: Student) {
    Card(
        border = BorderStroke(2.dp, Color.Black),  // Borde negro alrededor del círculo
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f) // Proporción 1:1 para que la tarjeta sea siempre cuadrada
            .fillMaxWidth(0.45f), // Control del ancho para asegurar que no sea demasiado grande
        elevation = CardDefaults.cardElevation(8.dp) // Sombra
    ) {
        // Mostrar la imagen del estudiante
        Image(
            painter = rememberAsyncImagePainter(model = estudiante.image),
            contentDescription = "Imagen de ${estudiante.name}",
            contentScale = ContentScale.Crop, // Ajusta la imagen para que llene el espacio
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Ajustamos la altura de la imagen
        )

        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre la imagen y el texto

        // Mostrar el nombre del estudiante
        Text(
            text = "Nombre: ${estudiante.name}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Mostrar la casa de Hogwarts
        Text(
            text = "Casa: ${estudiante.house}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Mostrar el año de nacimiento
        Text(
            text = "Año de nacimiento: ${estudiante.yearOfBirth}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Mostrar el patronus del estudiante
        Text(
            text = "Patronus: ${estudiante.patronus}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Mostrar el género del estudiante
        Text(
            text = "Género: ${estudiante.gender}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Mostrar la especie del estudiante
        Text(
            text = "Especie: ${estudiante.species}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Mostrar si el estudiante está vivo o no
        Text(
            text = "Vivo: ${estudiante.alive}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Mostrar el actor que interpreta al personaje
        Text(
            text = "Actor: ${estudiante.actor}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterCard() {
    // Ejemplo de un personaje ficticio para la vista previa
    val sampleCharacter = Student(
        id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
        name = "Harry Potter",
        alternate_names = listOf("El niño que sobrevivió", "El elegido"),
        species = "human",
        gender = "male",
        house = "Gryffindor",
        dateOfBirth = "31-07-1980",
        yearOfBirth = "1980",
        wizard = "",
        ancestry = "half-blood",
        eyeColour = "green",
        hairColour = "black",
        wand = Wand(wood = "holly", core = "phoenix tail feather", length = "11"),
        patronus = "stag",
        hogwartsStudent = "dfdfdf",
        hogwartsStaff = "",
        actor = "Daniel Radcliffe",
        alternate_actors = emptyList(),
        alive = "",
        image = "https://ik.imagekit.io/hpapi/harry.jpg"
    )

    // Llamamos a la tarjeta de personaje con los datos de muestra
    CharacterCard(estudiante = sampleCharacter)
}
