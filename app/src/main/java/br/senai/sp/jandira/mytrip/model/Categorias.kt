package br.senai.sp.jandira.mytrip.model

import androidx.compose.ui.graphics.painter.Painter
import java.time.LocalDate

data class Categorias(

    var id : Int = 0,
    var categoria: String = "",
    //o ? permite que o objeto seja nulo.
    var imagem: Painter? = null
)
