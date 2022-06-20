package curso.kotlin.appgeradorqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class MainActivity extends AppCompatActivity {
    
    EditText editQRCode;
    Button btnGerarQRCode;
    ImageView imageQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        initComponents();
        
        btnGerarQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editQRCode.getText().toString())) {
                    editQRCode.setError("*");
                    editQRCode.requestFocus();
                } else {
                    gerarQRCode(editQRCode.getText().toString());
                }
            }
        });
    }

    private void initComponents() {
        editQRCode = findViewById(R.id.editQRCode);
        btnGerarQRCode = findViewById(R.id.btnGerarQRCode);
        imageQRCode = findViewById(R.id.imgQRCode);
    }

    private void gerarQRCode(String conteudoDoQRCode) {
        // zxing-android-embedded
        QRCodeWriter qrCode = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCode.encode(conteudoDoQRCode, BarcodeFormat.QR_CODE, 196, 196);
            
            int tamanho = bitMatrix.getWidth();
            int altura = bitMatrix.getHeight();
            
            Bitmap bitmap = Bitmap.createBitmap(tamanho, altura, Bitmap.Config.RGB_565);

            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < altura; j++) {
                    bitmap.setPixel(i, j, bitMatrix.get(i,j) ? Color.BLACK : Color.WHITE);
                }
            }

            imageQRCode.setImageBitmap(bitmap);
            

        } catch(WriterException exception) {
            exception.printStackTrace();
        }
    }
}