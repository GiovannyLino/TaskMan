
# 📋 Task Manager API

## 📌 SOBRE O APLICATIVO

Task Manager é uma API RESTful desenvolvida para gerenciar projetos, usuários e tarefas de forma eficiente. O sistema permite o controle completo do ciclo de vida de tarefas, bem como o histórico de atividades de cada uma, facilitando a organização de times e o acompanhamento de produtividade.


## 🛠️ TECNOLOGIAS DA APLICAÇÃO

- **Java 17**
- **Spring Boot**
- **MongoDB (via MongoDB Atlas)**
- **Lombok**
- **Postman (para testes)**
- **Maven**

## 🧱 ESTRUTURA DA APLICAÇÃO

```
TaskMan/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/taskmanager/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── dto/
│   │   │   ├── config/
│   │   │   └── exception/
│   └── resources/
│       └── application.properties
│
└── TaskMan.postman_collection.json (coleção de testes em .json)
```

## 📡 ENDPOINTS DA API

### 🔹 Usuários

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST   | `/api/users`         | Cria um novo usuário |
| GET    | `/api/users`         | Lista todos os usuários |
| GET    | `/api/users/{id}`    | Retorna um usuário por ID |
| PUT    | `/api/users/{id}`    | Atualiza um usuário por ID |
| DELETE | `/api/users/{id}`    | Deleta um usuário por ID |

### 🔹 Projetos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST   | `/api/projects`         | Cria um novo projeto |
| GET    | `/api/projects`         | Lista todos os projetos |
| GET    | `/api/projects/{id}`    | Retorna um projeto por ID |
| PUT    | `/api/projects/{id}`    | Atualiza um projeto por ID |
| DELETE | `/api/projects/{id}`    | Deleta um projeto por ID |

### 🔹 Tarefas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST   | `/api/tasks`                   | Cria uma nova tarefa |
| GET    | `/api/tasks`                   | Lista todas as tarefas |
| GET    | `/api/tasks/{id}`              | Retorna uma tarefa por ID |
| PUT    | `/api/tasks/{id}`              | Atualiza uma tarefa por ID |
| DELETE | `/api/tasks/{id}`              | Deleta uma tarefa por ID |
| PATCH  | `/api/tasks/{id}/status`       | Atualiza o status da tarefa |

### 🔹 Histórico

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `/api/history/task/{id}`       | Retorna o histórico da tarefa |

## 📫 COMO SETAR O POSTMAN PARA TESTES

Uma pasta chamada `TaskMan.postman_collection` estará presente no repositório com todas as requisições prontas para uso.

### Passos:

1. Abra o [Postman](https://www.postman.com/downloads/).
2. Clique em **"Import"** no canto superior esquerdo.
3. Selecione a pasta `PostmanCollection` ou arraste os arquivos `.json`.
4. Configure a variável `{{base_url}}` para apontar para sua API local ou de produção, como:

```
http://localhost:8080
```

## 🧪 EXEMPLOS DE JSON

### Criar Usuário

```json
{
  "name": "João Silva",
  "email": "joao@example.com"
}
```

### Criar Projeto

```json
{
  "name": "Projeto Teste",
  "description": "Esse projeto visa testar as funcionalidades do aplicativo"
}
```

### Criar Tarefa

```json
{
  "title": "Testar os Endpoints",
  "description": "Verificar se todos os endpoints estão funcionando corretamente",
  "projectId": "6828094507f0046e53a10e98",
  "assignedUserId": [
    { "id": "66501e301c7b5d6e6c450003" },
    { "id": "66501e301c7b5d6e6c450004" }
  ],
  "status": "EM_ANDAMENTO"
}
```

## ⚙️ COMO CONFIGURAR O `application.properties`

```properties
spring.application.name=TaskManager

# Conexão com MongoDB Atlas
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster>.mongodb.net/<dbname>?retryWrites=true&w=majority
spring.data.mongodb.database=<nome-do-banco>

spring.jackson.serialization.write-dates-as-timestamps=false
spring.main.allow-bean-definition-overriding=true

server.port=8080
```

## 📋 REQUISITOS PARA RODAR O PROJETO

- Java 17 ou superior
- Maven 3.8+
- Conta no MongoDB Atlas
- IDE (IntelliJ, Eclipse ou VSCode)

## 🌐 COMO CONECTAR AO MONGO ATLAS

1. Crie uma conta em [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
2. Crie um novo cluster gratuito.
3. Crie um banco de dados e um usuário com permissões.
4. Libere o acesso ao seu IP.
5. Copie a URI de conexão e insira no `application.properties`.

## ▶️ COMO EXECUTAR O PROJETO

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/TaskManager.git

# Acesse a pasta do projeto
cd TaskManager

# Configure o application.properties

# Execute a aplicação
./mvnw spring-boot:run
```

A API estará disponível em:
```
http://localhost:8080
```

## 💻 COMO EXECUTAR O PROJETO PELA IDE

Você pode executar o projeto diretamente por uma IDE como IntelliJ IDEA, Eclipse ou VSCode.

### 🔹 IntelliJ IDEA

1. Abra o IntelliJ e clique em **"Open"**.
2. Selecione a pasta do projeto.
3. Aguarde o carregamento do Maven e dependências.
4. Vá até a classe principal com a anotação `@SpringBootApplication` (normalmente `TaskManagerApplication.java`).
5. Clique com o botão direito e selecione **"Run 'TaskManagerApplication'"**.

### 🔹 Eclipse

1. Vá em **File > Import > Existing Maven Projects**.
2. Selecione o diretório do projeto e clique em **Finish**.
3. Encontre a classe principal e execute com botão direito > **Run As > Java Application**.

### 🔹 VSCode

1. Instale as extensões Java e Spring Boot necessárias.
2. Abra a pasta do projeto.
3. Vá até a classe principal e clique em **Run** ou use o atalho `F5`.


