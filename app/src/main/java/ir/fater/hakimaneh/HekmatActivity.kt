package ir.fater.hakimaneh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.fater.hakimaneh.db.MainDB
import ir.fater.hakimaneh.db.entity.Read
import kotlinx.android.synthetic.main.activity_hekmat.*
import java.util.*
import kotlin.concurrent.thread

class HekmatActivity : AppCompatActivity() {

    var shomareHekmat = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hekmat)


//        1. all hekmats
//        2. matn = hekmate 0
//        3. next -> hekmat badi
//        4. pre -> hekmat ghabli
//        5. badan -> finish()
//        6. motale -> read + finish()

        updateMatn()

        btn_next.setOnClickListener {
            shomareHekmat++
            updateMatn()
        }

        btn_pre.setOnClickListener {
            shomareHekmat--
            updateMatn()
        }

        btn_badan.setOnClickListener {
            finish()
        }

        btn_motalee.setOnClickListener {

            thread {
                var hekam = MainDB.getDatabase(this)!!.hekmatDao().all()
                var id = hekam[shomareHekmat].id.toLong()
                var read = Read(0, id, Calendar.getInstance().timeInMillis)
                MainDB.getDatabase(this)!!.readDao().insert(read)
            }
            finish()

        }

    }


    fun updateMatn(){
        thread {
            var hekam = MainDB.getDatabase(this)!!.hekmatDao().all()

            runOnUiThread {
                tv_matn.text = hekam[shomareHekmat].matn
            }
        }
    }
}
