package ir.fater.hakimaneh.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Khotbe(

    @PrimaryKey(autoGenerate =true)
    var id:Int,
    var matn:String,
    var date:Long
)