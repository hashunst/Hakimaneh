package ir.fater.hakimaneh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.fater.hakimaneh.db.MainDB
import kotlinx.android.synthetic.main.activity_amar.*
import java.util.*
import kotlin.concurrent.thread

class AmarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amar)

        var now = Calendar.getInstance().timeInMillis

        var day = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        var week = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            set(Calendar.WEEK_OF_MONTH, 0)
        }.timeInMillis


        var month = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            set(Calendar.DAY_OF_MONTH, 0)
        }.timeInMillis



        var emroz = 0
        var inhafte = 0
        var inmah = 0

        thread {
            var reads = MainDB.getDatabase(this)!!.readDao().all()


            for(read in reads){
                if(read.date > day && read.date < now){
                    emroz++
                }
                if(read.date > week && read.date < now){
                    inhafte++
                }
                if(read.date > month && read.date < now){
                    inmah++
                }
            }

            runOnUiThread{
                tv_day.text = "امروز $emroz تا مطالعه"
                tv_week.text = "این هفته $inhafte تا مطالعه"
                tv_month.text = "این ماه $inmah تا مطالعه"
            }
        }

    }
}
