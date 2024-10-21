/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ContaBancariaApp;

import java.util.Scanner; // Importa a biblioteca do pacote java.util

// Classe ContaPoupanca2 que herda de ContaBancaria2
public class ContaPoupanca2 extends ContaBancaria2 {
    private double taxaJuros;
    private String nomeConta;
    
// Construção da classe ContaPoupanca2
    public ContaPoupanca2(int numeroConta, double saldoInicial, double taxaJuros, String nomeConta) {
        super(numeroConta, saldoInicial); // Chama a construção da superclasse ContaBancaria2
        this.taxaJuros = taxaJuros; // Inicializa a taxa de juros da conta poupança
        this.nomeConta = nomeConta; // Inicializa o nome da conta poupança
    }
    
// Código para calcular e aplicar os juros na conta poupança
    public void calcularJuros() {
        double juros = super.obterSaldo() * (taxaJuros / 100); // Calcula a taxa de juros sobre o saldo atual
        super.depositar(juros); // Realiza o depósito dos juros na conta poupança
        System.out.println("Juros de " + juros + " aplicados na conta " + super.getNumeroConta() + ". Novo saldo: " + super.obterSaldo());
    }

// Código para obter o nome da conta poupança
    public String getNomeConta() {
        return nomeConta;
    }
    
// Código para exibir as opções da conta poupança e interagir com o usuário
    public void opcoesContaPoupanca2(Scanner scanner) {
        int escolha;
        do { // Mostra o menu de opções da conta poupança
            System.out.println("\nOpcoes da Conta Poupanca:");
            System.out.println("1 - Depositar na conta poupanca");
            System.out.println("2 - Sacar da conta poupanca");
            System.out.println("3 - Ver saldo da conta poupanca");
            System.out.println("0 - Voltar");

            escolha = scanner.nextInt(); // Lê a escolha do usuário
            double valor;

            switch (escolha) {
                case 1: // Opção para depositar na conta poupança
                    System.out.print("Valor a depositar na conta poupanca: ");
                    valor = scanner.nextDouble();
                    double valorComJuros = valor + (valor * (taxaJuros / 100)); // Calcula o valor com a taxa de juros
                    super.depositar(valorComJuros); // Realiza o depósito na conta poupança
                    System.out.println("Deposito realizado na conta poupanca. Novo saldo: " + super.obterSaldo());
                    System.out.println("Juros de " + (valor * (taxaJuros / 100)) + " aplicados. Novo saldo: " + super.obterSaldo());
                    break;
                case 2: // Opção para sacar da conta poupança
                    System.out.print("Valor a sacar da conta poupanca: ");
                    valor = scanner.nextDouble();
                    if (valor > super.obterSaldo()) { 
                        System.out.println("Saldo insuficiente para sacar o valor especificado.");
                    } else {
                        super.sacar(valor); // Realiza o saque da conta poupança
                        System.out.println("Saque realizado na conta poupanca. Novo saldo: " + super.obterSaldo());
                    }
                    break;
                case 3: // Opção para ver o saldo da conta poupança
                    System.out.println("Saldo da conta poupanca: " + super.obterSaldo());
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
