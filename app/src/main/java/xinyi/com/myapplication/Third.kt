package xinyi.com.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by jiajun.wang on 2018/3/29.
 */

class Third : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this@Third, SecondActivity::class.java)
    }
}
