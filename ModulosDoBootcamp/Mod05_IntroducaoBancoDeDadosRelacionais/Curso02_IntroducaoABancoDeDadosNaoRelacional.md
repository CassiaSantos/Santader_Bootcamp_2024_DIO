### Introdução ao Bancos de Dados NoSQL

Os bancos de dados NoSQL (Not Only SQL) surgiram para atender às necessidades de aplicações que exigem alta escalabilidade, flexibilidade e desempenho, características que nem sempre são bem atendidas pelos bancos de dados relacionais tradicionais. Enquanto os bancos de dados relacionais estruturam os dados em tabelas com linhas e colunas, utilizando SQL (Structured Query Language) para manipulação, os bancos de dados NoSQL oferecem uma variedade de modelos de dados e utilizam diferentes linguagens de consulta.

### Tipos de Banco NoSQL

Os bancos de dados NoSQL podem ser categorizados em quatro principais tipos, cada um adequado para diferentes tipos de aplicações e casos de uso:

1. **Coluna/Família de Colunas (Column-Family)**
2. **Chave-Valor (Key-Value)**
3. **Documento (Document)**
4. **Grafos (Graph)**

#### Coluna/Família de Colunas

Os bancos de dados de família de colunas armazenam dados em tabelas que consistem em linhas e colunas, mas diferentemente dos bancos relacionais, cada linha não precisa ter o mesmo conjunto de colunas. Eles são otimizados para operações de leitura e escrita em larga escala. Exemplos incluem Apache Cassandra e HBase. 

**Exemplo de uso:** Aplicações que requerem grandes volumes de dados, como sistemas de recomendação ou análises de logs.

#### Chave-Valor

Os bancos de dados chave-valor são os mais simples entre os NoSQL. Eles armazenam dados como um par de chave-valor, onde a chave é única e utilizada para recuperar o valor. São altamente escaláveis e rápidos para operações de leitura e escrita.

**Exemplo de uso:** Caches, sessões de usuário, e dados de configuração. Redis e Amazon DynamoDB são exemplos populares.

#### Documento

Os bancos de dados de documento armazenam dados em documentos, geralmente no formato JSON (JavaScript Object Notation), BSON (Binary JSON) ou XML. Cada documento contém um conjunto de pares chave-valor, e a estrutura de dados pode variar de um documento para outro dentro da mesma coleção. 

**Exemplo de uso:** Aplicações web e móveis, catálogos de produtos. MongoDB é um dos mais conhecidos nesse segmento.

### Introdução ao MongoDB

MongoDB é um banco de dados NoSQL de código aberto, orientado a documentos. Ele armazena dados em documentos BSON, uma extensão binária do JSON, que oferece maior flexibilidade e desempenho. MongoDB é popular devido à sua facilidade de uso, escalabilidade horizontal e suporte a operações complexas de agregação.
Alguns comandos básicos são:
* Criar ou utilizar base de dados: use <nomeBaseDados>;
* Criar uma collection com declaração explícita: bd.createCollection(<nomeCollection>, <JSON com informações de configurações>);
* mostrar collections: show collections;
* povoar collection: db.<nomeCollection>.insertOne({atributo1: valor, atributo2: valor});
* listar todos os documentos da collection: db.<nomeCollection>.find({});
* Comando insertOne(): insere documento dentro de uma collection e retorna o ObjectId dele;

#### Estrutura do MongoDB

- **Database:** É o contêiner de collections, semelhante a um banco de dados em um sistema relacional.
- **Collection:** É um grupo de documentos, similar a uma tabela em um banco de dados relacional.
- **Document:** É um registro dentro de uma collection, armazenado em formato BSON.

#### Instalação do MongoDB

Para instalar o MongoDB em um sistema baseado em Linux (por exemplo, Ubuntu), você pode seguir estes passos:

1. Importar a chave pública utilizada pelo sistema de gerenciamento de pacotes.
2. Criar uma lista de arquivos para o MongoDB.
3. Atualizar o banco de dados do repositório.
4. Instalar o MongoDB.

```sh
# Importar a chave pública
wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc | sudo apt-key add -

# Criar a lista de arquivos
echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/4.4 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.4.list

# Atualizar o banco de dados do repositório
sudo apt-get update

# Instalar o MongoDB
sudo apt-get install -y mongodb-org
```

#### MongoDB Cloud

MongoDB Atlas é a solução de banco de dados como serviço (DBaaS) oferecida pela MongoDB. Ele permite que você crie, gerencie e escale clusters MongoDB na nuvem com facilidade, fornecendo ferramentas integradas para monitoramento e backups.

#### Operações de Manipulação de Dados no MongoDB

As operações básicas de manipulação de dados no MongoDB incluem:

- **Inserção (Insert):** Adiciona novos documentos à collection.
  ```js
  db.collection.insertOne({name: "Alice", age: 25});
  db.collection.insertMany([{name: "Bob", age: 30}, {name: "Charlie", age: 35}]);
  ```

- **Consulta (Query):** Recupera documentos de uma collection.
  ```js
  db.collection.find({age: {$gt: 30}});
  db.collection.findOne({name: "Alice"});
  ```

- **Atualização (Update):** Modifica documentos existentes.
  ```js
  db.collection.updateOne({name: "Alice"}, {$set: {age: 26}});
  db.collection.updateMany({age: {$lt: 30}}, {$inc: {age: 1}});
  ```

- **Remoção (Delete):** Remove documentos de uma collection.
  ```js
  db.collection.deleteOne({name: "Alice"});
  db.collection.deleteMany({age: {$gt: 30}});
  ```

#### Performance e Índices no MongoDB

MongoDB utiliza índices para melhorar a eficiência das operações de consulta. Sem índices, o MongoDB precisa realizar uma varredura completa da coleção para encontrar os documentos que correspondem à consulta.

- **Criação de Índices:**
  ```js
  db.collection.createIndex({name: 1}); // Índice ascendente
  db.collection.createIndex({age: -1}); // Índice descendente
  ```

- **Verificação de Índices:**
  ```js
  db.collection.getIndexes();
  ```

- **Remoção de Índices:**
  ```js
  db.collection.dropIndex("name_1");
  ```

#### Agregações no MongoDB

O framework de agregação do MongoDB permite a realização de operações complexas de processamento de dados e transformações diretamente no servidor de banco de dados. As operações de agregação são construídas em torno de um "pipeline" que passa os documentos através de várias etapas.

- **Exemplo de Pipeline de Agregação:**
  ```js
  db.collection.aggregate([
    { $match: { status: "A" } },
    { $group: { _id: "$cust_id", total: { $sum: "$amount" } } },
    { $sort: { total: -1 } }
  ]);
  ```

Este exemplo realiza uma filtragem (`$match`), agrupa os documentos (`$group`) e ordena o resultado (`$sort`).

### Conclusão

Os bancos de dados NoSQL, com sua diversidade de modelos de dados e alta escalabilidade, são fundamentais para aplicações modernas que lidam com grandes volumes de dados e requerem flexibilidade na estruturação desses dados. MongoDB, como um banco de dados de documentos, destaca-se por sua simplicidade e robustez, tornando-se uma escolha popular entre desenvolvedores e arquitetos de sistemas.