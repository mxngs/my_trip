package br.senai.sp.jandira.mytrip.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrip.R
import br.senai.sp.jandira.mytrip.model.Categorias
import br.senai.sp.jandira.mytrip.model.Viagem
import java.time.LocalDate

class CategoriaRepository {

    @Composable
    fun listarTodasCategorias(context: Context): List<Categorias>{

        val categoriaMontain= Categorias()
        categoriaMontain.id = 1
        categoriaMontain.categoria = "Mountain"
        categoriaMontain.imagem = painterResource(id = R.drawable.montanha)

        val categoriaSnow= Categorias()
        categoriaSnow.id = 2
        categoriaSnow.categoria = "Snow"
        categoriaSnow.imagem = painterResource(id = R.drawable.neve)

        val categoriaBeach= Categorias()
        categoriaBeach.id = 3
        categoriaBeach.categoria = "Beach"
        categoriaBeach.imagem = painterResource(id = R.drawable.guarda_sol)

        val categorias = listOf(
            categoriaMontain,
            categoriaBeach,
            categoriaSnow
        )

        return categorias

    }

}