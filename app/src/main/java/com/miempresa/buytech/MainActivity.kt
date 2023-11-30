package com.miempresa.buytech

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miempresa.buytech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Para usar binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.setIcon(R.mipmap.ic_launcher)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        binding.raton.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, getString(R.string.ratonAnadido), Toast.LENGTH_SHORT).show()
                Carrito.raton = isChecked
            }else {
                Toast.makeText(this, getString(R.string.ratonEliminado), Toast.LENGTH_SHORT).show()
                Carrito.raton = false
            }
        }

        binding.teclado.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, getString(R.string.tecladoAnadido), Toast.LENGTH_SHORT).show()
                Carrito.teclado = isChecked
            }else {
                Toast.makeText(this, getString(R.string.tecladoEliminado), Toast.LENGTH_SHORT).show()
                Carrito.teclado = false
            }
        }

        binding.altavoces.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, getString(R.string.altavozAnadido), Toast.LENGTH_SHORT).show()
                Carrito.altavoz = isChecked
            }else {
                Toast.makeText(this, getString(R.string.altavozEliminado), Toast.LENGTH_SHORT).show()
                Carrito.altavoz = false
            }
        }

        binding.usbCable.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                Toast.makeText(this, getString(R.string.cableAnadido), Toast.LENGTH_SHORT).show()
                Carrito.cable = isChecked
            }else {
                Toast.makeText(this, getString(R.string.cableEliminado), Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this,getString(R.string.formaEntrega), Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, getString(R.string.productos), Toast.LENGTH_SHORT).show()
        }

    }

}