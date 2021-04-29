package com.example.calculadoraimcveiga.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperDB(
    context: Context?
) : SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO_ATUAL) {
    companion object {
        private  val NOME_BANCO = "imc.db"
        private  val VERSAO_ATUAL = 1
    }
    val TABLE_NAME = "imc"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val COLUMS_ID = "id"
    val COLUMS_IMC = "imc"
    val COLUMS_GRAU = "grau"
    val COLUMS_DATE = "data"
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "$COLUMS_ID INTEGER NOT NULL," +
            "$COLUMS_IMC REAL NOT NULL," +
            "$COLUMS_GRAU TEXT NOT NULL," +
            "" +
            "PRIMARY KEY($COLUMS_ID AUTOINCREMENT)" +
            ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db : SQLiteDatabase?, oldVersion : Int, newVersion : Int) {
        if(newVersion != oldVersion){
            db?.execSQL(DROP_TABLE)
         }
        onCreate(db)
    }
    fun salvarImc(imc : String, grau : String){
        val db : SQLiteDatabase = writableDatabase ?: return
        val sql = "INSERT INTO $TABLE_NAME($COLUMS_IMC,$COLUMS_GRAU) VALUES ('$imc','$grau')"
        db.execSQL(sql)
        db.close()
    }
    fun buscarImc() {
        val db = readableDatabase
        val sql = "SELECT * FROM $TABLE_NAME"
        return db.execSQL(sql)

    }

}