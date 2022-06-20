package professor.marcomaddo.minhaideiadb.datamodel;

public class ClienteDataModel {
    // Modelo Objeto Relacional - MOR

    // Toda Classe Data Model tem esta estrutura
    // 5- Queries para consultas gerais

    // 1- Atributo nome da tabela
    public static final String TABELA = "cliente";

    // 2- Atributos, um para um com os nome sdos campos
    public static final String ID = "id"; // integer
    public static final String NOME = "nome"; // text
    public static final String EMAIL = "email"; // text

    // 3- Queries para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // 4- Método para gerar o Script para criar a tabela;
    public static String criarTabela() {

        queryCriarTabela+="CREATE TABLE "+TABELA+" (";
        queryCriarTabela+= ID+" integer primary key autoincrement, ";
        queryCriarTabela+= NOME+" text, ";
        queryCriarTabela+= EMAIL+" text";
        queryCriarTabela+=")";

        return queryCriarTabela;
    }
}
