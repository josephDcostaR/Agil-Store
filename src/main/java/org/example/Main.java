package org.example;

import org.example.controller.GerenciadorDeProdutos;
import org.example.model.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner teclado = new Scanner(System.in);
    private static final GerenciadorDeProdutos gerenciador = new GerenciadorDeProdutos();

    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu() {
        int opcao = -1;

        while (opcao != 6) { // A opção 6 é para sair
            String menu = """
                    1 - Adicionar Produto
                    2 - Listar Produtos
                    3 - Atualizar Produto
                    4 - Excluir Produto
                    5 - Buscar Produto
                    6 - Sair
                    """;
            System.out.println(menu);

            do {
                System.out.print("Escolha uma opção válida: ");
                try {
                    opcao = teclado.nextInt();
                    if (opcao >= 1 && opcao <= 6) {
                        break; // Opção válida, sair do loop
                    } else {
                        System.out.println("Opção fora do intervalo! Digite entre 1 e 6.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, digite apenas números.");
                    teclado.nextLine(); // Limpa o buffer do Scanner
                }
            } while (true);

            teclado.nextLine(); // Limpa o buffer após a leitura do número

            switch (opcao) {
                case 1:
                    gerenciador.adicionarProduto();
                    break;
                case 2:
                    gerenciador.listarProdutos();
                    break;
                case 3:
                    gerenciador.atualizarProduto();
                    break;
                case 4:
                    gerenciador.excluirProduto();
                    break;
                case 5:
                    buscarProduto();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void buscarProduto() {
        System.out.print("Digite o ID do produto a ser buscado: ");
        try {
            int id = teclado.nextInt();
            Produto produto = gerenciador.encontrarProdutoPorId(id);

            if (produto != null) {
                System.out.println(produto);
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! O ID deve ser um número.");
            teclado.nextLine(); // Limpa o buffer em caso de erro
        }
    }
}

