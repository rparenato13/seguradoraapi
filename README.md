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

Rode os comandos na pasta do projeto

Para criar a imagem com a API e o banco mongodb
```bash
docker-compose build
```

Comando para subir os containers pelo docker-compose
```bash
docker-compose up
```

Comando para subir os containers 
```bash
docker start seguradora_srv
docker start seguradora_mdb
```

## Usage

Acesse o [swagger](http://localhost:8080/swagger-ui.html) do projeto para visualizar os endpoints




