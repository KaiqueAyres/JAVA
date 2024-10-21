/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_loja;

/**
 *
 * @author Kaique
 */
public abstract class Produto {
    private String nome;
    private double preco;

// Construção da classe Produto
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

// Código para obter o nome do produto
    public String getNome() {
        return nome;
    }
 
// Código para obter o preço do produto
    public double getPreco() {
        return preco;
    }

    // Código abstrato para ser implementado pelas subclasses (Critério 9)
    public abstract String getDescricao();

    // Sobrescrita do método toString() para personalizar a representação do objeto (Critério 10)
    @Override
    public String toString() {
        return "Nome: " + nome + " - Preco: R$" + preco + " - " + getDescricao(); // Sobrescrita (Critério 10)
    }
}
