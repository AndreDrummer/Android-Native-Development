package professor.marcomaddo.minhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import professor.marcomaddo.minhaideiadb.api.AppUtil;
import professor.marcomaddo.minhaideiadb.datamodel.ClienteDataModel;
import professor.marcomaddo.minhaideiadb.datasource.AppDataBase;
import professor.marcomaddo.minhaideiadb.model.Cliente;

public class ClienteController extends AppDataBase implements  ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);
        Log.d(AppUtil.TAG, "AppDataBase: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        // Enviar os dados do Objeto para class AppDataBase
        // Usando um metodo capaz de adicionar um OBJ no banco.
        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {

        return deleteById(ClienteDataModel.TABELA, id);
    }


    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        return update(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        return lista;
    }
}
