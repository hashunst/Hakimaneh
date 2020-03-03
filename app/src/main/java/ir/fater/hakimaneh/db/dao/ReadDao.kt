package ir.fater.hakimaneh.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.fater.hakimaneh.db.entity.Read

@Dao
interface ReadDao {

    @Insert
    fun insert(read: Read)

    @Delete
    fun delete(read: Read)

    @Query("SELECT * FROM Read")
    fun all(): List<Read>
}