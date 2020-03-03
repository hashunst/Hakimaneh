package ir.fater.hakimaneh.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.fater.hakimaneh.db.entity.Khotbe


@Dao
interface KhotbeDao{

    @Insert
    fun insert(khotbe:Khotbe)

    @Delete
    fun delete(khotbe: Khotbe)

    @Query("SELECT * FROM Khotbe")
    fun all() : List<Khotbe>
}