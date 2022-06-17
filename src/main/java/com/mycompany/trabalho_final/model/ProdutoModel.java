/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model;

/**
 *
 * @author julia
 */
public class ProdutoModel {
    
    private int idProduto;
    private String nome;
    private int quantidadeEmEstoque;
    private double precoUnitario;

    public ProdutoModel(int idProduto, String nome, int quantidadeEmEstoque, double precoUnitario) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.precoUnitario = precoUnitario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    public void incrementaEstoque(int quantidade) {
        verificaNegativo("quantidade", quantidade);
        quantidade += getQuantidadeEmEstoque();
        setQuantidadeEmEstoque(quantidade);
    }
    
    public void decrementaEstoque(int quantidade) {
        quantidade = getQuantidadeEmEstoque() - quantidade;
        verificaNegativo("estoque", quantidade);
        setQuantidadeEmEstoque(quantidade);
    }
    
    public void verificaNegativo(String nome, int numero) {
        if (numero < 0) 
            throw new RuntimeException("O campo "+nome+"não pode estar negativo.");
    }
    
    @Override
    public String toString() {
        return "Produto: " + nome
                + ", valor unitario: R$" + precoUnitario
                + ", quantidade em estoque: " + quantidadeEmEstoque;
    }
}
