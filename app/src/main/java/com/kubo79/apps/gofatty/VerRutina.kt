package com.kubo79.apps.gofatty

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.text.HtmlCompat.fromHtml
import android.util.Log
import kotlinx.android.synthetic.main.activity_ver_rutina.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





class VerRutina : AppCompatActivity() {
    lateinit var generalesRutina: Rutina
    lateinit var cliente: Retrofit
    lateinit var apiService: ApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_rutina)
        cliente = Retrofit.Builder().baseUrl("http://lit-dusk-58621.herokuapp.com/").addConverterFactory(GsonConverterFactory.create()).build()
        apiService = cliente.create(ApiService::class.java)
        apiService.datosRutina().enqueue(object : Callback<Rutina> {
            override fun onResponse(call: Call<Rutina>, response: Response<Rutina>) {
                Log.i("Cliente", "Cliente Android")
                if (response.isSuccessful) {
                    generalesRutina = response.body()

                        txtNombreRutina.setText(fromHtml(generalesRutina.name,0))
                        wvGeneralesRutina.loadDataWithBaseURL(null,"<body>${generalesRutina.description}</body>",null,null,null)

                }
            }

            override fun onFailure(call: Call<Rutina>, t: Throwable) {
                longToast("Error: ${t.message}")

            }
        })


        //Botón de ver ejercicios
        btnVerEjerciciosRutina.setOnClickListener {
            val intent=Intent(this,VerEjercicios::class.java)
            startActivity(intent)
        }

    }
}
