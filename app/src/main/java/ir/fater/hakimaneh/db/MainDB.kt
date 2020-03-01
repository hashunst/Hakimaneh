package ir.fater.hakimaneh.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.fater.hakimaneh.db.dao.HekmatDao
import ir.fater.hakimaneh.db.entity.Hekmat

@Database(entities = arrayOf(Hekmat::class), version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun hekmatDao(): HekmatDao
    companion object {
        private var INSTANCE: MainDB? = null
        fun getDatabase(context: Context): MainDB? {
            if (INSTANCE == null) {
                synchronized(MainDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        MainDB::class.java, "chapter.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}