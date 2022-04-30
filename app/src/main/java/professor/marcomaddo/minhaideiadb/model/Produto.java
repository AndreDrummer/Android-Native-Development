package professor.marcomaddo.minhaideiadb.model;

import android.util.Log;

import professor.marcomaddo.minhaideiadb.api.AppUtil;
import professor.marcomaddo.minhaideiadb.controller.ICrud;

public class Produto  {
    private int id;
    private String nome;
    private String fornecedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
