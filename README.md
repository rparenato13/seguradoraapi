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

### Para criar o ambiente de desenvolvimento

Rode os comandos na pasta do projeto

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

### Para criar subir o ambiente baixando do docker hub

Passo1: Baixar a imagem da SeguradoraAPI do docker hub

```bash
docker pull renatopalmeida/seguradoraapi_api_service:tag
```

Passo2: Baixar a imagem do MongoDB

```bash
docker pull mongo:4.4.3
```

Passo3: Rodar a imagem do MongoDB mapeando a porta 27017 e indicando o nome mongo_db

```bash
docker run  -p 27017:27017 --name mongo_db  mongo:4.4.3 
```

Passo5: Rodar a imagem da SeguradoraAPI criando o link para o mongo_db

```bash
docker run -e SPRING_DATA_MONGODB_URI='mongodb://mongo_db:27017/seguradora' -p 8080:8080 --link mongo_db:mongo_db renatopalmeida/seguradoraapi_api_service:1.0.0
```

## Usage

Acesse o [swagger](http://localhost:8080/swagger-ui.html) do projeto para visualizar os endpoints




