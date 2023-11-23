package com.miempresa.buytech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miempresa.buytech.databinding.ActivityDatosBinding
import com.miempresa.buytech.databinding.ActivityMainBinding

class DatosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}