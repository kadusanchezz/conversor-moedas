Conversor de Moedas 💱

Projeto desenvolvido em Java utilizando integração com API de taxas de câmbio, permitindo converter valores entre diversas moedas de forma simples e intuitiva.

📘 Sobre o Projeto

Este conversor permite que o usuário selecione uma moeda no menu, informe um valor e receba automaticamente a conversão para as outras moedas suportadas.
O programa também possui um loop de execução, permitindo várias conversões até que o usuário escolha a opção SAIR.

🛠 Tecnologias Utilizadas

Java 17+

IntelliJ IDEA

API de Cotações

Gson (para leitura de JSON)

Properties (para configuração com arquivo config.properties)

📂 Estrutura do Projeto
conversor-moedas/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── ApiClient.java
│       │   ├── ConfigReader.java
│       │   ├── ConversorMoedas.java
│       │   └── ExchangeResponse.java
│       └── resources/
│           └── config.properties
│
├── pom.xml
└── README.md

🚀 Funcionalidades

Conversão entre várias moedas em tempo real.

Menu interativo para escolha da moeda.

Loop contínuo até o usuário decidir encerrar.

Tratamento de erros (API, entrada inválida, valores incorretos).

Organização limpa do código seguindo boas práticas.

📌 Moedas Suportadas

USD – Dólar Americano

EUR – Euro

GBP – Libra Esterlina

JPY – Iene Japonês

BRL – Real Brasileiro

ARS – Peso Argentino

COP – Peso Colombiano

▶️ Como Executar o Projeto

Baixe ou clone o repositório:

git clone https://github.com/kadusanchezz/conversor-moedas.git


Abra o projeto no IntelliJ IDEA.

Certifique-se de que o Maven baixou todas as dependências.

Execute a classe:

ConversorMoedas.java


Escolha a moeda no menu, informe o valor e aproveite a conversão!

🧩 Configuração da API

A chave da API fica no arquivo:

src/main/resources/config.properties


Formato:

api.key=eb4f9a5004084a0947f35bb1

🤝 Contribuições

Contribuições são bem-vindas!
Sinta-se à vontade para abrir issues ou enviar pull requests.