//class Pessoa { } // Usando o construtor padrão
//class Pessoa constructor(nomeCompleto: String, idate: Int) // Usando somente a classe sem corpo

// Conforme visto na aula
class Pessoa constructor(nomeCompleto: String, idade: Int) {
    constructor(salario: Double)
}

// Solução encontrada na documentação

// Passando valores padrão
class Pessoa constructor(nomeCompleto: String, idade: Int) {
    constructor(salario: Double) : this("João da Silva", 38)
}

// Repassando os valores recebidos
class Pessoa constructor(nomeCompleto: String, idade: Int) {
    constructor(nomeCompleto: String, idade: Int, salario: Double) : this(nomeCompleto, idade)
}


// Repassando os valores recebidos
class Pessoa constructor(nomeCompleto: String, idade: Int) {
    constructor(nomeCompleto: String, idade: Int, salario: Double) : this(nomeCompleto, idade)
}
