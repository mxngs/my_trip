package br.senai.sp.jandira.mytrip.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrip.R
import br.senai.sp.jandira.mytrip.model.Viagem
import java.time.LocalDate

class ViagemRepository {
    @Composable
    fun listarTodasAsViagens(context: Context): List<Viagem> {


        val londres = Viagem()
        londres.id = 1
        londres.destino = "Londres"
        londres.descricao = "Londres, capital da Inglaterra e do Reino Unido, é uma cidade do século 21 com uma história que remonta à era romana."
        londres.dataChegada = LocalDate.of(2019, 2, 18)
        londres.dataChegada = LocalDate.of(2019, 2, 21)
        londres.imagem = null

        val porto = Viagem()
        porto.id = 2
        porto.destino = "Porto"
        porto.descricao = "Porto é uma cidade costeira no noroeste de Portugal conhecida pelas pontes imponentes e pela produção de vinho do Porto."
        porto.dataChegada = LocalDate.of(2022, 11, 3)
        porto.dataChegada = LocalDate.of(2022, 11, 12)
        porto.imagem = painterResource(id = R.drawable.porto)

        val italia = Viagem()
        italia.id = 3
        italia.destino = "Italia"
        italia.descricao = "O Japão, país insular no Oceano Pacífico, tem cidades densas, palácios imperiais, parques nacionais montanhosos e milhares de santuários e templos."
        italia.dataChegada = LocalDate.of(2024, 4, 14)
        italia.dataChegada = LocalDate.of(2024, 4, 24)
        italia.imagem = painterResource(id = R.drawable.italiaaa)

        val japao = Viagem()
        japao.id = 4
        japao.destino = "Japão"
        japao.descricao = "O Japão, país insular no Oceano Pacífico, tem cidades densas, palácios imperiais, parques nacionais montanhosos e milhares de santuários e templos."
        japao.dataChegada = LocalDate.of(2015, 7, 5)
        japao.dataChegada = LocalDate.of(2015, 7, 15)
        japao.imagem = painterResource(id = R.drawable.japaoimgg)

        val colombia = Viagem()
        colombia.id = 5
        colombia.destino = "Colômbia"
        colombia.descricao = "A Colômbia é um país no extremo norte da América do Sul. Sua paisagem é marcada por florestas tropicais, pela Cordilheira dos Andes e por várias plantações de café. "
        colombia.dataChegada = LocalDate.of(2024, 1, 3)
        colombia.dataChegada = LocalDate.of(2024, 1, 12)
        colombia.imagem = null


        val viagens = listOf(
            londres, porto, italia, japao, colombia
        )

        return viagens
    }
}