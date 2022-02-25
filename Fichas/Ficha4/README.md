# Laboratorio_de_programacao

## Resumo Ficha de exercícios 4

### Ex. 1:
Crie um novo projeto. Numa loja, toda a fruta vendida tem um nome e um preço base. Porém, a loja vende fruta em três modalidades: à unidade, ao peso ou pelo volume. Crie uma hierarquia onde Fruta é uma classe abstrata, com as subclasses FrutaUnidade, FrutaPeso, e FrutaVolume.

  **1-)** Criar uma classe abstrata deverá ter as variáveis comuns a todas as subclasses, bem como o método abstrato double pagar().                                                                 
  **2-)** Defina as classes FrutaUnidade, FrutaPeso, e FrutaVolume, como subclasses de Fruta, dando a adequada implementação ao método double pagar() para cada caso.
   
       Na main: testar as classes acima descritas.

### Ex. 2:
Defina a classe Cesto, que representa um conjunto de frutas adquiridas. Esta classe deverá implementar o seguinte:
 
   **1-)** Uma variável de instância para o total de items no cesto e uma constante que determina a capacidade máxima do cesto como sendo 100.                                   
   **2-)** Inclua também um array de Fruta para representar o cesto, que é um conjunto de frutas.                                       
   **3-)** Um método que insere no cesto diferentes tipos de fruta.                                       
   **4-)** Um método que calcula o valor total da fruta no cesto.                                       
   **5-)** Um método que determina o número de frutos de um dado tipo existentes no cesto.                                       
   **6-)** Um método que determina o valor total gasto em frutos de um dado tipo.                                       
   
    Na main: crie um cesto e insira vários tipos de fruta. Teste todos os métodos.                                       
   
### Ex. 3: 
Toda a fruta a peso e toda a fruta a volume podem ter um desconto de uma determinada percentagem.                                       
 
   **1-)** Crie uma interface Descontavel que tem um método double descontar() que será implementado pela classe FrutaPeso e pela class FrutaVolume.                            
   **2-)** Faça as alterações necessárias nestas classes, entre as quais a adição de um método setPercentagemDesconto(double percentagem).                                  
   
    Na main: testar as respetivas alterações.


DiagramadeClasses: 

![DiagramadeClasses_Juan](https://user-images.githubusercontent.com/97111394/155163310-0a96e7a7-d3a0-4854-92e0-e5be500265d5.png)
