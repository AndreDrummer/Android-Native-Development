package primeiro.cliente.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TelaSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        navigateToFirstScreen();
    }

    private void navigateToFirstScreen() {
        int timeToWait = 1000 * 2;

        // Delay of timeToWait time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent firstScreenNavigationIntent = new Intent(TelaSplashActivity.this, MainActivity.class);
                startActivity(firstScreenNavigationIntent);
                finish();
            }
        }, timeToWait);
    }
}