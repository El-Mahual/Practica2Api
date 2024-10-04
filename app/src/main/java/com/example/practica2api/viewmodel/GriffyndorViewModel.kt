package com.example.practica2api.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica2api.network.GriffyndorApi
import com.example.practica2api.network.Student
import kotlinx.coroutines.launch

// Definimos una sealed interface para representar los distintos estados de la interfaz
sealed interface StudentUiState {
    data class Success(val students: List<Student>) : StudentUiState // Representa el estado de éxito con la lista de URLs
    object Error : StudentUiState  // Representa un estado de error
    object Loading : StudentUiState  // Representa el estado de carga mientras se obtienen los datos
}

// Creamos el ViewModel que se encargará de manejar la lógica de negocio y los estados de la UI
class GriffyndorViewModel : ViewModel() {

    // Definimos el estado actual de la UI, que puede ser Loading, Success o Error
    var studentUiState: StudentUiState by mutableStateOf(StudentUiState.Loading)
        private set // Lo hacemos privado para evitar modificaciones desde fuera de la clase

    // Al inicializar el ViewModel, llamamos automáticamente a la función para obtener las fotos
    init {
        getStudents() // Llamamos a la función al inicializar
    }

    // Esta función se encarga de hacer las llamadas a la API y gestionar los distintos estados
    fun getStudents() {
        viewModelScope.launch {
            // Indicamos que estamos en estado de carga
            studentUiState = StudentUiState.Loading
            try {

                    val response = GriffyndorApi.retrofitService.getStudents() // Petición a la API

                // Si las peticiones son exitosas, actualizamos el estado a Success y pasamos la lista de URLs
                studentUiState = StudentUiState.Success(students = response)
            } catch (e: Exception) {
                // Si ocurre algún error, cambiamos el estado a Error
                studentUiState = StudentUiState.Error
            }
        }
    }
}
