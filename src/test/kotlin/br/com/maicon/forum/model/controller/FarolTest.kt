package br.com.maicon.forum.model.controller

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FarolTest {
    @Test
    fun main() {
        while (true) {
            Farol("Verde", 60).printFarol()
            Farol("Amarelo", 60).printFarol()
            Farol("Vermelho", 30).printFarol()
        }
    }
}

class Farol( var cor: String = "",
             var tempo: Int = 0) {
    fun printFarol() {
        Thread.sleep( 5 * 1000 );
        println(this.cor)
    }
}