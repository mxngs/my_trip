package br.senai.sp.jandira.mytrip.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_cadastro")
data class Cadastro(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var username: String = "",
    var telefone: String = "",
    var email: String = "",
    var senha: String = "",
    @ColumnInfo(name = "maior_de_idade")var maiorDeIdade: Boolean = false
)
