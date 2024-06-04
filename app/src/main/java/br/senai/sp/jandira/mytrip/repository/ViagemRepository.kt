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


        val viagemLondres = Viagem()
        viagemLondres.id = 1
        viagemLondres.destino = "Londres"
        viagemLondres.descricao =
            "Londres, capital da Inglaterra e do Reino Unido, é uma cidade do século 21 com uma história que remonta à era romana. "
        viagemLondres.dataChegada = LocalDate.of(2023, 7, 18)
        viagemLondres.dataPartida = LocalDate.of(2023, 7, 25)
        viagemLondres.imagem = painterResource(id = R.drawable.london)

        val viagemParis = Viagem()
        viagemParis.id = 2
        viagemParis.destino = "Paris"
        viagemParis.descricao =
            "Paris, a capital da França, é uma importante cidade europeia e um centro mundial de arte, moda, gastronomia e cultura.  "
        viagemParis.dataChegada = LocalDate.of(2023, 7, 26)
        viagemParis.dataPartida = LocalDate.of(2023, 8, 4)
        viagemParis.imagem = painterResource(id = R.drawable.paris2)

        val viagemPorto = Viagem()
        viagemPorto.id = 3
        viagemPorto.destino = "Porto"
        viagemPorto.descricao =
            "Porto é uma cidade costeira no noroeste de Portugal conhecida pelas pontes imponentes e pela produção de vinho do Porto. "
        viagemPorto.dataChegada = LocalDate.of(2022, 12, 24)
        viagemPorto.dataPartida = LocalDate.of(2022, 12, 28)
        viagemPorto.imagem = painterResource(id = R.drawable.porto)

        val viagemMaldivas = Viagem()
        viagemMaldivas.id = 4
        viagemMaldivas.destino = "Maldivas"
        viagemMaldivas.descricao =
            "Maldivas é conhecido pelas praias, pelas lagoas azuis e pelos extensos recifes.  "
        viagemMaldivas.dataChegada = LocalDate.of(2019, 5, 15)
        viagemMaldivas.dataPartida = LocalDate.of(2019, 5, 17)
        viagemMaldivas.imagem = painterResource(id = R.drawable.maldivas)

        val viagemLencoisMaranhenses = Viagem()
        viagemLencoisMaranhenses.id = 4
        viagemLencoisMaranhenses.destino = "Lençóis Maranhenses"
        viagemLencoisMaranhenses.descricao =
            "É conhecido pela sua vasta paisagem desértica de grandes dunas de areia branca e pelas lagoas sazonais de água da chuva. "
        viagemLencoisMaranhenses.dataChegada = LocalDate.of(2022, 5, 15)
        viagemLencoisMaranhenses.dataPartida = LocalDate.of(2022, 5, 17)
        viagemLencoisMaranhenses.imagem = painterResource(id = R.drawable.maranhao)

        val viagens = listOf(
            viagemMaldivas,
            viagemLencoisMaranhenses,
            viagemPorto,
            viagemLondres,
            viagemParis
        )

        return viagens
    }
}