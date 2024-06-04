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

        val montanha = Categorias()
        montanha.id = 1
        montanha.categoria = "Montain"
        montanha.imagem = painterResource(id = R.drawable.montanha)

        val neve = Categorias()
        neve.id = 2
        neve.categoria = "Snow"
        neve.imagem = painterResource(id = R.drawable.neve)

        val praia = Categorias()
        praia.id = 3
        praia.categoria = "Beach"
        praia.imagem = painterResource(id = R.drawable.guarda_sol)

        val interior = Categorias()
        interior.id = 4
        interior.categoria = "countryside"
        interior.imagem = painterResource(id = R.drawable.interior
        )

        return listOf(montanha, neve, praia, interior)


    }

}