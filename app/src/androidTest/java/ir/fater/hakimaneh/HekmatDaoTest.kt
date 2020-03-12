package ir.fater.hakimaneh

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import ir.fater.hakimaneh.db.MainDB
import ir.fater.hakimaneh.db.dao.HekmatDao
import ir.fater.hakimaneh.db.entity.Hekmat
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class HekmatDaoTest {

    private lateinit var hDao: HekmatDao
    private lateinit var db: MainDB

    @Before
    fun createDB(){
        val context = InstrumentationRegistry.getInstrumentation().context

        db = Room.inMemoryDatabaseBuilder(context, MainDB::class.java)
            .allowMainThreadQueries()
            .build()
        hDao = db.hekmatDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDB(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetHekmat() {
        val hekmat = Hekmat(0, "ya ali")
        hDao.insert(hekmat)
        val myHekmat = hDao.all().first()
        assertEquals(hekmat.matn, myHekmat.matn)
    }

    @Test
    @Throws(Exception::class)
    fun getSizeEntity() {
        val size = hDao.all().size
        Log.d("test", "size is $size")
        assertEquals(size, 0)
    }
    @Test
    @Throws(Exception::class)
    fun getAllLive() {

        val p = MutableLiveData<Int>()
        p.postValue(22)
        assertEquals(p.value, null)
    }

}