# Restaurante Delivery - Sistema de Cadastro de Clientes
Esta aplicação foi desenvolvida para gerenciar o cadastro de clientes em um restaurante delivery, oferecendo funcionalidades essenciais para o gerenciamento de pedidos e entregas. 
O sistema permite:

Criação, atualização, exclusão e listagem de clientes, com todos os dados necessários para personalizar o atendimento;
Gestão de pedidos, possibilitando a associação dos clientes às suas refeições e bebidas escolhidas;
Registro de entregas, rastreando cada pedido até o seu destino final.

## Tecnologias Usadas
- Java 17: Linguagem de programação.
- Spring Boot: Framework para desenvolvimento de aplicações Java.
- Spring Data JPA: Para gerenciamento da persistência de dados.
- H2 Database: Banco de dados em memória para desenvolvimento e testes.
- Maven: Ferramenta de build e gerenciamento de dependências.

## Instruções para Rodar a Aplicação
Para rodar a aplicação na sua máquina local, siga estes passos:

#### 1. Clonar o Projeto

Primeiro, clone o repositório do Git para sua máquina local:

``` https://github.com/Ariane-Pinheiro-dev/delivery.git ```
#### 2. Executar a Aplicação

## Como Acessar os Endpoints
A aplicação estará disponível em ```http://localhost:8080/delivery/api```. Aqui estão os endpoints principais:

## Gestão Cliente:

### 1. Cadastrar Cliente
- **Método**: `POST`
- **Endpoint**: `/v1/cliente`
- **Descrição**: Cria um novo cliente com suas informações associadas.
- **Request Body**:
   ```json
   {
     "nomeCompleto": "String",
     "endereco": "String",
     "celular": "String",
     "telefone": "String",
     "sexo": "String",
     "email": "String",
     "cpf": "String",
     "dataNascimento": "yyyy-mm-dd",
     "aceitaTermos": true
   }

### 2. Listar Todos os Clientes
- Método: ```GET```
- Endpoint: ```/v1/cliente```
- Descrição: Obtém uma lista de todos os clientes cadastrados.

### 3. Listar Informações de um Cliente  
- Método: ```GET```
- Endpoint: ```/v1/cliente/{idCliente}```
- Descrição: Obtém a lista de informações de um cliente específico.

### 4. Atualizar Dados Cadastrais de um Cliente
- **Método**: `PATCH`
- **Endpoint**: `/v1/cliente/{idCliente}`
- **Descrição**: Atualiza as informações de um cliente específico.
- **Request Body**:
   ```json
   {
     "nomeCompleto": "String",
     "endereco": "String",
     "celular": "String",
     "telefone": "String",
     "sexo": "String",
     "email": "String",
     "cpf": "String",
     "dataNascimento": "yyyy-mm-dd",
     "aceitaTermos": true
   }

### 5. Remover um Cliente
- Método: ```DELETE```
- Endpoint: ```/v1/cliente/{idCliente}```
- Descrição: Exclui um cliente específico.

## Gestão Pedido:

### 1. Criar Pedido
- **Método**: `POST`
- **Endpoint**: `/v1/pedidos/{idCliente}`
- **Descrição**: Cria um pedido para um cliente específico, identificado pelo `idCliente`.
- **Request Body**:
   ```json
   {
     "nomeRefeicao": "String",
     "nomeBebida": "String",
     "observacaoPedido": "String"
   }

### 2. Listar Todos os Pedidos
Método: ```GET```
Endpoint: ```/v1/pedidos/```
Descrição: Obtém todos os pedidos atuais do Restaurante independente do Cliente.

### 3. Buscar Pedidos de um Cliente
- Método: ```GET```
- Endpoint: ```/v1/pedidos/{idCliente}```
- Descrição: Obtém todos os pedidos feitos por um cliente específico.

### 4. Atualizar Pedido de um Cliente
- **Método**: `PATCH`
- **Endpoint**: `/v1/pedidos/pedido{idPedido}/cliente/{idCliente}`
- **Descrição**: Atualiza as informações de um pedido específico.
- **Request Body**:
   ```json
   {
     "nomeRefeicao": "String",
     "nomeBebida": "String",
     "observacaoPedido": "String"
   }

### 5. Remover um pedido
- Método: ```DELETE```
- Endpoint: ```/v1/pedidos/pedido{idPedido}/cliente/{idCliente}```
- Descrição: Exclui um pedido específico de um cliente específico

## Gestão Entrega:

### 1. Criar Entrega
- **Método**: `POST`
- **Endpoint**: `/v1/entregas/{idPedido}/entrega`
- **Descrição**: Registra uma entrega para um pedido específico, identificado pelo `idPedido`.
- **Request Body**:
   ```json
   {
     "idPedido": "UUID",
     "nomeCompleto": "String",
     "endereco": "String",
     "celular": "String",
     "nomeRefeicao": "String",
     "nomeBebida": "String",
     "valor": 0.00
   }

### 2. Listar Todas Entregas
- Método: ```GET```
- Endpoint: ```/v1/entregas```
- Descrição: Retorna a lista de todas as entregas.

### 3. Buscar Entrega de um Pedido
- Método: ```GET```
- Endpoint: ```/v1/entregas/pedido/{idPedido}```
- Descrição: Obtém informações da entrega de um pedido específico através do idPedido.

### 4. Atualizar Pedido de um Cliente
- **Método**: `PATCH`
- **Endpoint**: `/v1/entregas/{idPedido}/entrega/{idEntrega}`
- **Descrição**: Atualiza as informações de uma entrega específica.
- **Request Body**:
   ```json
   {
     "idEntrega": "UUID",
     "nomeCompleto": "String",
     "endereco": "String",
     "celular": "String",
     "nomeRefeicao": "String",
     "nomeBebida": "String",
     "valor": 0.00
   }

### 5. Remover uma entrega
- Método: ```DELETE```
- Endpoint: ```/v1/entregas/{idEntrega}/pedido/{idPedido}```
- Descrição: Exclui entrega específica de um pedido específico
