package curso.kotlin.appgeradorqrcode

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.graphics.get
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

class MainActivity : AppCompatActivity() {

    var editQRCode: EditText? = null
    var btnGerarQRCode: Button? = null
    var imgQRCode: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents();

        btnGerarQRCode!!.setOnClickListener {
            if(TextUtils.isEmpty(editQRCode!!.text.toString())) {
                editQRCode!!.error = "*"
                editQRCode!!.requestFocus()
            } else {
                gerarQRCode(editQRCode!!.text.toString())
            }
        }
    }

    fun gerarQRCode(conteudoQRCode: String) {
        // zxing-android-embedded

        val qrCode = QRCodeWriter()

        try {
            val bitMatrix = qrCode.encode(conteudoQRCode, BarcodeFormat.QR_CODE, 196, 196);

            val tamanho = bitMatrix.width
            val altura = bitMatrix.height

            val bitmap = Bitmap.createBitmap(tamanho, altura, Bitmap.Config.RGB_565)

            for (i in 0 until tamanho) {
                for (j in 0 until altura) {
                    bitmap.setPixel(i,j, if(bitMatrix.get(i,j)) Color.BLACK else Color.WHITE)
                }
            }

            imgQRCode!!.setImageBitmap(bitmap)

        } catch (exception: WriterException) {
            exception.printStackTrace()
        }
    }

    fun initComponents() {
        editQRCode = findViewById(R.id.editQRCode)
        btnGerarQRCode = findViewById(R.id.btnGerarQRCode)
        imgQRCode = findViewById(R.id.imgQRCode)
    }
}