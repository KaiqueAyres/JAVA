/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ContaBancariaApp;

import java.util.Scanner; // Importa a biblioteca do pacote java.util

// Classe ContaCorrente2 que herda de ContaBancaria2
public class ContaCorrente2 extends ContaBancaria2 {
    private double taxaManutencao; // Taxa de manutenção da conta corrente
    private String nomeConta; // Nome da conta corrente
    
// Construção da classe ContaCorrente2
    public ContaCorrente2(int numeroConta, double saldoInicial, double taxaManutencao, String nomeConta) {
        super(numeroConta, saldoInicial); // Chama a construção da superclasse ContaBancaria2
        this.taxaManutencao = taxaManutencao; // Inicializa a taxa de manutenção da conta corrente
        this.nomeConta = nomeConta; // Inicializa o nome da conta corrente
    }
    
// Código para aplicar a taxa de manutenção da conta corrente
    public void aplicarTaxaManutencao() {
        if (super.obterSaldo() >= taxaManutencao) { // Verifica se o saldo é suficiente para aplicar a taxa
            super.sacar(taxaManutencao); // Realiza o saque com a taxa de manutenção
            System.out.println("Taxa de manutencao de " + taxaManutencao + " aplicada na conta " + super.getNumeroConta() + ". Novo saldo: " + super.obterSaldo());
        } else {
            System.out.println("Saldo insuficiente para aplicar taxa de manutencao na conta " + super.getNumeroConta());
        }
    }

// Código para obter o nome da conta
    public String getNomeConta() {
        return nomeConta;
    }
// Código para exibir as opções da conta corrente e interagir com o usuário
    public void opcoesContaCorrente2(Scanner scanner) {
        int escolha;
        do { // Exibe o menu de opções da conta corrente
            System.out.println("\nOpcoes da Conta Corrente:");
            System.out.println("1 - Depositar na conta corrente");
            System.out.println("2 - Sacar da conta corrente");
            System.out.println("3 - Ver saldo da conta corrente");
            System.out.println("0 - Voltar");

            escolha = scanner.nextInt(); // Lê a escolha do usuário
            double valor;

            switch (escolha) {
                case 1: // Opção para depositar na conta corrente
                    System.out.print("Valor a depositar na conta corrente: ");
                    valor = scanner.nextDouble();
                    super.depositar(valor); // Realiza o depósito na conta corrente
                    System.out.println("Deposito realizado na conta corrente. Novo saldo: " + super.obterSaldo());
                    break;
                case 2: // Opção para sacar da conta corrente
                    System.out.print("Valor a sacar da conta corrente: ");
                    valor = scanner.nextDouble();
                    if (valor > super.obterSaldo()) {
                        System.out.println("Saldo insuficiente para sacar o valor especificado.");
                    } else {
                        super.sacar(valor); // Realiza o saque da conta corrente
                        aplicarTaxaManutencao(); // Aplica a taxa de manutenção após o saque
                        System.out.println("Saque realizado na conta corrente. Novo saldo: " + super.obterSaldo());
                    }
                    break;
                case 3: // Opção para ver o saldo da conta corrente
                    System.out.println("Saldo da conta corrente: " + super.obterSaldo());
                    break;
                case 0: // Opção para voltar ao menu principal
                    System.out.println("Voltando ao menu principal...");
                    break;
                default: // Opção inválida
                    System.out.println("Opcao invalida!");
            }
        } while (escolha != 0); // Repete o loop até o usuário escolher a opção para voltar
    }
}
