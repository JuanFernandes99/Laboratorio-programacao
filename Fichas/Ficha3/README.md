# Laboratorio_de_programacao

Resumo ficha 3

**Ex. 1:Crie a classe ContaBancária com os seguintes atributos e métodos:**
<pre>
   1º Criar uma Classe ContaBancária que tem como atributos privados: String Titular, double Saldo e Date DataAbertura(data atual);
   2º Construtor que tem o Titular como um atributo obrigatório; Apresenta da data do dia atua e inicia o saldo a 0(zero);
   3º Criar um método getInformaçãoConta() que retorna da seguinte forma (Titular: José Fonseca, Saldo: €321.50, Data Abertura: 22/2/2022;
   4º Criar um método depositar() que recebe o valor a depositar e atualiza o saldo (relembrar que inicializou a zero);
   5º Criar um método levantar() que permite levantar dinheiro da conta, atualiza a conta e não permite o levantamento que coloquem o saldo negativo;
   
       Na main: criar contas, efetuar depósitos e levantamentos, imprimir a informação que atualiza o saldo.
   
 **Ex. 2:Codifique a classe Banco com os seguintes atributos e métodos:**
 
   1º Criar uma Classe Banco que tem como atributos: String nome e uma lista de contas do tipo ContaBancaria;
   2º Construtor que tem o nome como atributo obrigatório e limita a lista de contas para 100 contas;
   3º Criar um método criaConta() que recebe uma conta e acrescenta à lista;
   4º Criar um método getConta() que recebe o titular e devolve a conta do mesmo;
   
    Na main: criar contas, efetuar depósitos e levantamentos, imprimir a informação que atualiza o saldo.
   
   
   
**Ex. 3: Crie uma classe Casa, a qual deverá ter os seguintes atributos e métodos:**
 
   1º Criar uma Classe Casa que tem como atributos privados: String morada, double precoCusto, double precoVenda;
   2º Construtor sem argumentos;
   3º Construtor com a morada obrigatória;
   4º Criar um método getMargemLucro() que retorna a margem de lucro da casa;
   5º Criar um método getPercentMargemLucro() que retorna a percentagem da margem de lucro;
   
   
    Na main: criar casas com diferentes valores dos atributos;
   
  **Ex. 4:**
 
   1º Na classe Banco adicionar uma lista de casas;
   2º Criar um método para adicionar casas;
   3º Criar um método que recebe a morada e remova essa casa da lista;
   4º Criar um método getLucroPrevisto que retorna a margem de lucro previsto da venda de todas as casas;
 
    Na main: apresentar a lista de casas e depois remover uma casa e apresentar a lista novamente;
   
   **Ex. 5:**
 
   1º Criar o diagrama de classes UML;
   2º Adicionar uma descrição do projeto no ficheiro README;
   3º Adicionar o diagrama de classes UML ao ficheiro README;
</pre>
![DiagramadeClasses_Juan](https://user-images.githubusercontent.com/97111394/155163310-0a96e7a7-d3a0-4854-92e0-e5be500265d5.png)
