package com.kubo79.apps.gofatty

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        btnVerRutina.setOnClickListener {
            val intent=Intent(this,VerRutina::class.java)
            startActivity(intent)
        }


        btnContacto.setOnClickListener {
            val intent=Intent(this,VerContacto::class.java)
            startActivity(intent)
        }

        btnVerConsejos.setOnClickListener {

        }

        btnVerDieta.setOnClickListener {

        }

        btnVerPromociones.setOnClickListener {
            
        }
    }
}
