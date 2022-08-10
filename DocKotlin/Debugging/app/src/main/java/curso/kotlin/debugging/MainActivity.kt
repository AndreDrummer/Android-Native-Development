package curso.kotlin.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        division()
    }

    private fun division() {
        val numerator = 60
        var denominator = 4
        repeat(4) {
            Thread.sleep(3000)
            if((numerator / denominator) == 15)
//            findViewById<TextView>(R.id.division_textview).text = "kkk"
//            if((numerator / denominator) == 20) findViewById<TextView>(R.id.division_textview).text = "LLL"
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }

    fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
}