package professor.marcomaddo.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import professor.marcomaddo.appminhaideia.R;

public class MainActivity extends AppCompatActivity {

    String TAG = "APP_MINHA_IDEA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Tela Principal carregada");
    }
}