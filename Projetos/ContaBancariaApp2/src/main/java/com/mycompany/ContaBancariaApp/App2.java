/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ContaBancariaApp;
import java.util.ArrayList;
import java.util.List;    // Importa a biblioteca do pacote java.util
import java.util.Scanner;

// Classe principal App2(Main) que contém o método main para executar o programa
public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para entrada de dados do teclado
        List<ContaBancaria2> contas = new ArrayList<>(); // Cria uma lista para armazenar as contas bancárias criadas


        int opcao; // Variável para armazenar a opção escolhida pelo usuário
        do { // Exibe o menu de operações disponíveis para o usuário
            System.out.println("\nEscolha a operacao desejada:");
            System.out.println("1 - Criar conta corrente");
            System.out.println("2 - Criar conta poupanca");
            System.out.println("3 - Acessar conta corrente");
            System.out.println("4 - Acessar conta poupanca");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt(); // Lê a opção escolhida

            switch (opcao) {
                case 1: // Opção para criar uma conta corrente
                    contas.add(criarContaCorrente(scanner));
                    break;
                case 2: // Opção para criar uma conta poupança
                    contas.add(criarContaPoupanca(scanner));
                    break;
                case 3: // Opção para acessar uma conta corrente existente
                    acessarContaCorrente(scanner, contas);
                    break;
                case 4: // Opção para acessar uma conta poupança existente
                    acessarContaPoupanca(scanner, contas);
                    break;
                case 0: // Opção para sair do programa
                    System.out.println("Encerrando o programa...");
                    break;
                default: // Opção inválida
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0); // Repete o loop até que o usuário escolha a opção de sair


        scanner.close(); // Fecha o objeto Scanner após o término do programa
    }

// Código para criar uma nova conta corrente
    private static ContaCorrente2 criarContaCorrente(Scanner scanner) {
        System.out.println("Criando Conta Corrente...");
        System.out.print("Numero da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        System.out.print("Taxa de manutencao: ");
        double taxaManutencao = scanner.nextDouble();
        System.out.print("Nome da conta: ");
        String nomeConta = scanner.next();

        return new ContaCorrente2(numeroConta, saldoInicial, taxaManutencao, nomeConta);
    }
    
// Código para criar uma nova conta poupança
    private static ContaPoupanca2 criarContaPoupanca(Scanner scanner) {
        System.out.println("Criando Conta Poupanca...");
        System.out.print("Numero da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        System.out.print("Taxa de juros: ");
        double taxaJuros = scanner.nextDouble();
        System.out.print("Nome da conta: ");
        String nomeConta = scanner.next();

        return new ContaPoupanca2(numeroConta, saldoInicial, taxaJuros, nomeConta);
    }
    
// Método para acessar uma conta corrente existente
    private static void acessarContaCorrente(Scanner scanner, List<ContaBancaria2> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta corrente criada ainda.");
            return;
        }
        
// Exibe as contas correntes disponíveis para o usuário escolher
        System.out.println("\nContas Correntes Disponiveis:");
        for (ContaBancaria2 conta : contas) {
            if (conta instanceof ContaCorrente2) { // Verifica se a conta é do tipo ContaCorrente2
                System.out.println(((ContaCorrente2) conta).getNumeroConta() + " - " + ((ContaCorrente2) conta).getNomeConta());
            }
        }

        System.out.print("Escolha o numero da conta corrente: ");
        int numeroConta = scanner.nextInt();

        for (ContaBancaria2 conta : contas) {
            if (conta instanceof ContaCorrente2 && conta.getNumeroConta() == numeroConta) { // Verifica se a conta corrente existe na lista
                ((ContaCorrente2) conta).opcoesContaCorrente2(scanner); // Acessa as opções da conta corrente
                return;
            }
        }

        System.out.println("Conta corrente nao encontrada.");
    }
    
// Método para acessar uma conta poupança existente
    private static void acessarContaPoupanca(Scanner scanner, List<ContaBancaria2> contas) {
        if (contas.isEmpty()) { // Verifica se não há contas poupança criadas ainda
            System.out.println("Nenhuma conta poupanca criada ainda.");
            return;
        }
        
// Exibe as contas poupanças disponíveis para o usuário escolher
        System.out.println("\nContas Poupancas Disponiveis:");
        for (ContaBancaria2 conta : contas) {
            if (conta instanceof ContaPoupanca2) {
                System.out.println(((ContaPoupanca2) conta).getNumeroConta() + " - " + ((ContaPoupanca2) conta).getNomeConta());
            }
        }

        System.out.print("Escolha o numero da conta poupanca: ");
        int numeroConta = scanner.nextInt();

        for (ContaBancaria2 conta : contas) {
            if (conta instanceof ContaPoupanca2 && conta.getNumeroConta() == numeroConta) { // Verifica se a conta poupança existe na lista
                ((ContaPoupanca2) conta).opcoesContaPoupanca2(scanner); // Acessa as opções da conta poupança
                return;
            }
        }

        System.out.println("Conta poupanca nao encontrada.");
    }
}