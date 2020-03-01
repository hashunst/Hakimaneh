package ir.fater.hakimaneh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Dao
import ir.fater.hakimaneh.db.MainDB
import ir.fater.hakimaneh.db.entity.Hekmat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread {
            var hekmat1 = Hekmat(0, "قال الله تعالی")
            MainDB.getDatabase(this)?.hekmatDao()?.insert(hekmat1)
            var matnHekmat1 = MainDB.getDatabase(this)?.hekmatDao()?.all()?.get(0)?.matn
            runOnUiThread {
                tv.text = matnHekmat1
            }
        }

//        tv.text = "سلام دنیا!"
//        tv.text ="سلام چترود!"
    }
}
