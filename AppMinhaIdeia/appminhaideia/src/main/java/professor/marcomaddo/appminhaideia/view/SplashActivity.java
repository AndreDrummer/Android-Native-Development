package professor.marcomaddo.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import professor.marcomaddo.appminhaideia.R;
import professor.marcomaddo.appminhaideia.controller.ClienteController;
import professor.marcomaddo.appminhaideia.core.AppUtil;
import professor.marcomaddo.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {
    int tempoDeEspera = 1000 * 2;

    Cliente objCliente;
    TextView versaoView;
    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "onCreate: Tela Splash carregada");

        versaoView = findViewById(R.id.txtVersion);
        versaoView.setText(AppUtil.versaoDoAplicativo());

        clienteController = new ClienteController();

        trocarTela();
    }

    private void trocarTela() {
        Log.d(AppUtil.TAG, "trocarTela: Mudando de tela");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                objCliente = new Cliente(
                        "André Felipe",
                        "teste@example.com",
                        "12345678931",
                        25,
                        true);

                Log.d(AppUtil.TAG, "trocarTela: Esperando um tempo");
                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getNome());
                bundle.putString("email", objCliente.getEmail());

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);

    }
}