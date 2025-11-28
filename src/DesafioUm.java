/* este projeto tem como objetivo usar IA para criar exercios onde posso praticar a linguagem JAVA
e Git. Os exercicios são criados pelo Google Gemini e indicarei aqui o conteúdo

<DesafioUm>

Sistema de Vendas e Inventário Simples
Crie um programa em Java para simular um mini-sistema de vendas que calcula o valor total
de uma compra, aplica descontos e trata o inventário.

Src:
SistemaDeVendas

Sugestões de melhoria do Gemini para VersãoUm:

1. Robustez do Tratamento de Erros
O try-catch só está envolvendo a leitura de itemComprar. Se a exceção ocorrer dentro da leitura de unidades ou
resposta (no loop interno), ela não será tratada, ou o programa pode se comportar de forma inesperada.
Como Melhorar:
Refatore o bloco while (continuarComprando) para que ele use um loop interno de Validação de Entrada para cada sc.nextInt().

2. Padrões de Nomenclatura (Java Standard)
O padrão de convenção de nomes em Java (Convenção Code Conventions for the Java TM Programming Language) é crucial:
Classes: Devem ser em PascalCase (iniciadas com letra maiúscula).
Variáveis: Devem ser em camelCase (iniciadas com letra minúscula e próximas palavras com maiúscula).

3. Modularização (Preparação para o Desafio Nível 2)
O método main está fazendo muitas coisas: exibindo produtos, gerenciando o loop de compra, tratando exceções e aplicando o pagamento.
O princípio da boa programação é: "Um método deve fazer apenas uma coisa."
Como Melhorar:
Crie métodos estáticos para isolar as lógicas

<DesafioUm>

<DesafioDois>
Sugestões de melhoria do Gemini para VersãoDois:

Sugestões de Polimento (Refatoração de Elite)
1. Simplificação da Lógica do while no main
Você usa a variável numValido três vezes com lógicas de repetição aninhadas diferentes, o que pode ser confuso.

Problema na Compra: O loop para itemAComprar e unidades pode ser combinado em um único loop mais limpo.

Melhoria (Usando do-while): Use o do-while para cada validação. O do-while é ideal porque executa o código primeiro e só
repete se a condição for falsa (se a validação falhar).

2. Tratamento de Exceções Lógicas em Produtos
Na classe Produtos, seus métodos AnalisarSeExisteP, VerificarEstoque, etc., apenas usam System.out.println e retornam true/false.

Problema: Se você quiser que o programa pare de executar uma linha de código, você precisa de um controle de fluxo mais forte.

Melhoria (Retorno ao Padrão de Exceção): Use o padrão lançar exceção para erros lógicos críticos (como fizemos antes com RuntimeException):

<DesafioDois>

 */


