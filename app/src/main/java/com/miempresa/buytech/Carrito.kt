package com.miempresa.buytech

import android.widget.Toast

/**
 * Objeto que representa el carrito de la compra
 */
object Carrito {
    var raton = false
    var teclado = false
    var altavoz = false
    var cable = false


    fun compra() {

        if(raton)
            raton = true

        if(teclado)
            teclado = true

        if(altavoz)
            altavoz = true

        if(cable)
            cable = true
    }
}