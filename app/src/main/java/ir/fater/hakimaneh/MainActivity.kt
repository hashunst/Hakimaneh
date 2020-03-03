package ir.fater.hakimaneh


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_motale_hekmat.setOnClickListener {
            startActivity(Intent(this@MainActivity, HekmatActivity::class.java))
        }

        btn_amar.setOnClickListener {
            startActivity(Intent(this@MainActivity, AmarActivity::class.java))
        }
    }
}
