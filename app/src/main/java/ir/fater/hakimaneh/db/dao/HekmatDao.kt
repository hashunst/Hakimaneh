package ir.fater.hakimaneh.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.fater.hakimaneh.db.entity.Hekmat

@Dao
interface HekmatDao {
    @Insert
    fun insert(hekmat: Hekmat)

    @Delete
    fun delete(hekmat: Hekmat)

    @Query("SELECT * FROM hekmat")
    fun all(): List<Hekmat>

    @Query("SELECT * FROM hekmat")
    fun alll() : LiveData<List<Hekmat>>

}