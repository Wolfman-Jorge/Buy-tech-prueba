package com.miempresa.buytech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miempresa.buytech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Para usar binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Actualizar estado de checkbox
        binding.raton.isChecked = Carrito.raton
        binding.teclado.isChecked = Carrito.teclado
        binding.altavoces.isChecked = Carrito.altavoz
        binding.usbCable.isChecked = Carrito.cable



        binding.raton.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked)
                Toast.makeText(this, "Ratón añadido", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Ratón eliminado", Toast.LENGTH_SHORT).show()
        }

        binding.teclado.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked)
                Toast.makeText(this, "Teclado añadido", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Teclado eliminado", Toast.LENGTH_SHORT).show()
        }

        binding.altavoces.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked)
                Toast.makeText(this, "Altavoces añadidos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Altavoces eliminados", Toast.LENGTH_SHORT).show()
        }

        binding.usbCable.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked)
                Toast.makeText(this, "Cable USB añadido", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Cable USB eliminado", Toast.LENGTH_SHORT).show()
        }

        binding.btSiguiente.setOnClickListener{
            if(binding.raton.isChecked || binding.teclado.isChecked || binding.altavoces.isChecked || binding.usbCable.isChecked) {
                if (binding.btEnvio.isChecked || binding.btRecoger.isChecked)
                    startActivity(Intent(this, DatosActivity::class.java))
                else
                    Toast.makeText(this,"Debe seleccionar una forma de entrega", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, "No hay productos seleccionados", Toast.LENGTH_SHORT).show()
        }

    }



}