package professor.marcomaddo.minhaideiadb.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import professor.marcomaddo.minhaideiadb.api.AppUtil;
import professor.marcomaddo.minhaideiadb.datamodel.ClienteDataModel;
import professor.marcomaddo.minhaideiadb.datamodel.ProdutoDataModel;
import professor.marcomaddo.minhaideiadb.model.Cliente;
import professor.marcomaddo.minhaideiadb.model.Produto;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "AppMinhaIdeia.sqlite";
    private static final int DB_VERSION = 1;
    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando banco de dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        db.execSQL(ProdutoDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente Criada "+ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
    * Método para inserir dados no banco de dados.
    * @return
    * */
    protected boolean insert(String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch(Exception exception) {
            Log.d(AppUtil.TAG, "insert: "+ exception.getMessage());
        }

        return retorno;
    }

    /**
     * Método para deletar um registro no banco de dados.
     * @return
     * **/

    protected  boolean deleteById(String tabela, int id) {
        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.delete(tabela, "id = ?",new String[] {String.valueOf(id)}) > 0;
        } catch (Exception e) {
            Log.i(AppUtil.TAG, "deleteById: "+e.getMessage());
        }

        return retorno;
    }

    protected boolean update(String tabela, ContentValues dados) {
        db = getWritableDatabase();

        boolean retorno = false;


        try {
            retorno = db.update(tabela, dados, "id = ?", new String[] {String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {
            Log.e(AppUtil.TAG, "alterTable: "+e.getMessage());
        }

        return retorno;
    }

    protected List<Cliente> getAllClientes(String tabela) {
        db = getReadableDatabase();
        List<Cliente> clientes = new ArrayList<>();

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM "+tabela, null);

            if(cursor.moveToFirst()) {
                do {
                    Cliente newCliente = new Cliente();

                    @SuppressLint("Range")
                    int clienteId = cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID));

                    @SuppressLint("Range")
                    String clienteNome = cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME));

                    @SuppressLint("Range")
                    String clienteEmail = cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL));


                    newCliente.setId(clienteId);
                    newCliente.setNome(clienteNome);
                    newCliente.setEmail(clienteEmail);

                    clientes.add(newCliente);

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(AppUtil.TAG, "getAllClientes: "+e.getMessage());
        }

        return clientes;
    }

    protected List<Produto> getAllProdutos(String tabela) {
        db = getReadableDatabase();

        List<Produto> produtos = new ArrayList<>();

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM "+tabela, null);

            if(cursor.moveToFirst()) {
                do {
                    Produto newProduto = new Produto();

                    @SuppressLint("Range")
                    int produtoId = cursor.getInt(cursor.getColumnIndex(ProdutoDataModel.ID));

                    @SuppressLint("Range")
                    String produtoNome = cursor.getString(cursor.getColumnIndex(ProdutoDataModel.NOME));

                    @SuppressLint("Range")
                    String produtoFornecedor = cursor.getString(cursor.getColumnIndex(ProdutoDataModel.FORNECEDOR));

                    newProduto.setId(produtoId);
                    newProduto.setNome(produtoNome);
                    newProduto.setFornecedor(produtoFornecedor);

                    produtos.add(newProduto);

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(AppUtil.TAG, "getAllProdutos: "+e.getMessage());
        }


        return produtos;
    }






}
