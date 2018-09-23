package com.kubo79.apps.gofatty

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_ver_ejercicios.*
import kotlinx.android.synthetic.main.activity_ver_rutina.*
import org.jetbrains.anko.longToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VerEjercicios : AppCompatActivity() {
    lateinit var ejercicios: List<Ejercicio>
    lateinit var cliente: Retrofit
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_ejercicios)
        cliente = Retrofit.Builder().baseUrl("http://lit-dusk-58621.herokuapp.com/").addConverterFactory(GsonConverterFactory.create()).build()
        apiService = cliente.create(ApiService::class.java)
        apiService.listaEjercicios().enqueue(object : Callback<List<Ejercicio>> {
            override fun onResponse(call: Call<List<Ejercicio>>, response: Response<List<Ejercicio>>) {
                Log.i("Cliente", "Cliente Android")
                if (response.isSuccessful) {
                    ejercicios = response.body()
                    var arraynombres=ArrayList<String>()
                    for (ejercicio in ejercicios) {
                        arraynombres.add(ejercicio.name)
                    }
                    val arrayAdapter=ArrayAdapter<String>(this@VerEjercicios,android.R.layout.simple_list_item_1,arraynombres)
                    lsvListaEjercicios.adapter=arrayAdapter
                }
            }

            override fun onFailure(call: Call<List<Ejercicio>>, t: Throwable) {
                longToast("Error: ${t.message}")

            }
        })


        //Botón el clic
        lsvListaEjercicios.setOnItemClickListener { _, _, i, _ ->
            val intent=Intent(this,EjercicioDetalle::class.java)
            intent.putExtra("name",ejercicios[i].name)
            intent.putExtra("description",ejercicios[i].description)
            intent.putExtra("image",ejercicios[i].image)
            startActivity(intent)
        }
    }
}
