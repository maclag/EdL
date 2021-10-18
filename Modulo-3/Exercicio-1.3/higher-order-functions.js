const account1 = {
    owner: "Larissa Queiroz",
    movements: [200, 450, -400, 3000, -650, -130, 70, 1300],
    interestRate: 1.2, // %
    pin: 1111,
};

const account2 = {
    owner: "Jessica Miranda",
    movements: [5000, 3400, -150, -790, -3210, -1000, 8500, -30],
    interestRate: 1.5,
    pin: 2222,
};
  
const account3 = {
    owner: "Pedro Silva",
    movements: [200, -200, 340, -300, -20, 50, 400, -460],
    interestRate: 0.7,
    pin: 3333,
};
  
const account4 = {
    owner: "Sarah Pereira",
    movements: [430, 1000, 700, 50, 90],
    interestRate: 1,
    pin: 4444,
};

const accounts = [account1, account2, account3, account4];


// *ADICIONA UMA NOVA PROPRIEDADE: username*

// A função getInicials utiliza as iniciais do nome e sobrenome em letra minúscula como inicial
// Exemplo: "Maria Gomes" => mg
const getInitials = (name) => {
    return name
      .split(" ")
      .map((eachName) => eachName[0].toLowerCase())
      .join("");
};

// Foi criada uma nova propriedade (username) para cada um dos objetos utilizando map
const accountsCompleted = accounts.map((account) => {
    const initials = getInitials(account.owner); // inicial para cada nome do dono da conta
  
    return {
      ...account, // pega todo o conteúdo já presente em cada um dos objetos (contas)
      username: initials, // adiciona a propriedade em cada um dos objetos
    };
});



// *ADICIONA UMA NOVA PROPRIEDADE: balance*
// Balance corresponde ao saldo final das movimentações de cada conta.
// - saques (valor negativo) e depósitos (valor positivo)

// Para printar os saldos, foi utilizada a função map para saber o array de movimentos de cada conta
// - movements resulta em um array de arrays
const movements = accountsCompleted.map((account, i) => account.movements);

// Assim, result seria responsável por conter o saldo final de cada conta
// - utiliza-se map para percorrer cada elemento do vetor movements 
// e reduce para somar cada array separadamente
// - result retorna um array em que cada posição contém o saldo das contas 1, 2, 3 e 4, respectivamente
const result = movements.map((movement) => {
    return movement.reduce((total, curr) => total + curr, 0);
});

// Por fim, é utilizada a função forEach para adicionar a propriedade em cada um dos 
// objetos no mesmo vetor accountsCompleted já que a mesma não cria um novo vetor.
// - a posição i de cada conta está associada a posição dos elementos do vetor result
accountsCompleted.forEach((account, i) => account.balance = result[i]);


console.log(accountsCompleted);