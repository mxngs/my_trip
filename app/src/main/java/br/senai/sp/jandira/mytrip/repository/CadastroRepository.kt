package br.senai.sp.jandira.mytrip.repository

import android.content.Context
import br.senai.sp.jandira.mytrip.dao.CadastroDb
import br.senai.sp.jandira.mytrip.model.Cadastro

class CadastroRepository (context: Context){
        private val db = CadastroDb.getBancoDeDados(context).cadastroDao()

        fun salvar(cadastro: Cadastro): Long{
            return db.salvar(cadastro)
        }

        fun buscarTodosOsUsuariois(): List<Cadastro>{
            return db.listarTodosOsUsuarios()
        }

        fun buscarUsuarioPeloId(id: Long): Cadastro{
            return db.buscarCadastroPeloId(id)
        }
    fun login (email:String, senha:String): Pair<Boolean, Cadastro?> {
        var usuario = db.login(email, senha)
        return Pair(usuario != null, usuario)
    }
}