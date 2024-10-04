package com.example.practica2api.network

import kotlinx.serialization.Serializable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://hp-api.herokuapp.com/api/"

interface GriffyndorApiService{
    // Obtener una imagen de la categoría sfw o nsfw
    @GET("characters/students")
    suspend fun getStudents():List<Student>
}

object GriffyndorApi {
    val retrofitService: GriffyndorApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GriffyndorApiService::class.java)
    }
}
data class Student(
    val id: String,                       // ID único del estudiante
    val name: String,                     // Nombre del estudiante
    val alternate_names: List<String>,    // Nombres alternativos
    val species: String,                  // Especie (ej. "human")
    val gender: String,                   // Género (ej. "male")
    val house: String,                    // Casa en Hogwarts (ej. "Gryffindor")
    val dateOfBirth: String,              // Fecha de nacimiento (ej. "31-07-1980")
    val yearOfBirth: String,              // Año de nacimiento (ej. "1980")
    val wizard: String,                  // Es un mago (ej. "true")
    val ancestry: String,                 // Linaje (ej. "half-blood")
    val eyeColour: String,                // Color de ojos (ej. "green")
    val hairColour: String,               // Color de cabello (ej. "black")
    val wand: Wand,                       // Información sobre la varita
    val patronus: String,                 // Patronus (ej. "stag")
    val hogwartsStudent: String,         // ¿Es estudiante en Hogwarts? (ej. "true")
    val hogwartsStaff: String,           // ¿Es parte del personal de Hogwarts?
    val actor: String,                    // Actor que interpreta al estudiante (ej. "Daniel Radcliffe")
    val alternate_actors: List<String>,   // Actores alternativos (si los hubiera)
    val alive: String,                   // ¿Está vivo? (ej. "true")
    val image: String                     // URL de la imagen del estudiante
)

// Data class para representar la información de la varita (wand)
@Serializable
data class Wand(
    val wood: String,                     // Tipo de madera de la varita
    val core: String,                     // Núcleo de la varita (ej. "phoenix tail feather")
    val length: String                    // Longitud de la varita (ej. "11")
)