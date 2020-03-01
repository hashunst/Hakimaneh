package ir.fater.hakimaneh.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hekmat(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var matn:String
)