package com.kubo79.apps.gofatty

import retrofit2.Call
import retrofit2.http.GET



interface ApiService {

    @GET("api/v1/rutina/1")
    fun datosRutina(): Call<Rutina>

    @GET("api/v1/ejercicios/1")
    fun listaEjercicios():Call<List<Ejercicio>>
}