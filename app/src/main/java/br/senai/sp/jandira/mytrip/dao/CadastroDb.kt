package br.senai.sp.jandira.mytrip.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mytrip.model.Cadastro

@Database(entities = [Cadastro::class], version = 2)
abstract  class CadastroDb : RoomDatabase() {
    abstract fun cadastroDao(): CadastroDao

    companion object{
        private lateinit var instancia: CadastroDb
        fun getBancoDeDados(context: Context): CadastroDb{
            instancia = Room
                .databaseBuilder(
                    context,
                    CadastroDb::class.java,
                    "db_cadastro"
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return instancia

        }

    }
}