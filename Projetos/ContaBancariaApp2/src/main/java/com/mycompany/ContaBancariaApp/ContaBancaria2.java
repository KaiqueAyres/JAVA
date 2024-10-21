/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ContaBancariaApp;

import java.util.ArrayList;
import java.util.List;      //Importa as classes da biblioteca java.util
import java.util.Scanner;

// Classe para representar uma conta bancária
class ContaBancaria2 {
    private int numeroConta; //´É um atributo que armazena o numero da conta
    private double saldo; // É um atributo que armazena o saldo da conta bancária
    private static List<ContaBancaria2> contasCriadas = new ArrayList<>(); // Armazena uma lista de todas as contas bancárias criadas
    
//Construnção da classe ContaBancaria2
    
    public ContaBancaria2(int numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta; // Inicializa o número da conta
        this.saldo = saldoInicial; // Inicializa o saldo da conta
        contasCriadas.add(this); // Adiciona a conta à lista de contas criadas
    }
    
// Código para obter o número da conta
    public int getNumeroConta() {
        return numeroConta;
    }
    
// Código para obter o saldo da conta
    public double obterSaldo() {
        return saldo;
    }
    
// Código para depositar dinheiro na conta
    public void depositar(double valor) { // Adiciona o valor ao saldo da conta
        saldo += valor;
    }
    
// Código para sacar dinheiro da conta
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor; // Subtrai o valor do saldo da conta se houver saldo suficiente
        } else {
            System.out.println("Saldo insuficiente para realizar saque.");
        }
    }
    
// Código estático para obter a lista de contas criadas
    public static List<ContaBancaria2> getContasCriadas() {
        return contasCriadas;
    }
}