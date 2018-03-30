package xinyi.com.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var mDecorView: View

    lateinit var f: FloatingActionButton
    private var mX:Float = 0.0f
    private var mY:Float = 0.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        f=findViewById<FloatingActionButton>(R.id.fab);
        f.setOnClickListener {
             var i=Intent(this@MainActivity,SecondActivity::class.java);
             startActivity(i)
        }

    }

}
