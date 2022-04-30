package professor.marcomaddo.minhaideiadb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import professor.marcomaddo.minhaideiadb.R;
import professor.marcomaddo.minhaideiadb.api.AppUtil;
import professor.marcomaddo.minhaideiadb.controller.ClienteController;
import professor.marcomaddo.minhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente objCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "AppDataBase: App Minha Ideia DataBase");

        objCliente = new Cliente();
        objCliente.setEmail("***nuca@example.com");
        objCliente.setId(2);
        objCliente.setNome("***** Nuca");

        clienteController = new ClienteController(getApplicationContext());

        if(clienteController.alterar(objCliente)) {
            Toast.makeText(MainActivity.this, "Cliente "+ objCliente.getNome()+" atualizado com sucesso!", Toast.LENGTH_LONG).show();
            Log.d(AppUtil.TAG, "Cliente "+ objCliente.getNome()+" atualizado com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente "+ objCliente.getNome()+" não atualizado com sucesso!", Toast.LENGTH_LONG).show();
            Log.e(AppUtil.TAG, "Cliente "+ objCliente.getNome()+" não atualizado com sucesso!");
        }



    }
}