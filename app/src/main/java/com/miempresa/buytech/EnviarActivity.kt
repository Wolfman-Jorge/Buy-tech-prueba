package com.miempresa.buytech

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.miempresa.buytech.databinding.ActivityEnviarBinding
import com.miempresa.buytech.databinding.ActivityRecogerBinding

class EnviarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnviarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnviarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nombre = binding.etNombre.text
        var dni = binding.etDni.text
        var email = binding.etEmail.text
        var direccion = binding.etDireccion.text
        var carrito = Carrito.seleccionar()
        var compra = Carrito.comprar()

        binding.btConfirmar.setOnClickListener {
            binding.txResumen.text = ("$nombre\n$dni\n$email\n$direccion\n$carrito")

            if(!(binding.etNombre.length() > 0 && binding.etDni.length() > 0 && binding.etEmail.length() > 0 && binding.etDireccion.length() > 0))
                Toast.makeText(this, "Debe rellenar los datos personales para poder finalizar la compra", Toast.LENGTH_LONG).show()
            else
                binding.btComprar.isEnabled = true
        }

        binding.btComprar.setOnClickListener{
            showAlertDialog(compra)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.menu_detalle, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_bar_arrow -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAlertDialog(compra: String){

        AlertDialog.Builder(this).setMessage("$compra")
            .setTitle("Resumen de compra").setNeutralButton("Cerrar", DialogInterface.OnClickListener{ dialogInterface, i ->
                Toast.makeText(this, "Pedido realizado con éxito", Toast.LENGTH_SHORT).show()
            })
            .create().show()
    }

}