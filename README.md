# PetFriends

Implementação de CQRS e Event Sourcing utilizando Axon Framework no domínio de Pedidos.

## Como Executar

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## Endpoints da API

### Commands (Escrita)

**Criar Pedido**

```
POST /api/pedidos/commands
Content-Type: application/json

{
  "clienteId": 1,
  "valorTotal": 150.00
}
```

### Queries (Leitura)

**Listar Todos os Pedidos**

```
GET /api/pedidos/queries
```

**Buscar Pedido por ID**

```
GET /api/pedidos/queries/{id}
```

### Documentação

- **Swagger UI**: http://localhost:8080/swagger-ui
- **OpenAPI JSON**: http://localhost:8080/api-docs
- **Console H2**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:petfriendsdb`
  - Username: `sa`
  - Password: (vazio)

## Arquitetura

O projeto implementa o padrão CQRS com Event Sourcing:

- **Commands**: Operações de escrita processadas pelo PedidoAggregate
- **Events**: Eventos persistidos no Event Store do Axon
- **Queries**: Consultas sobre projeções materializadas no banco relacional
