/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_loja;

/**
 *
 * @author Kaique
 */
import java.util.ArrayList;
import java.util.List;

public class Loja { //Criação da Classe Tema (Critério 1)
    private String nome; // Atributo para armazenar o nome da loja (Critério 3 - Atributo Específico)
    private String endereco; // Atributo para armazenar o endereço da loja (Critério 3 - Atributo Específico)
    private List<Produto> produtos; // Lista para armazenar os produtos disponíveis na loja (Critério 3 - Atributo Específico)
 
// Construção da classe Loja
    public Loja(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.produtos = new ArrayList<>(); // Criação de atributos genéricos (Critério 3)
    }
 
// Código para adicionar um produto à lista de produtos da loja
    public void adicionarProduto(Produto produto) {
        produtos.add(produto); // Encapsulamento (Critério 7)
    }

// Código para listar os produtos disponíveis na loja
    public void listarProdutos() {
        if (produtos.isEmpty()) { // Verifica se a lista de produtos está vazia (Estrutura condicional - Critério 4)
            System.out.println("Nenhum produto disponivel na loja.");
        } else {
            System.out.println("Produtos disponiveis na loja:");
            for (Produto produto : produtos) { // Percorre sobre a lista de produtos (Estrutura de repetição - Critério 4)
                System.out.println(produto); // Utiliza o método toString() para impressão do produto (Encapsulamento - Critério 7)
            }
        }
    }

// Código para remover um produto da lista 
    public void removerProduto(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) { // Verifica se o nome do produto corresponde ao nome passado (Estrutura de repetição - Critério 4)
                produtos.remove(produto); // Remove o produto da lista de produtos (Encapsulamento - Critério 7)
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto nao encontrado na loja.");
    }
}
