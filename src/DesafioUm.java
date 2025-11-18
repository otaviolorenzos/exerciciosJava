/* este projeto tem como objetivo usar IA para criar exercios onde posso praticar a linguagem JAVA
e Git. Os exercicios são criados pelo Google Gemini e indicarei aqui o conteúdo

<DesafioUm>

Sistema de Vendas e Inventário Simples
Crie um programa em Java para simular um mini-sistema de vendas que calcula o valor total
de uma compra, aplica descontos e trata o inventário.

Src:
SistemaDeVendas

Sugestões de melhoria do Gemini para Versão Final 1:

1. Robustez do Tratamento de Erros
O try-catch só está envolvendo a leitura de itemComprar. Se a exceção ocorrer dentro da leitura de unidades ou
resposta (no loop interno), ela não será tratada, ou o programa pode se comportar de forma inesperada.
Como Melhorar:
Refatore o bloco while (continuarComprando) para que ele use um loop interno de Validação de Entrada para cada sc.nextInt().

2. Padrões de Nomenclatura (Java Standard)
O padrão de convenção de nomes em Java (Convenção Code Conventions for the Java TM Programming Language) é crucial:
Classes: Devem ser em PascalCase (iniciadas com letra maiúscula).
Variáveis: Devem ser em camelCase (iniciadas com letra minúscula e próximas palavras com maiúscula).

3. Modularização (Preparação para o Desafio Nível 3)
O método main está fazendo muitas coisas: exibindo produtos, gerenciando o loop de compra, tratando exceções e aplicando o pagamento.
O princípio da boa programação é: "Um método deve fazer apenas uma coisa."
Como Melhorar:
Crie métodos estáticos para isolar as lógicas

<DesafioUm>

 */


