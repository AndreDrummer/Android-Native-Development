package professor.marcomaddo.appaulasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App_AulaSP";
    private static final String PREF_NOME = "App_aulaSP_pref";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Rodando...");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        Log.i(TAG, "onCreate: Pasta Shared Criada...");

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.97f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);

        dados.apply();

        // Mode debug
        Log.i(TAG, "onCreate: Dados para ser salvos...");
        Log.w(TAG, "onCreate: Produto "+nomeProduto);
        Log.w(TAG, "onCreate: Codigo "+codigoProduto);
        Log.w(TAG, "onCreate: Preco "+precoProduto);
        Log.w(TAG, "onCreate: Tem no estoque "+estoque);

//        dados.clear();
//        dados.apply();

//        dados.remove("estoque");
//        dados.apply();

        Log.i(TAG, "onCreate: Dados recuperados...");

        Log.d(TAG, "onCreate: Produto "+sharedPreferences.getString("nomeProduto", "fora de estoque"));
        Log.d(TAG, "onCreate: Codigo "+sharedPreferences.getInt("codigoPoduto", -1));
        Log.d(TAG, "onCreate: Preco "+sharedPreferences.getFloat("preco", -1.0f));
        Log.d(TAG, "onCreate: Tem no estoque "+sharedPreferences.getBoolean("estoque", false));



    }
}