package br.senai.sp.jandira.mytrip

import java.time.LocalDate

fun simplificarData(dataExtenso: LocalDate): String{
    val dia = "${dataExtenso.dayOfMonth}"

    val mes = "${dataExtenso.month}".substring(0..2)

    return "$dia  $mes"
}

