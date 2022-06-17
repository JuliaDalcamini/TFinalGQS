/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model;

/**
 *
 * @author julia
 */
public class ProdutoCesta {
    
    private String nomeProduto;
    private int quantidadeProduto;

    public ProdutoCesta(String nomeProduto, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    
    
}
