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

        binding.raton.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, "Ratón añadido", Toast.LENGTH_SHORT).show()
                Carrito.raton = isChecked
            }else {
                Toast.makeText(this, "Ratón eliminado", Toast.LENGTH_SHORT).show()
                Carrito.raton = false
            }
        }

        binding.teclado.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, "Teclado añadido", Toast.LENGTH_SHORT).show()
                Carrito.teclado = isChecked
            }else {
                Toast.makeText(this, "Teclado eliminado", Toast.LENGTH_SHORT).show()
                Carrito.teclado = false
            }
        }

        binding.altavoces.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, "Altavoces añadidos", Toast.LENGTH_SHORT).show()
                Carrito.altavoz = isChecked
            }else {
                Toast.makeText(this, "Altavoces eliminados", Toast.LENGTH_SHORT).show()
                Carrito.altavoz = false
            }
        }

        binding.usbCable.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, "Cable USB añadido", Toast.LENGTH_SHORT).show()
                Carrito.cable = isChecked
            }else {
                Toast.makeText(this, "Cable USB eliminado", Toast.LENGTH_SHORT).show()
                Carrito.cable = false
            }
        }

        binding.btSiguiente.setOnClickListener{
            if(binding.raton.isChecked || binding.teclado.isChecked || binding.altavoces.isChecked || binding.usbCable.isChecked) {
                if (binding.btRecoger.isChecked)
                    startActivity(Intent(this, RecogerActivity::class.java))
                else if (binding.btEnvio.isChecked)
                    startActivity(Intent(this, EnviarActivity::class.java))
                else
                    Toast.makeText(this,"Debe seleccionar una forma de entrega", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, "No hay productos seleccionados", Toast.LENGTH_SHORT).show()
        }

    }



}