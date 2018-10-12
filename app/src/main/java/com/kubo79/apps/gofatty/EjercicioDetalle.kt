package com.kubo79.apps.gofatty

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_ejercicio_detalle.*

class EjercicioDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio_detalle)
        val extras= this.intent.extras
        txtNombreEjercicio.setText(extras.get("name").toString())
        wvDescripcionEjercicio.loadDataWithBaseURL(null,"<body>${extras.get("description").toString()}</body>",null,null,null)
       /* if(extras.get("image")!=""){
            Picasso.get().load("").into(imgEjercicio)
        }*/
    }
}
