package com.miempresa.buytech

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miempresa.buytech.databinding.ActivityRecogerBinding

class RecogerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecogerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecogerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setIcon(R.mipmap.ic_launcher)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var nombre = binding.etNombre.text
        var dni = binding.etDni.text
        var email = binding.etEmail.text
        var carrito = Carrito.seleccionar()
        var compra = Carrito.comprar()

        binding.btConfirmar.setOnClickListener {
            binding.txResumen.text = ("$nombre\n$dni\n$email\n")
            binding.txResumen2!!.text = ("$carrito")

            if(!(binding.etNombre.length() > 0 && binding.etDni.length() > 0 && binding.etEmail.length() > 0))
                Toast.makeText(this, getString(R.string.rellenarDatos), Toast.LENGTH_LONG).show()
            else
                binding.btComprar.isEnabled = true
        }

        binding.btComprar.setOnClickListener{
            showAlertDialog(compra)
        }

    }

    override fun onSupportNavigateUp(): Boolean{
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }

    private fun showAlertDialog(compra: String){

        AlertDialog.Builder(this).setMessage("$compra")
            .setTitle(getString(R.string.resumen)).setNeutralButton(getString(R.string.cerrar), DialogInterface.OnClickListener{ dialogInterface, i ->
                Toast.makeText(this, getString(R.string.pedido), Toast.LENGTH_SHORT).show()
            })
            .create().show()
    }
}
