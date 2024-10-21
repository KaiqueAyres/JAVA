/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_loja;

/**
 *
 * @author Kaique
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Criação de objeto Scanner para entrada de dados (Critério 4)

        System.out.println("Bem-vindo a Loja!");
        System.out.print("Digite o nome da loja: "); 
        String nomeLoja = scanner.nextLine(); // Entrada de dados (Critério 4)
        System.out.print("Digite o endereco da loja: ");
        String enderecoLoja = scanner.nextLine(); // Entrada de dados (Critério 4)
 
        Loja loja = new Loja(nomeLoja, enderecoLoja); //Critério 1 - Criação da classe tema

        while (true) { // Estrutura de repetição infinita (Critério 4)
            System.out.println("\n====== Menu da Loja ======");
            System.out.println("1. Adicionar roupa");
            System.out.println("2. Listar produtos");
            System.out.println("3. Remover produto");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opcao: ");
            String opcao = scanner.nextLine(); // Entrada de dados (Critério 4)

            switch (opcao) { // Estrutura condicional (Critério 4)
                case "1":
                    System.out.print("Digite o nome da roupa: "); 
                    String nomeRoupa = scanner.nextLine(); // Entrada de dados (Critério 4)
                    System.out.print("Digite o preco da roupa: ");
                    double precoRoupa = Double.parseDouble(scanner.nextLine()); // Conversão de tipo (Critério 4)
                    System.out.print("Digite o tamanho da roupa: ");
                    String tamanhoRoupa = scanner.nextLine(); // Entrada de dados (Critério 4)
                    Roupa roupa = new Roupa(nomeRoupa, precoRoupa, tamanhoRoupa); // Critério 2 - Criação da superclasse e subclasses
                    loja.adicionarProduto(roupa); // Critério 7 - Encapsulamento
                    System.out.println("Roupa adicionada com sucesso!");
                    break;

                case "2": // Critério 4 - Estrutura condicional
                    loja.listarProdutos(); // Critério 4 - Estrutura condicional
                    break;

                case "3": // Critério 4 - Estrutura condicional
                    System.out.print("Digite o nome do produto que deseja remover: ");
                    String nomeProdutoRemover = scanner.nextLine();
                    loja.removerProduto(nomeProdutoRemover);
                    break;

                case "4": // Critério 4 - Estrutura condicional
                    System.out.println("Obrigado por usar o sistema da loja. Volte sempre!");
                    scanner.close();
                    return;

                default: // Critério 4 - Estrutura condicional
                    System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
            }
        }
    }
}
