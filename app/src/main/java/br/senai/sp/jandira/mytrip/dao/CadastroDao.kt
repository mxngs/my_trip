package br.senai.sp.jandira.mytrip.dao

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrip.model.Cadastro

@Dao
interface CadastroDao {

    @Insert
    fun salvar (cadastro: Cadastro): Long

    @Query("SELECT * FROM tbl_cadastro ORDER BY username ASC")
    fun listarTodosOsUsuarios(): List<Cadastro>

    @Query(" SELECT * FROM tbl_cadastro WHERE id = :id")
    fun buscarCadastroPeloId(id:Long): Cadastro

    @Query("SELECT * from tbl_cadastro where email= :email and senha = :senha")
    fun login(email: String, senha:String): Cadastro?


}