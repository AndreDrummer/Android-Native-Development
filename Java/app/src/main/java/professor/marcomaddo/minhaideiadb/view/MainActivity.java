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
import professor.marcomaddo.minhaideiadb.controller.ProdutoController;
import professor.marcomaddo.minhaideiadb.model.Cliente;
import professor.marcomaddo.minhaideiadb.model.Produto;

public class MainActivity extends AppCompatActivity {

    ProdutoController produtoController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "AppDataBase: App Minha Ideia DataBase");

        produtoController = new ProdutoController(getApplicationContext());

        List<Produto> produtos = produtoController.listar();

        for (int i = 0; i < produtos.size(); i++) {
            Produto objProduto = produtos.get(i);

            Log.i("Listar", objProduto.getNome());

            produtoController.incluir(objProduto);
        }
    }
}