#Seguradora API - DESAFIO TÉCNICO

API REST para uma seguradora de veículos

CRUD de clientes:
- Dados: Nome Completo, CPF, Cidade e UF;
- Todos os dados são obrigatórios;
- CPF deve ser válido e deve ser único na base.

CRUD de apólices:
- Dados: Número da apólice, Início de vigência, Fim de vigência, Placa do veículo e Valor da apólice;
- Todos os dados são obrigatórios;
- O número da apólice deve ser gerado aleatoriamente e ser único.

Consultar uma apólice por número:
- Endpoint separado dos CRUDs;
- Informar se a apólice venceu ou não;
- Informar quantos dias para vencer, ou há quantos dias venceu; 
- Informar placa do veículo e valor da apólice.

## Installation

Para criar o ambiente de desenvolvimento rode os comandos na pasta do projeto

```bash
mvn clean package -DskipTests
```

Para criar a imagem com a API Rest e o banco mongodb (Imagem docker seguradoraapi_api_service)

```bash
docker-compose build
```

Comando para subir os containers pelo docker-compose

```bash
docker-compose up
```

## Usage

Acesse o [swagger](http://localhost:8080/swagger-ui.html) do projeto para visualizar os endpoints




