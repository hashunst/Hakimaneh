package ir.fater.hakimaneh.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.fater.hakimaneh.db.dao.HekmatDao
import ir.fater.hakimaneh.db.dao.KhotbeDao
import ir.fater.hakimaneh.db.dao.ReadDao
import ir.fater.hakimaneh.db.entity.Hekmat
import ir.fater.hakimaneh.db.entity.Khotbe
import ir.fater.hakimaneh.db.entity.Read

@Database(entities = arrayOf(Hekmat::class,Khotbe::class, Read::class), version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun hekmatDao(): HekmatDao
    abstract fun khotbeDao(): KhotbeDao
    abstract fun readDao(): ReadDao
    companion object {
        private var INSTANCE: MainDB? = null
        fun getDatabase(context: Context): MainDB? {
            if (INSTANCE == null) {
                synchronized(MainDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        MainDB::class.java, "chapter.db"
                    )
                        .createFromAsset("databases/db.db")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}