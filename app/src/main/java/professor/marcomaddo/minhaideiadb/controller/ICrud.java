package professor.marcomaddo.minhaideiadb.controller;

import java.util.List;

public interface ICrud<T> {

    // Métodos para persistência de dados no Banco de Dados

    // Incluir
    boolean  incluir(T obj);

    // Alterar
    boolean alterar(T obj);

    // Deletar
    boolean deletar(int id);

    // Listar
    List<T> listar();


    // CRUD - Create Retrieve Update Delete

}
