/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_loja;

/**
 *
 * @author Kaique
 */
public class Roupa extends Produto { // Herança (Critério 8)
    private String tamanho; // Atributo específico (Critério 3)

// Construção da classe Roupa
    public Roupa(String nome, double preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
    }

// Código para obter o tamanho da roupa (Critério 5)
    public String getTamanho() {
        return tamanho;
    }

 // Sobrescrita do método abstrato da superclasse (Critério 10)   
    public String getDescricao() {
        return "Tamanho: " + tamanho;
    }
}
