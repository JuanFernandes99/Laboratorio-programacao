# Laboratorio_de_programacao

## Resumo Ficha de exercícios extra 1

### Ex. 1:
Considere  que  se  pretende  desenvolver  uma  aplicação  para  registo  de  navios  num porto marítimo.   Um   navio   é   genericamente   caracterizado   pela   seguinte   informação: Identificadordo Navio (String), nome (String), ano de construção (Date)e comprimento (float). Um  navio porta-contentoresé  um  navio  com  atributo  adicional,  onúmeromáximo  de contentores (int). Um navio petroleiro é um navio com atributo adicional capacidade de carga (float),  em  toneladas.  Codifique  as  classes  Navio,  PortaContentores  e  Petroleiro,  que representam  respetivamente  um  navio  qualquer,  um  navio porta-contentorese  um  navio petroleiro, incluindo construtores, métodos de acesso (getters) e mutação (setters).

### Ex. 2: 

Implemente  uma  classe  Porto  (apenas  os  atributos  e  construtor)  para  armazenar  a informação  sobre  a  atracagem  de  navios  (use  o  tipo  de  coleção  que  considerar  mais apropriado).  A  classe  deve  incluir  métodos  para  (nota:  pode  adicionar  métodos  às  classes anteriores se necessário):
 
   **1-)** Adicionar um novo navio sem permitir a duplicação da Identificador do Navio.                                   
   **2-)** Devolver a quantidade máxima total de contentores de todos os navios porta-contentoresatracados no porto.
   **3-)** Devolver a capacidade total de carga de todos os navios porta-contentorese petroleiros atracados no porto, sabendo que um contentor tem capacidade para 10 toneladas;

### Ex. 3: 

Escreva as instruções necessárias, no método main(...), para criar um Porto com um navio petroleiro e um navio porta contentores (utilize qualquer valor para os parâmetros com um tipo de dados válido). Utilize o método para adicionarum novo navio. Valide que não é possível repetir a matrícula de navio, num mesmo porto.
