# desafioSoftPlan

## Exercício 1

### Problemas levantados

* Muitos comentários no código, devido á baixa clareza dos nomes usados, quanto para variáveis, quanto para métodos.

* Variáveis com algumas letras ou uma única letra, como exemplo da variável `s`.

* Variáveis com inicializações redundantes, como por exemplo a variável `s`.

* Código mau formatado, como exemplo dentro do método `retornaCodigos`, onde a 
cadeia de verificação com *if/else* aparenta estar aninhada, mas estão no mesmo nível.

* Condições redundantes no *if* do método `retornaCodigos`.

* O método `toString` da classe `StringBuilder` retorna uma string, a condição `cod.toString() == null` 
sempre será falso, se quisermos comparar os valores de StringBuilder, 
essa condição seria algo como `cod.toString().equals("")`, pois, iremos comparar valores de variáveis, 
não endereços de memória.

* Tipo genérico List nos parâmetros dos métodos.

* Uso de inteiros sem atribuição á nomes que deem significados, pode dificultar a compreensão do código.

* No método `geraObservacao`, não há necessidade de inicialização da variável `texto`.

* A variável `texto`, além de ser um nome bem genérico, pode ter atribuições para os casos da 
frase no plural ou singular, seria mais legível criar duas constantes, para o caso no plural e no singular. 

* Além dos métodos terem nomes que não significam realmente o que fazem, geraObservação 
possui mais de uma responsabilidade, pois, além de verificar se o parâmetro é vazio, modifica o 
resultado de `retornaCodigos`.

### Refatoração

* Modelamento do problema em duas classes; `GeradorObservacao` e `GeradorObservacaoComValor`, ambas implementam `FaturaNotaFiscal`, uma interface, 
que possui um método em comum; `geraObservacao`.

* Como devemos manter o comportamento da classe legada, pensei na interface e a extensão do comportamento
como outra implementação da interface, porém, a interface não possui um tipo específico, foi usado um tipo genérico, 
talvez seja uma má prática, mas fiz assim pensando na manutenção do comportamento anterior.

* Em `GeradorObservacaoComValor` utilizei a "interface" *Map* como parâmetro de `geraObservacao`, em que cada *Key:Value* é
um *Item:Valor*, pensei em utilizar *Map* para o método `geraObservacao` continuar com apenas um parâmetro, e  para haver 
correspondência de todas *Key:Value*.

## Exercício 2

### Dependências

Utilização do biblioteca JSON.simple 1.1, obtida neste [link](http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm).

### Observações 
* A composição 98561 possui valor informado do pdf de 28.73, porém, o resultado obtido no json fornecido foi 21.5

### Planejamento

* Criação de 2 classes para geração da tabela de composições; `CalculaComposicao` e `TabelaComposicoes`.

* `TabelaComposicoes` recebe um array de objetos json (composições), e utiliza a classe `CalculaComposicao` para gerar cada 
texto formatado de uma composição

* Utilização de uma "interface" `CalculadorComposicao` para reduzir o acoplamento de `TabelaComposicoes`, injetando o 
objeto de `CalculaComposicao` no método `geraTabelaDeComposicoes`

* `TabelaComposicoes` utiliza o método `separaItemsPorComposicao` que recebe o array de itens das composições e retorna 
um *Map* com cada *key:value* sendo *composição:itensDaComposição*, assim, `geraTabelaDeComposicoes` passa o value de cada 
key (uma lista dos itens de uma composição) para o método `calculaComposicao` da classe `CalculaComposicao`, concatenando 
cada composição e retornando o texto gerado.

 
