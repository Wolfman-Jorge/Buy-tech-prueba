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


    fun seleccionar(): String{

        var txRaton = ""
        var txTeclado = ""
        var txAltavoz = ""
        var txCable = ""

        if(raton)
            txRaton = "Ha seleccionado un ratón\n"
        if(teclado)
            txTeclado = "Ha seleccionado un teclado\n"
        if(altavoz)
            txAltavoz = "Ha seleccionado un altavoz\n"
        if(cable)
            txCable = "Ha seleccinado un cable USB\n"

        return txRaton + txTeclado + txAltavoz + txCable
    }

    fun comprar() : String{

        var txRaton = ""
        var txTeclado = ""
        var txAltavoz = ""
        var txCable = ""

        if(raton)
            txRaton = "Ha comprado un ratón\n"
        if(teclado)
            txTeclado = "Ha comprado un teclado\n"
        if(altavoz)
            txAltavoz = "Ha comprado un altavoz\n"
        if(cable)
            txCable = "Ha comprado un cable USB\n"

        return txRaton + txTeclado + txAltavoz + txCable
    }
}