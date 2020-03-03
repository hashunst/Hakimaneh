package ir.fater.hakimaneh.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Read(
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var id_hekmat:Long
)