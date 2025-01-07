# Gerenciador de Produtos

O **Gerenciador de Produtos** é uma aplicação Java para gerenciamento de produtos em uma loja. Ele permite adicionar, listar, atualizar, excluir e buscar produtos de forma simples e eficiente. A persistência dos dados é implementada utilizando arquivos JSON, garantindo que os dados sejam mantidos entre execuções.

## Funcionalidades

- **Adicionar Produto**: Insira informações como nome, categoria, quantidade e preço.
- **Listar Produtos**: Exiba todos os produtos cadastrados.
- **Atualizar Produto**: Modifique as informações de um produto existente.
- **Excluir Produto**: Remova um produto da lista.
- **Buscar Produto**: Pesquise produtos pelo ID.
- **Persistência de Dados**: Os produtos são salvos em um arquivo JSON (`produtos.json`), garantindo que os dados sejam mantidos mesmo após o fechamento da aplicação.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Biblioteca Gson**: Para manipulação de arquivos JSON.
- **Maven**: Gerenciador de dependências.

## Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── org.example/
│   │   │   ├── Main.java          # Ponto de entrada do programa
│   │   │   ├── controller/
│   │   │   │   ├── GerenciadorDeProdutos.java # Gerencia as operações de CRUD
│   │   │   ├── model/
│   │   │   │   ├── Produto.java   # Classe que define os atributos do Produto
│   │   │   ├── service/
│   │   │   │   ├── Persistencia.java # Gerencia a leitura e escrita do arquivo JSON
│   ├── resources/
│       └── produtos.json          # Arquivo para persistência dos dados
```

## Como Executar

1. **Clone o repositório**:

   ```bash
   git clone <url-do-repositorio>
   cd gerenciador-de-produtos
   ```

2. **Certifique-se de que o Maven esteja configurado**:

   Verifique a instalação do Maven com o comando:

   ```bash
   mvn -v
   ```

3. **Adicione a dependência Gson no `pom.xml`**:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.9.1</version>
   </dependency>
   ```

4. **Compile o projeto**:

   ```bash
   mvn compile
   ```

5. **Execute o programa**:

   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

## Exemplo de Uso

1. Escolha uma das opções do menu:

   ```plaintext
   1 - Adicionar Produto
   2 - Listar Produtos
   3 - Atualizar Produto
   4 - Excluir Produto
   5 - Buscar Produto
   6 - Sair
   ```

2. Após inserir ou modificar os dados, os produtos são automaticamente salvos no arquivo `produtos.json`.

## Contribuindo

Contribuições são bem-vindas! Se você tiver ideias para melhorar o projeto, sinta-se à vontade para criar um fork e enviar um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Contato

- **Autor**: Joseph da Costa Ribeiro  
- **E-mail**: jojojosephdacostaribeiro@gmail.com
