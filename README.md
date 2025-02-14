

# Projeto de Aluguel de Livros

Este projeto tem como objetivo o gerenciamento de um sistema de aluguel de livros e dar inicio ao meu aprendizado no Sprig Boot.


## Tecnologias

* Java: Linguagem principal do projeto.
* Spring Boot: Framework para o desenvolvimento da aplicação.
* Bruno: Software utilizado para testar as requisições HTTP e garantir o correto funcionamento da API durante o desenvolvimento.
* Jpa e H2 Database

## Documentação da API

### Retorna todos os Livros, Clientes ou Alugueis

```http
  GET /livros
  GET /clientes
  GET /alugueis
```

### Cadastrar um Livro
```http
  POST /livros
```
| Body   | Tipo       | Descrição                                
| :---------- | :--------- | :------------------------------------------ |
| `titulo`      | `string` |**Obrigatório**.  Titulo do livro|
| `autor`      | `string` |**Obrigatório**.  Autor do Livro|
| `anoFabricacao`      | `string` |**Obrigatório**.  Ano de Fabricação|
| `categoria`     | `string` |**Obrigatório**.  Categoria do Livro|
| `disponibilidade`      | `string` |**Obrigatório**.  Disponibilidade do Livro


### Cadastrar um Cliente
```http
  POST /Cliente
```
| Body   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` |**Obrigatório**.  Nome do Cliente|
| `cpf`      | `string` |**Obrigatório**.  CPF do Cliente|


### Retorna um Livro, Cliente ou Aluguel pelo id

```http
  GET /livros/${id}
  GET /clientes/${id}
  GET /alugueis/${clienteId}
```
#### Obs: O Aluguel vai retornar alugueis de um cliente do ID que foi passado no parâmetro

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você deseja visualizar |

### Retorna um Livro pela categoria ou autor

```http
  GET /livros?categoria=Romance
  GET /livros?autor=José%20Almeida
```

### Atualizar um Livro

```http
  PUT /livros/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você deseja atualizar |

| Body   | Tipo       | Descrição                                
| :---------- | :--------- | :------------------------------------------ |
| `titulo`      | `string` |**Obrigatório**.  Titulo do livro|
| `autor`      | `string` |**Obrigatório**.  Autor do Livro|
| `anoFabricacao`      | `string` |**Obrigatório**.  Ano de Fabricação|
| `categoria`     | `string` |**Obrigatório**.  Categoria do Livro|
| `disponibilidade`      | `string` |**Obrigatório**.  Disponibilidade do Livro


### Deletar um livro pelo id
```http
  DELETE /livros/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você deseja deletar |

## Aprendizados

Neste projeto, tive a oportunidade de aprender o básico sobre várias práticas essenciais no desenvolvimento de sistemas. Compreendi o uso de DTOs para separar as entidades do banco de dados da comunicação com o cliente, facilitando a transferência de dados. Aprendi também a importância das regras de negócio na camada de serviço, assegurando que operações como o aluguel de livros sejam realizadas de forma adequada.

Apesar de o projeto não seguir todas as boas práticas, consegui entender como implementar conceitos como o Builder, que facilita a criação de objetos de maneira mais organizada e legível. Além disso, explorei o uso de JpaRepository para a persistência de dados e o GlobalHandlerException para tratar exceções de forma centralizada. Esse aprendizado foi fundamental para entender a estrutura do código e o papel de cada componente no projeto.
## Como clonar e utilizar o repositório

#### 1. Para clonar o repositório para sua máquina local. Siga os passos abaixo:

* Abra o terminal ou prompt de comando.
* Navegue até o diretório onde você deseja armazenar o projeto.
* Execute o comando abaixo para clonar o repositório:

```bash
git clone https://github.com/duarteesamuel/api-livros
```

#### 2. Abrir o Projeto no STS (Spring Tool Suite)
Após clonar o repositório, siga os passos abaixo para abrir o projeto no Spring Tool Suite (STS):

* Abra o STS.
* No menu superior, clique em File > Import. Selecione Maven > Existing Maven Projects e clique em Next.
* Clique em Browse e navegue até o diretório onde você clonou o repositório.
*Selecione a pasta do projeto e clique em Finish.

## Feedback

#### Próximos Passos e Melhorias Futuras

Futuramente, o projeto passará por melhorias importantes, incluindo:

* Implementação de Logs: Adicionar logs para facilitar a monitoração e rastreamento de erros e eventos importantes dentro da aplicação.

* Integração com Swagger: Implementar o Swagger para documentar e testar as APIs de maneira mais interativa e amigável.

* Refatoração do Código: O código será refatorado para se tornar mais limpo e organizado, aplicando boas práticas de desenvolvimento e padrões de design.

* Lógica de Verificação de Estoque: A lógica de verificação de disponibilidade de livros em estoque será aprimorada para garantir que um livro só possa ser alugado se estiver disponível.

Essas melhorias visam tornar o projeto mais escalável, eficiente e de fácil manutenção.

#### Estou estudando Java há menos de 6 meses e estou amando cada momento dessa jornada! 😍📚 Não vejo a hora de começar minha carreira na área e aplicar tudo o que estou aprendendo! 🚀💻


