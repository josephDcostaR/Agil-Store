package org.example.controller;

import org.example.model.Produto;
import org.example.service.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeProdutos {
    private static List<Produto> inventario = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);


    // Carregar dados ao inicializar
    static {
        inventario = Persistencia.carregarProdutos();
    }

    public static void adicionarProduto() {
        int id = gerarIdUnico();

        System.out.print("Digite o nome do produto: ");
        String nome = teclado.nextLine();

        System.out.print("Digite a categoria do produto: ");
        String categoria = teclado.nextLine();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = teclado.nextInt();

        teclado.nextLine();

        System.out.print("Digite o preco do produto: ");
        double preco = teclado.nextDouble();

        teclado.nextLine();


        Produto produto = new Produto(id, nome, categoria, quantidade, preco);
        inventario.add(produto);
        Persistencia.salvarProdutos(inventario);
        System.out.println("Produto incluído com sucesso !");
    }

    private static int gerarIdUnico() {
        return inventario.size() + 1; // ou uma variável estática
    }

    public static void listarProdutos() {
        //metodo isEmpty verifica se a lista esta vazia
        if (inventario.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n--- Lista de Produtos ---");
            for (Produto pessoa : inventario) {
                System.out.println(pessoa);
            }
        }

        pausa();
    }

    public static void  atualizarProduto() {

        System.out.print("Digite o ID do produto a ser alterado: ");
        int id = teclado.nextInt();
        teclado.nextLine(); // limpeza buffer

        limparTela();

        //busca a pessoa especificada pelo id
        Produto produto = encontrarId(id);

        if (produto != null) {

            System.out.print("Digite o novo nome (ou deixe em branco para manter): ");
            String nome = teclado.nextLine();
            //metodo isBlank retorna true se a string estiver vazia
            //é equivalente a fazer nome.equals("");
            if (!nome.isBlank())
                produto.setNome(nome);

            System.out.print("Digite a nova categoria (ou deixe em branco para manter): ");
            String categoria = teclado.nextLine();
            if (!categoria.isBlank())
                produto.setCategoria(categoria);

            System.out.print("Digite a nova quantidade (ou deixe em branco para manter): ");
            int quantidade = teclado.nextInt();
            if (quantidade >= 0)
                produto.setQuantidade(quantidade);

            teclado.nextLine();

            System.out.print("Digite o novo preço (ou deixe em branco para manter): ");
            double preco = teclado.nextDouble();
            if (quantidade >= 0)
                produto.setPreco(preco);

            Persistencia.salvarProdutos(inventario);
            System.out.println("Produto alterado com sucesso! \n");

        } else {
            System.out.println("Produto não encontrado.");
            pausa();
        }


    }

    public static void excluirProduto() {

        //obtem o id do contato;
        System.out.print("Digite o ID do produto a ser excluído: ");
        int id = teclado.nextInt();
        teclado.nextLine(); // Consumir quebra de linha

        //encontra o contato
        Produto produto = encontrarId(id);

        //excluir o contato
        if (produto != null) {
            inventario.remove(produto);
            Persistencia.salvarProdutos(inventario);
            System.out.println("Contato excluído com sucesso! \n");

        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public static Produto encontrarProdutoPorId(int id) {

        for (Produto produto : inventario) {
            if (produto.getId() == id) {
                //encontrou retorna o objeto pessoa
                return produto;
            }
        }
        //se chegou até aqui não existe este id
        return null;
    }


    //Metodos Auxiliares
    private static Produto encontrarId(int id) {
        //varre o array list para encontrar o id pesquisado
        for (Produto pessoa : inventario) {
            if (pessoa.getId() == id) {
                //encontrou retorna o objeto pessoa
                return pessoa;
            }
        }
        //se chegou até aqui não existe este id
        return null;
    }

    private static void limparTela(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();

        } catch (IOException | InterruptedException ex) {}
    }

    private static void pausa(){
        System.out.println("\nTecle ENTER para continuar.");
        teclado.nextLine();
    }


}
