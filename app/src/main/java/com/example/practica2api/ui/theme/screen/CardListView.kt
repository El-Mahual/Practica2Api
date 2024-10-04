package com.example.practica2api.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practica2api.network.Student

@Composable
fun CardList(info: List<Student>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), // Definir dos columnas fijas
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Padding para la lista
        contentPadding = PaddingValues(8.dp), // Padding para el contenido
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espacio entre filas
        horizontalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre columnas
    ) {
        items(info) { estudiante ->
            CharacterCard(estudiante = estudiante)  // Cada carta que se mostrará
        }
    }
}
