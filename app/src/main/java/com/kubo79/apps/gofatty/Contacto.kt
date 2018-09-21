package com.kubo79.apps.gofatty

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contacto.*
import org.jetbrains.anko.toast

class Contacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)
        val telefono="9993533192"
        val email="contacto@gofattyapp.com"
        btnLlamar.setOnClickListener {
            if(!telefono.isEmpty()){
                val dial= "tel:$telefono"
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dial)))
            }else{
                toast("No se puede realizar la llamada")
            }
        }

        btnEmail.setOnClickListener {
            val emailIntent= Intent(Intent.ACTION_SEND)
            val TO = arrayOf(email)
            emailIntent.data= Uri.parse("mailto:")
            emailIntent.type="text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL,TO)
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Duda sobre Itinerario")
            try{
                startActivity(Intent.createChooser(emailIntent,"Enviar email..."))
            }catch(ex: ActivityNotFoundException){
                toast("No tienes un cliente de email por defecto")
            }
        }
    }
}
